package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.ZYArticle;
import com.ruoyi.generator.domain.ZYLayout;

import java.util.List;

public interface ZYLayoutMapper {

    int insertLayoutList(List<ZYLayout> list);

    List<ZYLayout> getLayoutList(List<ZYArticle> list);

    List<ZYLayout> getLayoutListString(List<String> list);

    int updateZyLayout(List<ZYLayout> list);

    void deleteZyLayout(List<ZYLayout> layoutList);
}
