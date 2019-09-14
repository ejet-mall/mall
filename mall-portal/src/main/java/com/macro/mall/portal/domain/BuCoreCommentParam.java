package com.macro.mall.portal.domain;

import com.macro.mall.model.BuCoreComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
/**
 * 评论请求参数
 */
public class BuCoreCommentParam extends BuCoreComment {

    private String clientType;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;





}
