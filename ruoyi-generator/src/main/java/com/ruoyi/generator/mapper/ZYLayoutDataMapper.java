package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.ZYLayout;
import com.ruoyi.generator.domain.ZYLayoutData;

import java.util.List;

public interface ZYLayoutDataMapper {

    int insertLayoutDateList(List<ZYLayoutData> list);

    List<ZYLayoutData> getLayoutData(List<ZYLayout> list);

    int updateZyLayoutData(List<ZYLayoutData> list);

    void deleteZyLayoutData(List<ZYLayout> goZyLayout);
}
