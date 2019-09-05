package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
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
 * 商品评论Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "BuCommentController", description = "商品评论管理")
@RequestMapping("/productComment")
public class BuCommentController {
    @Autowired
    private BuCoreCommentService buCoreCommentService;

    @ApiOperation("添加产品评论")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('bu:productComment:create')")
    public CommonResult create(@Validated @RequestBody BuCoreCommentParam productCategoryParam,
                         BindingResult result) {
        int count = buCoreCommentService.create(productCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改商品评论")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('bu:productComment:update')")
    public CommonResult update(@PathVariable Long id,
                         @Validated
                         @RequestBody BuCoreCommentParam commentParam,
                         BindingResult result) {
        int count = buCoreCommentService.update(id, commentParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询商品评论")
    @RequestMapping(value = "/list/{productId}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('bu:productComment:read')")
    public CommonResult<CommonPage<BuCoreCommentResult>> getList(@PathVariable BuCoreCommentParam queryParam,
                                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BuCoreCommentResult> productCommentList = buCoreCommentService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productCommentList));
    }

    @ApiOperation("根据id获取商品评论")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('bu:productComment:read')")
    public CommonResult<BuCoreCommentResult> getItem(@PathVariable Long id) {
        BuCoreCommentResult productCategory = buCoreCommentService.getItem(id);
        return CommonResult.success(productCategory);
    }

    @ApiOperation("删除商品评论")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('bu:productComment:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = buCoreCommentService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
