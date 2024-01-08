package com.ruoyi.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZySku {

    /**
     * 商品id
     */
    private String skuId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 商品主图
     */
    private String image;
    /**
     * 商品类型
     */
    private String skuType;
    /**
     * 购买所需vip等级
     */
    private String vip;
    /**
     * 商品单价
     */
    private String skuPrice;
    /**
     * 所需积分
     */
    private String skuIntegral;
    /**
     * 产品期限
     */
    private String skuTerm;
    /**
     * 收益率
     */
    private String income;
    /**
     * 限购数量
     */
    private String skuQuota;
    /**
     * 商品库存
     */
    private String skuNumber;
    /**
     * 虚拟库存数量
     */
    private String skuNumberVirtually;
    /**
     * 下级人数
     */
    private String subordinateNumber;
    /**
     * 首购送自己
     */
    private String giveMe;
    /**
     * 首购送上级
     */
    private String giveSuperior;
    /**
     * 复购送自己
     */
    private String repurchaseMe;
    /**
     * 首购送上级积分
     */
    private String giveSuperiorIntegral;
    /**
     * 复购送自己积分
     */
    private String repurchaseMeIntegral;
    /**
     * 用户抽奖次数
     */
    private String lotteryNumber;
    /**
     * 上级抽奖次数
     */
    private String superiorLotteryNumber;
    /**
     * 到期可领
     */
    private String dueForCollection;
    /**
     * 截止时间
     */
    private String endDate;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否可赠送
     */
    private String give;
    /**
     * 是否热门
     */
    private String popular;
    /**
     * 1:下线,2:预售,3:上线,4:售罄
     */
    private String state;
    /**
     * 商品详情
     */
    private String skuDetails;
    /**
     * 商品图片信息
     */
    private List<ZyImage> images;

    private List<String> skuIds;
    /**
     * 条数
     */
    private Integer pageSize;
    /**
     * 页数
     */
    private Integer pageNum;
}
