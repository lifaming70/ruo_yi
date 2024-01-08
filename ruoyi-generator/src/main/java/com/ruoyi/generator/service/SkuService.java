package com.ruoyi.generator.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.ZySku;

public interface SkuService {

    AjaxResult skuAdd(ZySku zySku);

    TableDataInfo getSku(ZySku zySku);

    AjaxResult skuUpdate(ZySku zySku);

    TableDataInfo skuDelete(ZySku zySku);
}
