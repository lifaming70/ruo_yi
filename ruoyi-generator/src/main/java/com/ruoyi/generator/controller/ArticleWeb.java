package com.ruoyi.generator.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.pojo.ZYArticle;
import com.ruoyi.generator.pojo.ZYTypeConfig;
import com.ruoyi.generator.service.ArticleService;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/ArticleWeb")
public class ArticleWeb {

    @Resource
    ArticleService articleService;

    /**
     * 文章增删改查
     * @param zyArticle
     * @return
     */
    @Anonymous
    @PostMapping("/articleCrud")
    public TableDataInfo articleCrud(@RequestBody ZYArticle zyArticle, @RequestBody String type) {
        try {
            return articleService.articleCrud(zyArticle,type);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.getDataTable();
        }
    }

    /**
     * 文章类型crud
     * @return
     */
    @Anonymous
    @PostMapping("/articleTypeCrud")
    public TableDataInfo articleTypeCrud(@RequestBody ZYTypeConfig zyTypeConfig, @RequestBody String type) {
        try {
            return articleService.articleTypeCrud(zyTypeConfig,type);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.getDataTable();
        }
    }
}
