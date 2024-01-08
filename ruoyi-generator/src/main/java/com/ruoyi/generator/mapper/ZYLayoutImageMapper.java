package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.ZYLayout;
import com.ruoyi.generator.domain.ZYLayoutImage;

import java.util.List;

public interface ZYLayoutImageMapper {

    int insertLayoutImageList(List<ZYLayoutImage> list);

    List<ZYLayoutImage> getLayoutImage(List<ZYLayout> list);

    int updateZyLayoutImage(List<ZYLayoutImage> list);

    void deleteZyLayoutImage(List<ZYLayout> arrangeZyLayout);
}
