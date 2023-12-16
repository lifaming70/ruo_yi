package com.ruoyi.generator.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 充值记录订单对象 cro_recharge_record
 *
 * @author ruoyi
 * @date 2023-12-16
 */
@Data
public class CroRechargeRecord extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** id */
    private Long id;

    /** 用户id,关联用户表 */
            @Excel(name = "用户id,关联用户表")
    private Long userId;

    /** 额度 */
            @Excel(name = "额度")
    private String quota;

    /** 系统单号唯一 */
            @Excel(name = "系统单号唯一")
    private String systemNumber;

    /** 是否删除 否2   是1 */
            @Excel(name = "是否删除 否2   是1")
    private Long isDelete;

            private String userName;
            private String phonenumber;
        }
