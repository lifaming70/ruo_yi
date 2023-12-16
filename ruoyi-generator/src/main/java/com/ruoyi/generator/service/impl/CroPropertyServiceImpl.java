package com.ruoyi.generator.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.generator.domain.CroProperty;
import com.ruoyi.generator.mapper.CroPropertyMapper;
import com.ruoyi.generator.service.ICroPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 资产Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-16
 */
@Service
public class CroPropertyServiceImpl implements ICroPropertyService {
    @Autowired
    private CroPropertyMapper croPropertyMapper;

    /**
     * 查询资产
     *
     * @param id 资产主键
     * @return 资产
     */
    @Override
    public CroProperty selectCroPropertyById(Long id) {
        return croPropertyMapper.selectCroPropertyById(id);
    }

    /**
     * 查询资产列表
     *
     * @param croProperty 资产
     * @return 资产
     */
    @Override
    public List<CroProperty> selectCroPropertyList(CroProperty croProperty) {
        return croPropertyMapper.selectCroPropertyList(croProperty);
    }

    /**
     * 新增资产
     *
     * @param croProperty 资产
     * @return 结果
     */
    @Override
    public int insertCroProperty(CroProperty croProperty) {
                croProperty.setCreateTime(DateUtils.getNowDate());
            return croPropertyMapper.insertCroProperty(croProperty);
    }

    /**
     * 修改资产
     *
     * @param croProperty 资产
     * @return 结果
     */
    @Override
    public int updateCroProperty(CroProperty croProperty) {
                croProperty.setUpdateTime(DateUtils.getNowDate());
        return croPropertyMapper.updateCroProperty(croProperty);
    }

    /**
     * 批量删除资产
     *
     * @param ids 需要删除的资产主键
     * @return 结果
     */
    @Override
    public int deleteCroPropertyByIds(Long[] ids) {
        return croPropertyMapper.deleteCroPropertyByIds(ids);
    }

    /**
     * 删除资产信息
     *
     * @param id 资产主键
     * @return 结果
     */
    @Override
    public int deleteCroPropertyById(Long id) {
        return croPropertyMapper.deleteCroPropertyById(id);
    }
}
