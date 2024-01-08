package com.ruoyi.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZYLayoutData {

    /**
     * 布局id
     */
    private String layoutId;
    /**
     * 高度
     */
    private String height;
    /**
     * 间距
     */
    private String spacing;
    /**
     * 边框
     */
    private String frame;
    /**
     * 背景
     */
    private String background;
    /**
     * 字体
     */
    private String typeface;
    /**
     * 内容朝向
     */
    private String toward;
    /**
     * 图片
     */
    private String image;
    /**
     * 事件
     */
    private String event;
}
