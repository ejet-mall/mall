package com.macro.mall.dto;

import com.macro.mall.model.PmsProduct;
import lombok.Data;

/**
 * 查询专题下商品信息， 返回的结果
 */
@Data
public class CmsSubjectProductResult extends PmsProduct {

    private Long subjectId;

}
