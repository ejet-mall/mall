package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.MemberParam;
import com.macro.mall.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 会员登录注册管理Controller
 * Created by Ejet on 2019/8/28.
 */
@Controller
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telephone,
                                 @RequestParam String authCode) {
        return memberService.register(username, password, telephone, authCode);
    }

    @ApiOperation("发送验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "电话号码", dataType = "String"),
            @ApiImplicitParam(name = "type", value = "短信类型：1：注册短信 2：密码重置", dataType = "Integer")
    }
    )
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone, @RequestParam Integer type) {
        String code = memberService.sendAuthCode(telephone, type);
        if(code==null) {
            return CommonResult.failed("发送验证码失败!");
        }
        return CommonResult.success(code, "发送成功!");
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                 @RequestParam String password,
                                 @RequestParam String authCode) {
        return memberService.updatePassword(telephone,password,authCode);
    }

    @ApiOperation("修改用户信息")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateUser(@RequestBody MemberParam memberParam) {
        return memberService.updateUser(memberParam, null);
    }

    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam String telephone,
                                 @RequestParam String password) {
        return memberService.login(telephone, password);
    }

    @ApiOperation("退出")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return memberService.logout();
    }

}
