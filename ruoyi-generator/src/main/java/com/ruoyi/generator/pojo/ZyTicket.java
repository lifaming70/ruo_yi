package com.ruoyi.generator.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zy_ticket
 *
 * @author ruoyi
 * @date 2023-10-08
 */
public class ZyTicket extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 奖品id */
    private Long ticketId;

    /** 奖品名称 */
            @Excel(name = "奖品名称")
    private String ticketName;

    /** 奖品图标 */
            @Excel(name = "奖品图标")
    private String ticketImage;

    /** 中奖概率 */
            @Excel(name = "中奖概率")
    private String probability;

    /** 奖品类型 */
            @Excel(name = "奖品类型")
    private String ticketType;

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
    private String pageNumber;
    /** 条数 */
            @Excel(name = "条数")
    private String pageSize;

    public void setTicketId(Long ticketId)
            {
            this.ticketId = ticketId;
            }

    public Long getTicketId()
            {
            return ticketId;
            }
    public void setTicketName(String ticketName)
            {
            this.ticketName = ticketName;
            }

    public String getTicketName()
            {
            return ticketName;
            }
    public void setTicketImage(String ticketImage)
            {
            this.ticketImage = ticketImage;
            }

    public String getTicketImage()
            {
            return ticketImage;
            }
    public void setProbability(String probability)
            {
            this.probability = probability;
            }

    public String getProbability()
            {
            return probability;
            }
    public void setTicketType(String ticketType)
            {
            this.ticketType = ticketType;
            }

    public String getTicketType()
            {
            return ticketType;
            }
    public void setAmountMin(String amountMin)
            {
            this.amountMin = amountMin;
            }

    public String getAmountMin()
            {
            return amountMin;
            }
    public void setAmountMax(String amountMax)
            {
            this.amountMax = amountMax;
            }

    public String getAmountMax()
            {
            return amountMax;
            }
    public void setDiscount(String discount)
            {
            this.discount = discount;
            }

    public String getDiscount()
            {
            return discount;
            }
    public void setState(String state)
            {
            this.state = state;
            }

    public String getState()
            {
            return state;
            }
    public void setSkuId(String skuId)
            {
            this.skuId = skuId;
            }

    public String getSkuId()
            {
            return skuId;
            }
    public void setNotes(String notes)
            {
            this.notes = notes;
            }

    public String getNotes()
            {
            return notes;
            }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ticketId",getTicketId())
            .append("ticketName",getTicketName())
            .append("ticketImage",getTicketImage())
            .append("probability",getProbability())
            .append("ticketType",getTicketType())
            .append("amountMin",getAmountMin())
            .append("amountMax",getAmountMax())
            .append("discount",getDiscount())
            .append("state",getState())
            .append("createTime",getCreateTime())
            .append("skuId",getSkuId())
            .append("notes",getNotes())
        .toString();
        }

            public String getPageNumber() {
                return pageNumber;
            }

            public void setPageNumber(String pageNumber) {
                this.pageNumber = pageNumber;
            }

            public String getPageSize() {
                return pageSize;
            }

            public void setPageSize(String pageSize) {
                this.pageSize = pageSize;
            }
        }
