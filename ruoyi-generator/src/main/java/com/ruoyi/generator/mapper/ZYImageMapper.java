package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.ZyImage;

import java.util.List;

public interface ZYImageMapper {

    void imageAdd(List<ZyImage> list);

    List<ZyImage> getImage(List<String> list);
}
