package com.ruoyi.generator.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【请填写功能名称】对象 zy_lottery
 *
 * @author ruoyi
 * @date 2023-10-08
 */
public class ZyLottery extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 奖品id */
    private Long lotteryId;

    /** 奖品名称 */
            @Excel(name = "奖品名称")
    private String lotteryName;

    /** 奖品类型 */
            @Excel(name = "奖品类型")
    private String lotteryType;

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
            @JsonFormat(pattern = "yyyy-MM-dd")
            @Excel(name = "到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expirationTime;

    /** 奖券图标 */
            @Excel(name = "奖券图标")
    private String lotteryImage;

    /** 备注 */
            @Excel(name = "备注")
    private String notes;

    /** 0:下线，1:上线 */
            @Excel(name = "0:下线，1:上线")
    private String state;
    /** 页数 */
            @Excel(name = "页数")
    private String pageNum;
    /** 条数 */
            @Excel(name = "条数")
    private String pageSize;

    public void setLotteryId(Long lotteryId)
            {
            this.lotteryId = lotteryId;
            }

    public Long getLotteryId()
            {
            return lotteryId;
            }
    public void setLotteryName(String lotteryName)
            {
            this.lotteryName = lotteryName;
            }

    public String getLotteryName()
            {
            return lotteryName;
            }
    public void setLotteryType(String lotteryType)
            {
            this.lotteryType = lotteryType;
            }

    public String getLotteryType()
            {
            return lotteryType;
            }
    public void setDiscount(String discount)
            {
            this.discount = discount;
            }

    public String getDiscount()
            {
            return discount;
            }
    public void setMoney(String money)
            {
            this.money = money;
            }

    public String getMoney()
            {
            return money;
            }
    public void setSkuId(String skuId)
            {
            this.skuId = skuId;
            }

    public String getSkuId()
            {
            return skuId;
            }
    public void setExpirationTime(Date expirationTime)
            {
            this.expirationTime = expirationTime;
            }

    public Date getExpirationTime()
            {
            return expirationTime;
            }
    public void setLotteryImage(String lotteryImage)
            {
            this.lotteryImage = lotteryImage;
            }

    public String getLotteryImage()
            {
            return lotteryImage;
            }
    public void setNotes(String notes)
            {
            this.notes = notes;
            }

    public String getNotes()
            {
            return notes;
            }
    public void setState(String state)
            {
            this.state = state;
            }

    public String getState()
            {
            return state;
            }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lotteryId",getLotteryId())
            .append("lotteryName",getLotteryName())
            .append("lotteryType",getLotteryType())
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

            public String getPageNum() {
                return pageNum;
            }

            public void setPageNum(String pageNum) {
                this.pageNum = pageNum;
            }

            public String getPageSize() {
                return pageSize;
            }

            public void setPageSize(String pageSize) {
                this.pageSize = pageSize;
            }
        }
