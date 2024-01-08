package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.ZYLayout;
import com.ruoyi.generator.domain.ZYText;

import java.util.List;

public interface ZYTextMapper {

    int insertLayoutTextList(List<ZYText> list);

    List<ZYText> getText(List<ZYLayout> list);

    int updateZyText(List<ZYText> list);

    void deleteZyText(List<ZYLayout> arrangeZyLayout);
}
