package com.macro.mall.portal.dao;

import com.macro.mall.model.BuCoreCommentExample;
import com.macro.mall.portal.domain.BuCoreCommentResult;

import java.util.List;

/**
 */
public interface BuCoreCommentDao {

    List<BuCoreCommentResult> listWithDetail(BuCoreCommentExample example);

    BuCoreCommentResult getItem(Long id);

}
