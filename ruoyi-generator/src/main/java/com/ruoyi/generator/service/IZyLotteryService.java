package com.ruoyi.generator.service;

import java.util.List;

import com.ruoyi.generator.pojo.ZyLottery;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-10-08
 */
public interface IZyLotteryService {
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
    public List<ZyLottery> selectZyLotteryList(ZyLottery zyLottery,String mark);

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
     * 批量删除【请填写功能名称】
     *
     * @param lotteryIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteZyLotteryByLotteryIds(Long[] lotteryIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param lotteryId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteZyLotteryByLotteryId(Long lotteryId);
}
