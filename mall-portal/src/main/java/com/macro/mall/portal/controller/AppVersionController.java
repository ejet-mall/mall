package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.SysAppVersionMapper;
import com.macro.mall.model.SysAppVersion;
import com.macro.mall.model.SysAppVersionExample;
import com.macro.mall.portal.domain.BuCoreCommentParam;
import com.macro.mall.portal.domain.BuCoreCommentResult;
import com.macro.mall.portal.service.BuCoreCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * app版本信息
 */
@Controller
@Api(tags = "AppVersionController", description = "app最新版本")
@RequestMapping("/app_version")
public class AppVersionController {
    @Autowired
    private SysAppVersionMapper mapper;

    @ApiOperation("获取最新版本")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getVersion() {
        SysAppVersionExample example = new SysAppVersionExample();
        List<SysAppVersion> list = mapper.selectByExample(example);
        return CommonResult.success(list);
    }


}
