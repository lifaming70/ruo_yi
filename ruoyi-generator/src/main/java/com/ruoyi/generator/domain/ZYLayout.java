package com.ruoyi.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZYLayout {

    /**
     * 布局id
     */
    private String layoutId;
    /**
     * 1：行，2：列
     */
    private String mark;
    /**
     * 父级id
     */
    private String parentId;
    /**
     * 顺序
     */
    private int soft;
    /**
     * 页面id
     */
    private String articleId;
    /**
     * 商品id
     */
    private String skuId;
    /**
     * 商品id
     */
    private ZySku zySku;
    /**
     * 布局参数对象
     */
    private ZYLayoutData zyLayoutData;
    /**
     * 字体对象
     */
    private ZYText zyText;
    /**
     * 布局图片对象
     */
    private ZYLayoutImage zyLayoutImage;
    /**
     * 布局对象
     */
    private List<ZYLayout> arrangeZyLayout;
    /**
     * 层级
     */
    private int level;

}
