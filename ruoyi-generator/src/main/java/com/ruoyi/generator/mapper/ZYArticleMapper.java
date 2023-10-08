package com.ruoyi.generator.mapper;

import com.ruoyi.generator.pojo.ZYArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZYArticleMapper {

    int insertArticle(ZYArticle zyArticle);

    int deleteArticle(ZYArticle zyArticle);

    int updateArticle(ZYArticle zyArticle);

    List<ZYArticle> getArticleList(ZYArticle zyArticle);

    List<ZYArticle> getArticle(@Param("articleId")String articleId);
}