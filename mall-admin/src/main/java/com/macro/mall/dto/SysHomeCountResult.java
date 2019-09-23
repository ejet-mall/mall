package com.macro.mall.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysHomeCountResult implements Serializable {

    /** 商品下架数 */
    private Integer productPublishOff;
    /** 商品上架数 */
    private Integer productPublishOn;
    /** 全部商品数 */
    private Integer productTotal;
    /** 商品库存紧张数 */
    private Integer productSkuLess;

    /** 订单待付款数 */
    private Integer orderWaitPay;
    /** 订单1->待发货 */
    private Integer orderWaitDeliver;
    /**订单2->已发货*/
    private Integer orderDelived;
    /** 订单3->已完成 */
    private Integer orderOver;
    /** 订单45->已关闭取消 */
    private Integer orderCanceled;

    /** 订单->当日订单数 */
    private Integer orderCountToday;
    /** 订单->当日销售金额 */
    private Float orderSaleFeeToday;
    /** 订单->昨日销售 */
    private Float orderSaleFeeYesterday;


    /** 当日新增用户 */
    private Integer memberAddToday;
    /** 昨日新增 */
    private Integer memberAddYesterday;
    /** 本月新增 */
    private Integer memberAddMonth;
    /** 总用户 */
    private Integer memberTotal;


}
