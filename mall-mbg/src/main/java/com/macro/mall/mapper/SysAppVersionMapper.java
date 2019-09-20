package com.macro.mall.mapper;

import com.macro.mall.model.SysAppVersion;
import com.macro.mall.model.SysAppVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2019/09/20
*/
public interface SysAppVersionMapper {
    long countByExample(SysAppVersionExample example);

    int deleteByExample(SysAppVersionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAppVersion record);

    int insertSelective(SysAppVersion record);

    List<SysAppVersion> selectByExample(SysAppVersionExample example);

    SysAppVersion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAppVersion record, @Param("example") SysAppVersionExample example);

    int updateByExample(@Param("record") SysAppVersion record, @Param("example") SysAppVersionExample example);

    int updateByPrimaryKeySelective(SysAppVersion record);

    int updateByPrimaryKey(SysAppVersion record);
}