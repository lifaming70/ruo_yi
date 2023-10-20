package com.ruoyi.generator.pojo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 【请填写功能名称】对象 zy_ticket
 *
 * @author ruoyi
 * @date 2023-10-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZyTicket extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 转盘id */
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

    /** 0:失效，1:生效 */
            @Excel(name = "0:失效，1:生效")
    private String state;

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
    /** 标记 */
            @Excel(name = "标记")
    private Integer[] str;
        }
