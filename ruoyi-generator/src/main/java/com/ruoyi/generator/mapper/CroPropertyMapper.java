package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.CroProperty;

import java.util.List;


/**
 * 资产Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-16
 */
public interface CroPropertyMapper {
    /**
     * 查询资产
     *
     * @param id 资产主键
     * @return 资产
     */
    public CroProperty selectCroPropertyById(Long id);

    /**
     * 查询资产列表
     *
     * @param croProperty 资产
     * @return 资产集合
     */
    public List<CroProperty> selectCroPropertyList(CroProperty croProperty);

    /**
     * 新增资产
     *
     * @param croProperty 资产
     * @return 结果
     */
    public int insertCroProperty(CroProperty croProperty);

    /**
     * 修改资产
     *
     * @param croProperty 资产
     * @return 结果
     */
    public int updateCroProperty(CroProperty croProperty);

    /**
     * 删除资产
     *
     * @param id 资产主键
     * @return 结果
     */
    public int deleteCroPropertyById(Long id);

    /**
     * 批量删除资产
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCroPropertyByIds(Long[] ids);
}
