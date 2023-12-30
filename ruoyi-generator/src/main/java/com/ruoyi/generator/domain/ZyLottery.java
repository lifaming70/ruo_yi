package com.ruoyi.generator.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 zy_lottery
 *
 * @author ruoyi
 * @date 2023-10-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZyLottery
        {
private static final long serialVersionUID=1L;

    /** 奖品id */
    private int lotteryId;

    /** 奖券名称 */
            @Excel(name = "奖券名称")
    private String lotteryName;

    /** 奖券类型 */
            @Excel(name = "奖券类型")
    private String lotteryType;

    /** 中奖概率 */
            @Excel(name = "中奖概率")
    private String probability;

    /** 折扣 */
            @Excel(name = "折扣")
    private String discount;

    /** 金额 */
            @Excel(name = "金额")
    private String money;

    /** 可用产品 */
            @Excel(name = "可用产品")
    private String skuId;

    /** 到期时间 */
            @Excel(name = "到期时间")
    private String expirationTime;

    /** 奖券图标 */
            @Excel(name = "奖券图标")
    private String lotteryImage;

    /** 备注 */
            @Excel(name = "备注")
    private String notes;

    /** 0:下线，1:上线 */
            @Excel(name = "0:下线，1:上线")
    private String state;

    /** 创建时间 */
            @Excel(name = "创建时间")
    private String createTime;

    /** 页数 */
            @Excel(name = "页数")
    private String pageNum;

    /** 条数 */
            @Excel(name = "条数")
    private String pageSize;

    /** 奖券数量 */
            @Excel(name = "奖券数量")
    private int number;

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lotteryId",getLotteryId())
            .append("lotteryName",getLotteryName())
            .append("lotteryType",getLotteryType())
            .append("probability",getLotteryType())
            .append("discount",getDiscount())
            .append("money",getMoney())
            .append("skuId",getSkuId())
            .append("expirationTime",getExpirationTime())
            .append("lotteryImage",getLotteryImage())
            .append("notes",getNotes())
            .append("state",getState())
            .append("createTime",getCreateTime())
        .toString();
        }
}
