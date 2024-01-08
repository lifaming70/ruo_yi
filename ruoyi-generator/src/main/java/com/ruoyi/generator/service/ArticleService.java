package com.ruoyi.generator.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.ZYArticle;

public interface ArticleService {

      AjaxResult articleAdd(ZYArticle zyArticle);

      AjaxResult articleUpdate(ZYArticle zyArticle);

      AjaxResult delete(ZYArticle zyArticle);

      TableDataInfo getList(ZYArticle zyArticle);

}
