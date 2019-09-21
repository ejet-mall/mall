package com.macro.mall.service;

import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.dto.PmsProductCategoryWithChildrenTree;
import com.macro.mall.model.CmsSubjectCategory;
import com.macro.mall.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品分类Service
 * Created by macro on 2018/4/26.
 */
public interface CmsSubjectCategoryService {
    @Transactional
    int create(CmsSubjectCategory categoryParam);

    @Transactional
    int update(Long id, CmsSubjectCategory categoryParam);

    int updateShowStatus(List<Long> ids, Integer showStatus);

    List<CmsSubjectCategory> getList(Integer pageSize, Integer pageNum);

    int delete(Long id);

    CmsSubjectCategory getItem(Long id);


}
