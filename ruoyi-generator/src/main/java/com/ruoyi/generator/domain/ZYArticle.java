package com.ruoyi.generator.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZYArticle {

    /**
     * 页面id
     */
    private String articleId;
    /**
     * 页面名称
     */
    private String articleName;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 0:不显示，1:显示
     */
    private String state;
    /**
     * 备注
     */
    private String notes;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 布局对象
     */
    private List<ZYLayout> childZyLayout;
    /**
     * 条数
     */
    private Integer pageSize;
    /**
     * 页数
     */
    private Integer pageNum;
    /**
     * 批量删除
     */
    private List<String> articleIds;
}
