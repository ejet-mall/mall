package com.macro.mall.dao;

import com.macro.mall.dto.CmsSubjectProductResult;
import com.macro.mall.dto.SmsCouponParam;
import com.macro.mall.dto.SmsCouponResult;
import com.macro.mall.model.PmsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 专题自定义查询Dao
 */
public interface CmsSubjectDao {

    /**
     * 获取专题下商品信息
     */
    List<CmsSubjectProductResult> getProductList(Long subjectId);
}
