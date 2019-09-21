package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.CmsSubjectCategory;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.service.CmsSubjectCategoryService;
import com.macro.mall.service.CmsSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专题分类Controller
 */
@Controller
@Api(tags = "CmsSubjectCategoryController", description = "商品专题分类管理")
@RequestMapping("/subjectCategory")
public class CmsSubjectCategoryController {
    @Autowired
    private CmsSubjectCategoryService cmsSubjectCategoryService;

    @ApiOperation("添加专题分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('cms:subjectCategory:create')")
    public CommonResult create(@Validated @RequestBody CmsSubjectCategory categoryParam,
                               BindingResult result) {
        int count = cmsSubjectCategoryService.create(categoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改专题分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('cms:subjectCategory:update')")
    public CommonResult update(@PathVariable Long id,
                               @Validated
                               @RequestBody CmsSubjectCategory categoryParam,
                               BindingResult result) {
        int count = cmsSubjectCategoryService.update(id, categoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('cms:subjectCategory:update')")
    public CommonResult updateShowStatus(@RequestParam("ids") List<Long> ids, @RequestParam("showStatus") Integer showStatus) {
        int count = cmsSubjectCategoryService.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询专题分类")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
//    @PreAuthorize("hasAuthority('cms:subjectCategory:read')")
    public CommonResult<CommonPage<CmsSubjectCategory>> getList(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CmsSubjectCategory> categoryList = cmsSubjectCategoryService.getList(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(categoryList));
    }

    @ApiOperation("根据id获取专题分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('cms:subjectCategory:read')")
    public CommonResult<CmsSubjectCategory> getItem(@PathVariable Long id) {
        CmsSubjectCategory subjectCategory = cmsSubjectCategoryService.getItem(id);
        return CommonResult.success(subjectCategory);
    }

    @ApiOperation("删除专题分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('cms:subjectCategory:delete')")
    public CommonResult delete(@PathVariable Long id) {
        int count = cmsSubjectCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
