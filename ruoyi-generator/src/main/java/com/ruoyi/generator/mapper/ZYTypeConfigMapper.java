package com.ruoyi.generator.mapper;

import com.ruoyi.generator.pojo.ZYTypeConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZYTypeConfigMapper {

    int insertType(ZYTypeConfig zyTypeConfig);

    int deleteType(ZYTypeConfig zyTypeConfig);

    int updateType(ZYTypeConfig zyTypeConfig);

    List<ZYTypeConfig> getTypeList(ZYTypeConfig zyTypeConfig);

    List<ZYTypeConfig> getType(@Param("typeId")String typeId);
}
