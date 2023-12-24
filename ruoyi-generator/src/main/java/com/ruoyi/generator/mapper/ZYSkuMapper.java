package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.ZySku;

import java.util.List;

public interface ZYSkuMapper {

    void skuAdd(ZySku zySku);

    List<ZySku> getSku(ZySku zySku);

    void updateSku(ZySku zySku);

    void deleteSkus(List<String> list);
}
