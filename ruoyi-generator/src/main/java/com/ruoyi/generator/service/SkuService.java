package com.ruoyi.generator.service;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.pojo.ZySku;

public interface SkuService {

    TableDataInfo skuAdd(ZySku zySku);

    TableDataInfo getSku(ZySku zySku);
}
