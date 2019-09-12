package com.macro.mall.portal.domain;

import com.macro.mall.model.BuCoreComment;
import com.macro.mall.model.PmsSkuStock;
import lombok.Data;

import java.util.List;

/**
 * 评论返回前端结果
 */
@Data
public class BuCoreCommentResult extends BuCoreComment {

    /** 平均星级 */
    private Integer avgStar;
    /** 总评论数 */
    private Integer totalNumber;


}
