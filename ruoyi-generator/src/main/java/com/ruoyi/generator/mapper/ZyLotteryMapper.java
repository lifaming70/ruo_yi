package com.ruoyi.generator.mapper;

import java.util.List;

import com.ruoyi.generator.pojo.ZyLottery;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-10-08
 */
public interface ZyLotteryMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param lotteryId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ZyLottery selectZyLotteryByLotteryId(Long lotteryId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param zyLottery 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyLottery> selectZyLotteryList(ZyLottery zyLottery);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param list 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyLottery> selectList(List<String> list);

    /**
     * 新增【请填写功能名称】
     *
     * @param zyLottery 【请填写功能名称】
     * @return 结果
     */
    public int insertZyLottery(ZyLottery zyLottery);

    /**
     * 修改【请填写功能名称】
     *
     * @param zyLottery 【请填写功能名称】
     * @return 结果
     */
    public int updateZyLottery(ZyLottery zyLottery);

    /**
     * 删除【请填写功能名称】
     *
     * @param lotteryId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteZyLotteryByLotteryId(Long lotteryId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param lotteryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZyLotteryByLotteryIds(Long[] lotteryIds);
}
