package com.macro.mall.portal.controller;


import com.ejet.core.kernel.utils.StringUtil;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.SysParam;
import com.macro.mall.portal.service.SysParamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 系统参数接口controller
 */
@Controller
@Api(tags = "SysParamController", description = "系统参数")
@RequestMapping("/sysparam")
public class SysParamController {

    @Autowired
    SysParamService paramService;

    @ApiOperation("获取系统参数")
    @RequestMapping(value = "/getItem", method = RequestMethod.POST)
    @ResponseBody
    public Object getItem(@RequestParam(value = "paramKey", required = true) String paramKey) {
        if(StringUtil.isBlank(paramKey)) {
            return CommonResult.failed("参数缺失!");
        }
        SysParam result = paramService.getParamByKey(paramKey);
        if(result==null) {
            return CommonResult.failed("查询字典信息失败!");
        }
        return CommonResult.success(result);
    }



}
