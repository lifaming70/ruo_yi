package com.ruoyi.generator.service;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.pojo.ZYArticle;

public interface ArticleService {

      TableDataInfo articleCrud(ZYArticle zyArticle, String type);

}
