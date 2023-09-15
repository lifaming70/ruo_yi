package com.ruoyi.generator.service;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.pojo.ZYArticle;
import com.ruoyi.generator.pojo.ZYTypeConfig;

public interface ArticleService {

      TableDataInfo articleCrud(ZYArticle zyArticle, String type);

      TableDataInfo articleTypeCrud(ZYTypeConfig zyTypeConfig, String type);
}
