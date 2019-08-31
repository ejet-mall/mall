package com.macro.mall.portal.service;

import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品分类Service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductCategoryService {

    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    PmsProductCategory getItem(Long id);

    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
