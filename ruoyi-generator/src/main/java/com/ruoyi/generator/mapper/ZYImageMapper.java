package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.ZyImage;
import com.ruoyi.generator.domain.ZySku;

import java.util.List;

public interface ZYImageMapper {

    void imageAdd(List<ZyImage> list);

    List<ZyImage> getImage(List<String> list);

    List<ZyImage> getImages(List<ZySku> list);

    void update(List<ZyImage> images);
}
