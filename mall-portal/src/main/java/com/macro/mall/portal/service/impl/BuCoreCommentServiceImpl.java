package com.macro.mall.portal.service.impl;

import com.ejet.core.kernel.exception.CoBusinessException;
import com.ejet.core.kernel.utils.DateUtil;
import com.ejet.core.kernel.utils.HttpServletRequestUtil;
import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.BuCoreCommentMapper;
import com.macro.mall.mapper.OmsOrderItemMapper;
import com.macro.mall.model.*;
import com.macro.mall.portal.auth.TokenHelper;
import com.macro.mall.portal.dao.BuCoreCommentDao;
import com.macro.mall.portal.domain.BuCoreCommentParam;
import com.macro.mall.portal.domain.BuCoreCommentResult;
import com.macro.mall.portal.domain.MemberDetails;
import com.macro.mall.portal.service.BuCoreCommentService;
import com.macro.mall.portal.service.UmsMemberService;
import com.macro.mall.portal.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class BuCoreCommentServiceImpl implements BuCoreCommentService {

    @Autowired
    private BuCoreCommentMapper buCoreCommentMapper;
    @Autowired
    private BuCoreCommentDao buCoreCommentDao;
    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private OmsOrderItemMapper orderItemMapper;

    @Override
    public int create(BuCoreCommentParam productParam) {
        int count  = 0;
        UmsMember member = memberService.getCurrentMember();
        productParam.setUserId(member.getId());
        productParam.setUserNickName(StringUtils.isEmpty(productParam.getUserNickName()) ? member.getNickname() : productParam.getUserNickName());
        productParam.setPhone(member.getPhone());
        productParam.setUserIcon(StringUtils.isEmpty(productParam.getUserIcon()) ? member.getIcon() : productParam.getUserIcon());

        productParam.setCreateTime(new Date());
        productParam.setUpdateTime(productParam.getCreateTime());
        productParam.setShowStatus(1); //1:展示 2：不展示'

        //更改状态为已经评论
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(productParam.getOrderId())
                .andProductIdEqualTo(productParam.getProductId());

        OmsOrderItem orderItem = new OmsOrderItem();
        orderItem.setCommentStatus(1); // 已评价
        orderItemMapper.updateByExampleSelective(orderItem, example);

        count = buCoreCommentMapper.insert(productParam);
        return count;
    }

    @Override
    public BuCoreCommentResult getUpdateInfo(Long id) {
        return null;
    }

    @Override
    public BuCoreCommentResult getItem(Long id) {
        return buCoreCommentDao.getItem(id);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(Long id, BuCoreCommentParam productParam) {
        return 0;
    }

    @Override
    public List<BuCoreCommentResult> list(BuCoreCommentParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        BuCoreCommentExample example = new BuCoreCommentExample();
        BuCoreCommentExample.Criteria criteria = example.createCriteria();
        criteria.andShowStatusEqualTo(1);
        if (queryParam.getUserId()!=null) {
            criteria.andUserIdEqualTo(queryParam.getUserId());
        }
        //用于查询自己
        if (queryParam.getPhone()!= null) {
            criteria.andPhoneEqualTo(queryParam.getPhone());
        }
        if (queryParam.getUserId()!= null) {
            criteria.andUserIdEqualTo(queryParam.getUserId());
        }
        if (queryParam.getProductId()!= null) {
            criteria.andProductIdEqualTo(queryParam.getProductId());
        }
        return buCoreCommentDao.listWithDetail(example);
    }

    @Override
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        return 0;
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        return 0;
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return 0;
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        return 0;
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        return 0;
    }

    @Override
    public List<PmsProduct> list(String keyword) {
        return null;
    }
}
