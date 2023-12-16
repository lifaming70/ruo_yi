package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.CroRechargeRecord;

import java.util.List;

/**
 * 充值记录订单Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-16
 */
public interface CroRechargeRecordMapper {
    /**
     * 查询充值记录订单
     *
     * @param id 充值记录订单主键
     * @return 充值记录订单
     */
    public CroRechargeRecord selectCroRechargeRecordById(Long id);

    /**
     * 查询充值记录订单列表
     *
     * @param croRechargeRecord 充值记录订单
     * @return 充值记录订单集合
     */
    public List<CroRechargeRecord> selectCroRechargeRecordList(CroRechargeRecord croRechargeRecord);

    /**
     * 新增充值记录订单
     *
     * @param croRechargeRecord 充值记录订单
     * @return 结果
     */
    public int insertCroRechargeRecord(CroRechargeRecord croRechargeRecord);

    /**
     * 修改充值记录订单
     *
     * @param croRechargeRecord 充值记录订单
     * @return 结果
     */
    public int updateCroRechargeRecord(CroRechargeRecord croRechargeRecord);

    /**
     * 删除充值记录订单
     *
     * @param id 充值记录订单主键
     * @return 结果
     */
    public int deleteCroRechargeRecordById(Long id);

    /**
     * 批量删除充值记录订单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCroRechargeRecordByIds(Long[] ids);
}
