package com.ruoyi.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZYText {

    /**
     * 文字id
     */
    private String textId;
    /**
     * 文字内容
     */
    private String text;
    /**
     * 文字字号
     */
    private String textWord;
    /**
     * 文字颜色
     */
    private String color;
    /**
     * 布局id
     */
    private String layoutId;
}
