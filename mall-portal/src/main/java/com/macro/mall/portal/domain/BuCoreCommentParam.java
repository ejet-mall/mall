package com.macro.mall.portal.domain;

import com.macro.mall.model.BuCoreComment;
import lombok.Data;

@Data
/**
 * 评论请求参数
 */
public class BuCoreCommentParam extends BuCoreComment {

    private String clientType;

}
