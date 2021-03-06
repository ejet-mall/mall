package com.macro.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dao.SmsCouponDao;
import com.macro.mall.dto.SmsCouponParam;
import com.macro.mall.dto.SmsCouponResult;
import com.macro.mall.mapper.SmsCouponMapper;
import com.macro.mall.model.*;
import com.macro.mall.portal.service.SmsCouponService;
import com.macro.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 优惠券管理Service实现类
 */
@Service
public class SmsCouponServiceImpl implements SmsCouponService {
    @Autowired
    private SmsCouponMapper couponMapper;
    @Autowired
    private SmsCouponDao couponDao;
    @Autowired
    private UmsMemberService memberService;

    @Override
    public List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum) {
        SmsCouponExample example = new SmsCouponExample();
        SmsCouponExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(name)){
            criteria.andNameLike("%"+name+"%");
        }
        if(type!=null){
            criteria.andTypeEqualTo(type);
        }
        PageHelper.startPage(pageNum,pageSize);
        return couponMapper.selectByExample(example);
    }

    @Override
    public SmsCouponParam getItem(Long id) {
        return couponDao.getItem(id);
    }


    @Override
    public List<SmsCouponResult> listCoupon(Integer useStatus) {
        UmsMember member = memberService.getCurrentMember();
        SmsCouponResult r = new SmsCouponResult();
        r.setMemberId(member.getId());
        r.setUseStatus(useStatus);
        return couponDao.listCoupon(r);
    }


}
