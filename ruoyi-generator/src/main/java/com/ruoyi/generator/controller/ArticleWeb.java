package com.ruoyi.generator.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.ZYArticle;
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
     * 页面新增
     * @param zyArticle
     * @return
     */
    @Anonymous
    @PostMapping("/articleAdd")
    public AjaxResult articleAdd(@RequestBody ZYArticle zyArticle) {
        try {
            return articleService.articleAdd(zyArticle);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.error();
        }
    }

    /**
     * 页面修改
     * @param zyArticle
     * @return
     */
    @Anonymous
    @PostMapping("/articleUpdate")
    public AjaxResult articleUpdate(@RequestBody ZYArticle zyArticle) {
        try {
            return articleService.articleUpdate(zyArticle);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.error();
        }
    }

    /**
     * 页面删除
     * @param zyArticle
     * @return
     */
    @Anonymous
    @PostMapping("/delete")
    public AjaxResult delete(@RequestBody ZYArticle zyArticle) {
        try {
            return articleService.delete(zyArticle);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.error();
        }
    }

    /**
     * 页面查询
     * @param zyArticle
     * @return
     */
    @Anonymous
    @PostMapping("/getList")
    public TableDataInfo getList(@RequestBody ZYArticle zyArticle) {
        try {
            return articleService.getList(zyArticle);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.getError();
        }
    }
}
