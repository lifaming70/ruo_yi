package com.ruoyi.generator.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 【请填写功能名称】对象 zy_ticket
 *
 * @author ruoyi
 * @date 2023-10-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZyTicket
        {
private static final long serialVersionUID=1L;

    /** 奖券id */
    private Long ticketId;

    /** 转盘id */
    private int lotteryId;

    /** 奖品名称 */
            @Excel(name = "奖品名称")
    private String lotteryName;

    /** 奖品图标 */
            @Excel(name = "奖品图标")
    private String lotteryImage;

    /** 中奖概率 */
            @Excel(name = "中奖概率")
    private String probability;

    /** 奖品类型 */
            @Excel(name = "奖品类型")
    private String lotteryType;

    /** 最小金额 */
            @Excel(name = "最小金额")
    private String amountMin;

    /** 最大金额 */
            @Excel(name = "最大金额")
    private String amountMax;

    /** 折扣卷 */
            @Excel(name = "折扣卷")
    private String discount;

    /** 创建时间 */
            @Excel(name = "创建时间")
    private String createTime;

    /** 产品名称 */
            @Excel(name = "产品名称")
    private String skuId;

    /** 备注 */
            @Excel(name = "备注")
    private String notes;
    /** 页数 */
            @Excel(name = "页数")
    private String pageNum;
    /** 条数 */
            @Excel(name = "条数")
    private String pageSize;
    /** 奖券id集合 */
            @Excel(name = "奖券id集合")
    private List<String> lotteryIds;
        }
