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
public class ZYTypeConfig {

    /**
     * 类型id
     */
    private String typeId;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 是否生效，0：失效，1：生效
     */
    private String typeState;
    /**
     * 类型标签
     */
    private String typeLabel;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 条数
     */
    private Integer pageSize;
    /**
     * 页数
     */
    private Integer pageNumber;
    /**
     * 批量删除
     */
    private List<String> typeIds;
}
