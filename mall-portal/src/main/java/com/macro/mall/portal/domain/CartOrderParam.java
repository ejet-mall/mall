package com.macro.mall.portal.domain;

import com.macro.mall.model.OmsCartItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 加购物车，并生成订单
 * Created by macro on 2018/8/30.
 */
@Data
public class CartOrderParam extends OrderParam{
    @ApiModelProperty("单个商品信息")
    OmsCartItem cartItem;
}
