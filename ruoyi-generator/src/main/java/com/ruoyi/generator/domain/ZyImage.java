package com.ruoyi.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZyImage {

    /**
     * 图片id
     */
    private String imageId;
    /**
     * 商品ID
     */
    private String skuId;
    /**
     * 图片base64信息
     */
    private String image;
    /**
     * 排序
     */
    private int soft;
}
