package com.macro.mall.dao;

import com.macro.mall.dto.SmsCouponParam;
import com.macro.mall.dto.SmsCouponResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券管理自定义查询Dao
 * Created by macro on 2018/8/29.
 */
public interface SmsCouponDao {

    SmsCouponParam getItem(@Param("id") Long id);
    /**
     * 获取优惠券列表
     */
    List<SmsCouponResult> listCoupon(SmsCouponResult param);
}
