package com.ruoyi.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZYLayoutImage {

    /**
     * 图片id
     */
    private String imageId;
    /**
     * 图片地址
     */
    private String url;
    /**
     * 图片高度
     */
    private String imageHeight;
    /**
     * 图片宽度
     */
    private String imageWidth;
    /**
     * 布局id
     */
    private String layoutId;
}
