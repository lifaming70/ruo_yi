package com.ruoyi.generator.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.generator.mapper.ZyLotteryMapper;
import com.ruoyi.generator.pojo.ZyLottery;
import com.ruoyi.generator.service.IZyLotteryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-10-08
 */
@Service
public class ZyLotteryServiceImpl implements IZyLotteryService {
    @Resource
    ZyLotteryMapper zyLotteryMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param lotteryId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ZyLottery selectZyLotteryByLotteryId(Long lotteryId) {
        return zyLotteryMapper.selectZyLotteryByLotteryId(lotteryId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param zyLottery 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyLottery> selectZyLotteryList(ZyLottery zyLottery) {
        return zyLotteryMapper.selectZyLotteryList(zyLottery);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param zyLottery 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyLottery(ZyLottery zyLottery) {
                zyLottery.setCreateTime(DateUtils.getNowDate());
            return zyLotteryMapper.insertZyLottery(zyLottery);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param zyLottery 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyLottery(ZyLottery zyLottery) {
        return zyLotteryMapper.updateZyLottery(zyLottery);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param lotteryIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteZyLotteryByLotteryIds(Long[] lotteryIds) {
        return zyLotteryMapper.deleteZyLotteryByLotteryIds(lotteryIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param lotteryId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteZyLotteryByLotteryId(Long lotteryId) {
        return zyLotteryMapper.deleteZyLotteryByLotteryId(lotteryId);
    }
}
