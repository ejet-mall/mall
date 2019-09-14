package com.macro.mall.portal.service;

import com.github.pagehelper.PageInfo;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.OmsOrderQueryParam;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.portal.domain.CartOrderParam;
import com.macro.mall.portal.domain.ConfirmOrderResult;
import com.macro.mall.portal.domain.OmsOrderDetail;
import com.macro.mall.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderService {
    /**
     * 根据用户购物车信息生成确认单信息
     */
    ConfirmOrderResult generateConfirmOrder();

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 生成订单
     */
    @Transactional
    CommonResult generateCustomOrder(OrderParam orderParam);
    /**
     * 1加购物车， 2生成订单
     */
    CommonResult generateCartOrder(CartOrderParam orderParam) throws Exception;

    /**
     * 支付成功后的回调
     */
    @Transactional
    CommonResult paySuccess(Long orderId);

    /**
     * 自动取消超时订单
     */
    @Transactional
    CommonResult cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);



    /**
     * 订单查询
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    CommonPage<OmsOrderDetail> orderslist(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 获取指定订单详情
     */
    OmsOrderDetail detail(Long id);


}
