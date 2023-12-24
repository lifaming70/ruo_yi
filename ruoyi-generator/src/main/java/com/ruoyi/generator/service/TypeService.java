package com.ruoyi.generator.service;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.ZYTypeConfig;

public interface TypeService {

    TableDataInfo typeCrud( ZYTypeConfig zyTypeConfig, String type);

}
