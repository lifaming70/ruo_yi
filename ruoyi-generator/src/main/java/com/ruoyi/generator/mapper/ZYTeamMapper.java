package com.ruoyi.generator.mapper;

import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZYTeamMapper {

    int insertTeam(@Param("userId") String userId,@Param("offlineUserId") String offlineUserId);

    List<SysUser> listUser(@Param("userId") String userId);

}
