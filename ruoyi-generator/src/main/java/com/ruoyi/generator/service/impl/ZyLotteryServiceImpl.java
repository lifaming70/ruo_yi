package com.ruoyi.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.ruoyi.generator.domain.ZyLottery;
import com.ruoyi.generator.domain.ZyTicket;
import com.ruoyi.generator.mapper.ZyLotteryMapper;
import com.ruoyi.generator.mapper.ZyTicketMapper;
import com.ruoyi.generator.service.IZyLotteryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    ZyTicketMapper zyTicketMapper;

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
    public List<ZyLottery> selectZyLotteryList(ZyLottery zyLottery,String mark) {
        PageHelper.startPage(zyLottery.getPageNum(),zyLottery.getPageSize());
        List<ZyLottery> zyLotteries = zyLotteryMapper.selectZyLotteryList(zyLottery);


        if (mark != null && mark.equals("1")){
            PageHelper.startPage(zyLottery.getPageNum(),zyLottery.getPageSize());
            List<ZyTicket> list = zyTicketMapper.selectAll();

            for (ZyTicket zy : list) {
                int lotteryId = zy.getLotteryId();
                for (int i = 0; i < zyLotteries.size(); i++) {
                    ZyLottery lottery = zyLotteries.get(i);
                    if (lottery.getLotteryId() == lotteryId){
                        zyLotteries.remove(i);
                    }
                }
            }
        }

        return zyLotteries;
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param zyLottery 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyLottery(ZyLottery zyLottery) {
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
        zyTicketMapper.deleteLotteryId(lotteryIds);
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
