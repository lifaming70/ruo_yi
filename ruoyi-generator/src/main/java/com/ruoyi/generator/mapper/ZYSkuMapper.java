package com.ruoyi.generator.mapper;

import com.ruoyi.generator.pojo.ZySku;

import java.util.List;

public interface ZYSkuMapper {

    void skuAdd(ZySku zySku);

    List<ZySku> getSku(ZySku zySku);
}
