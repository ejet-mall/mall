package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 生成订单时传入的参数
 * Created by macro on 2018/8/30.
 */
@Data
public class OrderParam {
    //收货地址id
    private Long memberReceiveAddressId;
    //优惠券id
    private Long couponId;
    //使用的积分数
    private Integer useIntegration;
    //支付方式
    private Integer payType;
    @ApiModelProperty("商品id集合")
    List<Long> productIds;

//    public Long getMemberReceiveAddressId() {
//        return memberReceiveAddressId;
//    }
//
//    public void setMemberReceiveAddressId(Long memberReceiveAddressId) {
//        this.memberReceiveAddressId = memberReceiveAddressId;
//    }
//
//    public Long getCouponId() {
//        return couponId;
//    }
//
//    public void setCouponId(Long couponId) {
//        this.couponId = couponId;
//    }
//
//    public Integer getPayType() {
//        return payType;
//    }
//
//    public void setPayType(Integer payType) {
//        this.payType = payType;
//    }
//
//    public Integer getUseIntegration() {
//        return useIntegration;
//    }
//
//    public void setUseIntegration(Integer useIntegration) {
//        this.useIntegration = useIntegration;
//    }
}
