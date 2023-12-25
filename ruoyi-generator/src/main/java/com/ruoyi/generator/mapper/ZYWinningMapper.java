package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.ZyWinning;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-10-08
 */
public interface ZYWinningMapper {

    void add(ZyWinning zyWinning);

    List<String> getLotteryList(@Param("userId") String userId);
}
