package com.macro.mall.dao;


import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.dto.PmsProductCategoryWithChildrenTree;

import java.util.List;

/**
 * 商品分类自定义Dao
 */
public interface PmsProductCategoryDAO {

    List<PmsProductCategoryWithChildrenItem> listWithChildren();

    List<PmsProductCategoryWithChildrenTree> listWithArrayByLevel();

}
