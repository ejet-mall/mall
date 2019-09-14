package com.macro.mall.portal.service.impl;

import com.ejet.api.sms.alibaba.SmsFactory;
import com.ejet.api.sms.alibaba.SmsRequest;
import com.ejet.api.sms.alibaba.SmsResponse;
import com.ejet.core.kernel.api.ResultCode;
import com.ejet.core.kernel.exception.CoBusinessException;
import com.ejet.core.kernel.utils.RandomUtil;
import com.ejet.core.kernel.utils.StringUtil;
import com.ejet.core.kernel.utils.encrypt.MD5Coder;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.UmsMemberLevelMapper;
import com.macro.mall.mapper.UmsMemberLoginLogMapper;
import com.macro.mall.mapper.UmsMemberMapper;
import com.macro.mall.model.*;
import com.macro.mall.portal.auth.TokenHelper;
import com.macro.mall.portal.constant.PortalConstant;
import com.macro.mall.portal.domain.MemberDetails;
import com.macro.mall.portal.domain.MemberParam;
import com.macro.mall.portal.service.RedisService;
import com.macro.mall.portal.service.UmsMemberService;
import com.macro.mall.portal.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 会员管理Service实现类
 * Created by macro on 2018/8/3.
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsMemberServiceImpl.class);
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Autowired
    private RedisService redisService;
    @Value("${def-redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${def-redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsMemberLoginLogMapper loginLogMapper;

    @Override
    public UmsMember getByUsername(String username) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }

    @Override
    public UmsMember getByPhone(String phone) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(phone);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }

    @Override
    public UmsMember getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonResult register(String username, String password, String telephone, String authCode) {
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            return CommonResult.failed("验证码错误");
        }
        //查询是否已有该用户
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneEqualTo(telephone));
        List<UmsMember> umsMembers = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(umsMembers)) {
            return CommonResult.failed("该用户已经存在");
        }
        //没有该用户进行添加操作
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPhone(telephone);
        //umsMember.setPassword(passwordEncoder.encode(password));
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);
        //获取默认会员等级并设置
        UmsMemberLevelExample levelExample = new UmsMemberLevelExample();
        levelExample.createCriteria().andDefaultStatusEqualTo(1);
        List<UmsMemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
        if (!CollectionUtils.isEmpty(memberLevelList)) {
            umsMember.setMemberLevelId(memberLevelList.get(0).getId());
        }
        memberMapper.insert(umsMember);
        umsMember.setPassword(null);
        return CommonResult.success(null,"注册成功");
    }

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(),"获取验证码成功");
    }

    @Override
    public CommonResult updatePassword(String telephone, String password, String authCode) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            return CommonResult.failed("该账号不存在");
        }
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            return CommonResult.failed("验证码错误");
        }
        UmsMember umsMember = memberList.get(0);
        //umsMember.setPassword(passwordEncoder.encode(password));
        umsMember.setPassword(MD5Coder.getMD5(password));
        memberMapper.updateByPrimaryKeySelective(umsMember);
        return CommonResult.success(null,"密码修改成功");
    }

    @Override
    public CommonResult updateUser(MemberParam memberParam, String authCode) {
        UmsMember currentMember = getCurrentMember();
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(currentMember.getPhone());
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            return CommonResult.failed("该账号不存在");
        }
        //验证验证码
        if(!verifyAuthCode(authCode, currentMember.getPhone())){
            return CommonResult.failed("验证码错误");
        }
        UmsMember umsMember = memberList.get(0);
        umsMember.setPassword(MD5Coder.getMD5(memberParam.getPassword()));
        umsMember.setUsername(memberParam.getUsername());
        umsMember.setNickname(memberParam.getNickname());
        umsMember.setBirthday(memberParam.getBirthday());
        umsMember.setGender(memberParam.getGender());
        umsMember.setPersonalizedSignature(memberParam.getPersonalizedSignature());
        umsMember.setCity(memberParam.getCity());
        umsMember.setIcon(memberParam.getIcon());
        umsMember.setJob(memberParam.getJob());

        memberMapper.updateByPrimaryKeySelective(umsMember);
        return CommonResult.success(null,"修改用户信息成功");
    }

    @Override
    public MemberDetails getCurrentMemberDetail() {
        MemberDetails details = null;
        try {
            details = TokenHelper.getCurrentUser(MemberDetails.class);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return details;
    }

    @Override
    public UmsMember getCurrentMember() {
        MemberDetails details = getCurrentMemberDetail();
        return details.getUmsMember();
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember record=new UmsMember();
        record.setId(id);
        record.setIntegration(integration);
        memberMapper.updateByPrimaryKeySelective(record);
    }

    //对输入的验证码进行校验
    private boolean verifyAuthCode(String authCode, String telephone){
        if(StringUtils.isEmpty(authCode)){
            return false;
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        return authCode.equals(realAuthCode);
    }

    /**
     * 生成并发送验证码
     */
    public String sendAuthCode(String telephone) {
        String code = RandomUtil.getRandomNumbers(6);

        SmsRequest req = new SmsRequest();
        req.setPhone(telephone);
        //req.setSignName("");
        SmsResponse codeResult = SmsFactory.sendSms(req);
        if("OK".equalsIgnoreCase(codeResult.getCode())) {
            // 验证码绑定手机号并存储到redis
            redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, code);
            redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        } else {
            // 验证码绑定手机号并存储到redis
            redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, code);
            redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
            return code;
        }
        return code;
    }

    /**
     * 添加登录记录
     */
    private void insertLoginLog(UmsMember user) {
        UmsMemberLoginLog loginLog = new UmsMemberLoginLog();
        loginLog.setMemberId(user.getId());
        loginLog.setPhone(user.getPhone());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }

    @Override
    public CommonResult login(String phone, String password) {
        CommonResult result = null;
        //密码需要客户端加密后传递
        try {
            if(StringUtil.isBlank(phone)) {
                throw new CoBusinessException(ResultCode.PARAM_MISSING); // "用户名为空!"
            }
            if(StringUtil.isBlank(password)) {
                throw new CoBusinessException(ResultCode.PARAM_MISSING); // "密码为空!"
            }
            UmsMember userMember = getByPhone(phone);
            if(userMember==null){
                throw new CoBusinessException("用户尚未注册!");
            }
            String md5 = MD5Coder.getMD5(password);
            if(!md5.equals(userMember.getPassword())) {
                throw new CoBusinessException("用户密码错误!");
            }
            String jwtToken = jwtTokenUtil.generateToken(userMember);
            insertLoginLog(userMember);
//            Map<String, String> tokenMap = new HashMap<>();
//            tokenMap.put("token", jwtToken);
//            tokenMap.put("tokenHead", tokenHead);
            userMember.setPassword(null);
            MemberDetails details = new MemberDetails(userMember);
            details.setTokenHead(tokenHead);
            details.setToken(jwtToken);

            TokenHelper.cacheToken(jwtToken, details, PortalConstant.TOKEN_KEY_TIMEOUT);

            result = CommonResult.success(details);
        } catch (CoBusinessException e) {
            result = CommonResult.validateFailed(e.getMessage());
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return result;
    }

    @Override
    public String refreshToken(String oldToken) {
        String token = oldToken.substring(tokenHead.length());
        if (jwtTokenUtil.canRefresh(token)) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }


    @Override
    public CommonResult logout() {
        CommonResult result = null;
        MemberDetails details = getCurrentMemberDetail();
        if(details==null || details.getToken()==null) {
            result = CommonResult.failed("退出登录失败!");
        } else {
            TokenHelper.delToken(details.getToken());
            result = CommonResult.success("退出成功!");
        }
        return result;
    }




}
