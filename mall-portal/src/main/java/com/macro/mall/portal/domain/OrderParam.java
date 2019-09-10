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
    @ApiModelProperty("收货地址id")
    private Long memberReceiveAddressId;
    @ApiModelProperty("优惠券id")
    private Long couponId;
    @ApiModelProperty("使用的积分数")
    private Integer useIntegration;
    @ApiModelProperty("支付方式")
    private Integer payType;
    @ApiModelProperty("购物车id集合")
    List<Long> cartIds;

}
