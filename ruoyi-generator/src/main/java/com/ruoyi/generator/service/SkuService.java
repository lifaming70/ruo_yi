package com.ruoyi.generator.service;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.ZySku;

public interface SkuService {

    TableDataInfo skuAdd(ZySku zySku);

    TableDataInfo getSku(ZySku zySku);

    TableDataInfo skuUpdate(ZySku zySku);

    TableDataInfo skuDelete(ZySku zySku);
}
