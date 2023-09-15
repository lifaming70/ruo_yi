package com.ruoyi.generator.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZYArticle {

    /**
     * 文章id
     */
    private String articleId;
    /**
     * 文章分类
     */
    private String articleType;
    /**
     * 0:不显示，1:显示
     */
    private String articleState;
    /**
     * 文章关键词
     */
    private String articleKeyword;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章详情
     */
    private String articleDetails;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 条数
     */
    private Integer pageSize;
    /**
     * 页数
     */
    private Integer pageNumber;
}
