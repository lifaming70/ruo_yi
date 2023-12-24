package com.ruoyi.generator.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

public interface PromotionService {

    AjaxResult promotion(String userId, String phone);

    AjaxResult offline(String phone);

    TableDataInfo team(String userId);
}
