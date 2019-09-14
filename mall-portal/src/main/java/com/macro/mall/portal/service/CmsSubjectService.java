package com.macro.mall.portal.service;

import com.macro.mall.dto.CmsSubjectProductResult;
import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.PmsProduct;

import java.util.List;

/**
 * 商品专题Service
 */
public interface CmsSubjectService {
    /**
     * 查询所有专题
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询专题
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);
    /**
     * 分页查询专题下商品
     */
    List<CmsSubjectProductResult> getProductList(Long subjectId, Integer pageNum, Integer pageSize);
}
