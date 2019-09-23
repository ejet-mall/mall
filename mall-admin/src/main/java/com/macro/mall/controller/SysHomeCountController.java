package com.macro.mall.controller;


import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.SysHomeCountResult;
import com.macro.mall.service.SysHomeCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 首页统计Controller
 */
@Controller
@Api(tags = "SysHomeCountController", description = "首页统计")
@RequestMapping("/home/count")
public class SysHomeCountController {

    @Autowired
    private SysHomeCountService homeCountService;

    @ApiOperation("获取首页商品订单统计信息")
    @RequestMapping(value = "/productOrder", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult productOrder() {
        SysHomeCountResult result = homeCountService.homeProductOrderCount();
        return CommonResult.success(result);
    }


}
