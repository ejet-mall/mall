package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.dto.PmsProductCategoryWithChildrenTree;

import java.util.List;

/**
 * 商品分类自定义Dao
 * Created by macro on 2018/5/25.
 */
public interface PmsProductCategoryDao {
    List<PmsProductCategoryWithChildrenItem> listWithChildren();

    List<PmsProductCategoryWithChildrenTree> listWithArray();
}
