package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderPromotionParam {
    /**
     * 使用可用:0->不可用；1->可用
     */
    private Integer type;
    //优惠券id
    private Long couponId;
    //支付方式
    private Integer payType;
    @ApiModelProperty("商品id集合")
    List<Long> productIds;

}
