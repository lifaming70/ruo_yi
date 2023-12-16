package com.ruoyi.generator.mapper;

import com.ruoyi.generator.domain.CroPropertyAlteration;

import java.util.List;


/**
 * 资产变更Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-16
 */
public interface CroPropertyAlterationMapper {
    /**
     * 查询资产变更
     *
     * @param id 资产变更主键
     * @return 资产变更
     */
    public CroPropertyAlteration selectCroPropertyAlterationById(Long id);

    /**
     * 查询资产变更列表
     *
     * @param croPropertyAlteration 资产变更
     * @return 资产变更集合
     */
    public List<CroPropertyAlteration> selectCroPropertyAlterationList(CroPropertyAlteration croPropertyAlteration);

    /**
     * 新增资产变更
     *
     * @param croPropertyAlteration 资产变更
     * @return 结果
     */
    public int insertCroPropertyAlteration(CroPropertyAlteration croPropertyAlteration);

    /**
     * 修改资产变更
     *
     * @param croPropertyAlteration 资产变更
     * @return 结果
     */
    public int updateCroPropertyAlteration(CroPropertyAlteration croPropertyAlteration);

    /**
     * 删除资产变更
     *
     * @param id 资产变更主键
     * @return 结果
     */
    public int deleteCroPropertyAlterationById(Long id);

    /**
     * 批量删除资产变更
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCroPropertyAlterationByIds(Long[] ids);
}
