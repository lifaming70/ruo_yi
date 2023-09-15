package com.ruoyi.generator.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
