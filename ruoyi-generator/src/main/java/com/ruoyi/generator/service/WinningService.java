package com.ruoyi.generator.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.bind.annotation.RequestBody;

public interface WinningService {

    AjaxResult getPrize(String userId);

    TableDataInfo coupon(String userId);
}
