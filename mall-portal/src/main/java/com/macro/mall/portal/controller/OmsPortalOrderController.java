package com.macro.mall.portal.controller;

import com.ejet.core.kernel.utils.IOUtil;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.CartOrderParam;
import com.macro.mall.portal.domain.ConfirmOrderResult;
import com.macro.mall.portal.domain.OrderParam;
import com.macro.mall.portal.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理Controller
 * Created by Ejet on 2019/8/28.
 */
@Slf4j
@Controller
@Api(tags = "OmsPortalOrderController",description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;
    @ApiOperation("根据购物车信息生成确认单信息")
    @RequestMapping(value = "/generateConfirmOrder",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ConfirmOrderResult> generateConfirmOrder(){
        ConfirmOrderResult confirmOrderResult = portalOrderService.generateConfirmOrder();
        return CommonResult.success(confirmOrderResult);
    }

    @ApiOperation("生成订单")
    @RequestMapping(value = "/generateCustomOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateCustomOrder(@RequestBody OrderParam orderParam){
        return portalOrderService.generateCustomOrder(orderParam);
    }

    @ApiOperation("加购物车-->并生成订单")
    @RequestMapping(value = "/generateCartOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateCartOrder(@RequestBody CartOrderParam orderParam){
        CommonResult result = null;
        try {
            result = portalOrderService.generateCartOrder(orderParam);
        }catch (Exception e) {
            log.error("", e);
            result = CommonResult.failed(IOUtil.getError(e));
        }
        return result;
    }
    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam){
        return portalOrderService.generateOrder(orderParam);
    }
    @ApiOperation("支付成功的回调")
    @RequestMapping(value = "/paySuccess",method = RequestMethod.POST)
    @ResponseBody
    public Object paySuccess(@RequestParam Long orderId){
        return portalOrderService.paySuccess(orderId);
    }

    @ApiOperation("自动取消超时订单")
    @RequestMapping(value = "/cancelTimeOutOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object cancelTimeOutOrder(){
        return portalOrderService.cancelTimeOutOrder();
    }

    @ApiOperation("取消单个超时订单")
    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelOrder(Long orderId){
        portalOrderService.sendDelayMessageCancelOrder(orderId);
        return CommonResult.success(null);
    }
}
