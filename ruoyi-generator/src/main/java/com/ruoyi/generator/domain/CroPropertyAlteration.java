package com.ruoyi.generator.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产变更对象 cro_property_alteration
 *
 * @author ruoyi
 * @date 2023-12-16
 */
@Data
public class CroPropertyAlteration extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** id */
    private Long id;

    /** 资产表,关联资产表 */
            @Excel(name = "资产表,关联资产表")
    private Long croPropertyId;

    /** 变更类型1红包 2投资支出 3领取红包 4抽奖 */
            @Excel(name = "变更类型1红包 2投资支出 3领取红包 4抽奖")
    private String alterationType;

    /** 额度 */
            @Excel(name = "额度")
    private String quota;

    /** 变更前额度 */
            @Excel(name = "变更前额度")
    private String frontQuota;

    /** 变更后额度 */
            @Excel(name = "变更后额度")
    private String laterQuota;

    /** 是否删除 否2   是1 */
            @Excel(name = "是否删除 否2   是1")
    private Long isDelete;


        }
