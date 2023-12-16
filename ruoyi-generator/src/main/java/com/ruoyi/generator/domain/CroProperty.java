package com.ruoyi.generator.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产对象 cro_property
 *
 * @author ruoyi
 * @date 2023-12-16
 */
@Data
public class CroProperty extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** id */
    private Long id;

    /** 用户id,关联用户表 */
            @Excel(name = "用户id,关联用户表")
    private Long userId;

    /** 钱包地址/充值地址 */
            @Excel(name = "钱包地址/充值地址")
    private String walletAddress;

    /** 货币类型/币种 */
            @Excel(name = "货币类型/币种")
    private String currencyType;

    /** 余额 */
            @Excel(name = "余额")
    private String remainingSum;

    /** 使用状态  1:启用  2:停用 */
            @Excel(name = "使用状态  1:启用  2:停用")
    private Long status;

    /** 是否删除 否2   是1 */
            @Excel(name = "是否删除 否2   是1")
    private Long isDelete;
            private String userName;
            private String phonenumber;
        }
