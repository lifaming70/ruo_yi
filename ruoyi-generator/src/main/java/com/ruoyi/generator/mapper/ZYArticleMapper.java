package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.ZYArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZYArticleMapper {

    int insertArticle(ZYArticle zyArticle);

    int deleteArticle(List<String> list);

    int updateArticle(ZYArticle zyArticle);

    List<ZYArticle> getArticleList(ZYArticle zyArticle);

    List<ZYArticle> getArticle(@Param("articleId")String articleId);
}
