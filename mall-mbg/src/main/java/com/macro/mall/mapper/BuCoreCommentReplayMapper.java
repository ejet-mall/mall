package com.macro.mall.mapper;

import com.macro.mall.model.BuCoreCommentReplay;
import com.macro.mall.model.BuCoreCommentReplayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2019/09/06
*/
public interface BuCoreCommentReplayMapper {
    long countByExample(BuCoreCommentReplayExample example);

    int deleteByExample(BuCoreCommentReplayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BuCoreCommentReplay record);

    int insertSelective(BuCoreCommentReplay record);

    List<BuCoreCommentReplay> selectByExampleWithBLOBs(BuCoreCommentReplayExample example);

    List<BuCoreCommentReplay> selectByExample(BuCoreCommentReplayExample example);

    BuCoreCommentReplay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BuCoreCommentReplay record, @Param("example") BuCoreCommentReplayExample example);

    int updateByExampleWithBLOBs(@Param("record") BuCoreCommentReplay record, @Param("example") BuCoreCommentReplayExample example);

    int updateByExample(@Param("record") BuCoreCommentReplay record, @Param("example") BuCoreCommentReplayExample example);

    int updateByPrimaryKeySelective(BuCoreCommentReplay record);

    int updateByPrimaryKeyWithBLOBs(BuCoreCommentReplay record);

    int updateByPrimaryKey(BuCoreCommentReplay record);
}