package com.ruoyi.generator.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.ZYArticle;
import com.ruoyi.generator.mapper.ZYArticleMapper;
import com.ruoyi.generator.service.ArticleService;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ZYArticleMapper zyArticleMapper;

    @Override
    public TableDataInfo articleCrud(ZYArticle zyArticle, String type) {

        String values = JSONObject.parseObject(type).get("type").toString();

        switch (values) {
            case "1":
                zyArticleMapper.insertArticle(zyArticle);
                break;
            case "2":
                zyArticleMapper.deleteArticle(zyArticle.getArticleIds());
                break;
            case "3":
                zyArticleMapper.updateArticle(zyArticle);
                break;
            case "4":
                PageHelper.startPage(zyArticle.getPageNumber(),zyArticle.getPageSize());
                List<ZYArticle> list = zyArticleMapper.getArticleList(zyArticle);

                return Result.getDataTable(list);
            case "5":
                List<ZYArticle>  articles = zyArticleMapper.getArticle(zyArticle.getArticleId());

                return Result.getDataTable(articles);
        }

        return Result.getDataTable();
    }
}
