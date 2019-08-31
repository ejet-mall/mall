package com.macro.mall.dto;

import com.macro.mall.model.PmsProductCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macro on 2018/5/25.
 */
public class PmsProductCategoryWithChildrenTree extends PmsProductCategory {

    private List<PmsProductCategoryWithChildrenTree> children = new ArrayList<>();

    public List<PmsProductCategoryWithChildrenTree> getChildren() {
        return children;
    }

}
