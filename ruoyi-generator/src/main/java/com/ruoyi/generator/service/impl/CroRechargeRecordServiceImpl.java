package com.ruoyi.generator.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.generator.domain.CroRechargeRecord;
import com.ruoyi.generator.mapper.CroRechargeRecordMapper;
import com.ruoyi.generator.service.ICroRechargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 充值记录订单Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-16
 */
@Service
public class CroRechargeRecordServiceImpl implements ICroRechargeRecordService {
    @Autowired
    private CroRechargeRecordMapper croRechargeRecordMapper;

    /**
     * 查询充值记录订单
     *
     * @param id 充值记录订单主键
     * @return 充值记录订单
     */
    @Override
    public CroRechargeRecord selectCroRechargeRecordById(Long id) {
        return croRechargeRecordMapper.selectCroRechargeRecordById(id);
    }

    /**
     * 查询充值记录订单列表
     *
     * @param croRechargeRecord 充值记录订单
     * @return 充值记录订单
     */
    @Override
    public List<CroRechargeRecord> selectCroRechargeRecordList(CroRechargeRecord croRechargeRecord) {
        return croRechargeRecordMapper.selectCroRechargeRecordList(croRechargeRecord);
    }

    /**
     * 新增充值记录订单
     *
     * @param croRechargeRecord 充值记录订单
     * @return 结果
     */
    @Override
    public int insertCroRechargeRecord(CroRechargeRecord croRechargeRecord) {
                croRechargeRecord.setCreateTime(DateUtils.getNowDate());
            return croRechargeRecordMapper.insertCroRechargeRecord(croRechargeRecord);
    }

    /**
     * 修改充值记录订单
     *
     * @param croRechargeRecord 充值记录订单
     * @return 结果
     */
    @Override
    public int updateCroRechargeRecord(CroRechargeRecord croRechargeRecord) {
                croRechargeRecord.setUpdateTime(DateUtils.getNowDate());
        return croRechargeRecordMapper.updateCroRechargeRecord(croRechargeRecord);
    }

    /**
     * 批量删除充值记录订单
     *
     * @param ids 需要删除的充值记录订单主键
     * @return 结果
     */
    @Override
    public int deleteCroRechargeRecordByIds(Long[] ids) {
        return croRechargeRecordMapper.deleteCroRechargeRecordByIds(ids);
    }

    /**
     * 删除充值记录订单信息
     *
     * @param id 充值记录订单主键
     * @return 结果
     */
    @Override
    public int deleteCroRechargeRecordById(Long id) {
        return croRechargeRecordMapper.deleteCroRechargeRecordById(id);
    }
}
