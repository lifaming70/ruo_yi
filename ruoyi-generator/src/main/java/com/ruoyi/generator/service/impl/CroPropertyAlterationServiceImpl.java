package com.ruoyi.generator.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.generator.domain.CroPropertyAlteration;
import com.ruoyi.generator.mapper.CroPropertyAlterationMapper;
import com.ruoyi.generator.service.ICroPropertyAlterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 资产变更Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-16
 */
@Service
public class CroPropertyAlterationServiceImpl implements ICroPropertyAlterationService {
    @Autowired
    private CroPropertyAlterationMapper croPropertyAlterationMapper;

    /**
     * 查询资产变更
     *
     * @param id 资产变更主键
     * @return 资产变更
     */
    @Override
    public CroPropertyAlteration selectCroPropertyAlterationById(Long id) {
        return croPropertyAlterationMapper.selectCroPropertyAlterationById(id);
    }

    /**
     * 查询资产变更列表
     *
     * @param croPropertyAlteration 资产变更
     * @return 资产变更
     */
    @Override
    public List<CroPropertyAlteration> selectCroPropertyAlterationList(CroPropertyAlteration croPropertyAlteration) {
        return croPropertyAlterationMapper.selectCroPropertyAlterationList(croPropertyAlteration);
    }

    /**
     * 新增资产变更
     *
     * @param croPropertyAlteration 资产变更
     * @return 结果
     */
    @Override
    public int insertCroPropertyAlteration(CroPropertyAlteration croPropertyAlteration) {
                croPropertyAlteration.setCreateTime(DateUtils.getNowDate());
            return croPropertyAlterationMapper.insertCroPropertyAlteration(croPropertyAlteration);
    }

    /**
     * 修改资产变更
     *
     * @param croPropertyAlteration 资产变更
     * @return 结果
     */
    @Override
    public int updateCroPropertyAlteration(CroPropertyAlteration croPropertyAlteration) {
                croPropertyAlteration.setUpdateTime(DateUtils.getNowDate());
        return croPropertyAlterationMapper.updateCroPropertyAlteration(croPropertyAlteration);
    }

    /**
     * 批量删除资产变更
     *
     * @param ids 需要删除的资产变更主键
     * @return 结果
     */
    @Override
    public int deleteCroPropertyAlterationByIds(Long[] ids) {
        return croPropertyAlterationMapper.deleteCroPropertyAlterationByIds(ids);
    }

    /**
     * 删除资产变更信息
     *
     * @param id 资产变更主键
     * @return 结果
     */
    @Override
    public int deleteCroPropertyAlterationById(Long id) {
        return croPropertyAlterationMapper.deleteCroPropertyAlterationById(id);
    }
}
