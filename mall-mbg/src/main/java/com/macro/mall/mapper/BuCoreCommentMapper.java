package com.macro.mall.mapper;

import com.macro.mall.model.BuCoreComment;
import com.macro.mall.model.BuCoreCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2019/09/16
*/
public interface BuCoreCommentMapper {
    long countByExample(BuCoreCommentExample example);

    int deleteByExample(BuCoreCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BuCoreComment record);

    int insertSelective(BuCoreComment record);

    List<BuCoreComment> selectByExampleWithBLOBs(BuCoreCommentExample example);

    List<BuCoreComment> selectByExample(BuCoreCommentExample example);

    BuCoreComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BuCoreComment record, @Param("example") BuCoreCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") BuCoreComment record, @Param("example") BuCoreCommentExample example);

    int updateByExample(@Param("record") BuCoreComment record, @Param("example") BuCoreCommentExample example);

    int updateByPrimaryKeySelective(BuCoreComment record);

    int updateByPrimaryKeyWithBLOBs(BuCoreComment record);

    int updateByPrimaryKey(BuCoreComment record);
}