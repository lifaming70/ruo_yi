package com.ruoyi.generator.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.generator.mapper.ZyLotteryMapper;
import com.ruoyi.generator.mapper.ZyTicketMapper;
import com.ruoyi.generator.pojo.ZyLottery;
import com.ruoyi.generator.pojo.ZyTicket;
import com.ruoyi.generator.service.IZyTicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-10-08
 */
@Service
public class ZyTicketServiceImpl implements IZyTicketService {
    @Resource
    ZyTicketMapper zyTicketMapper;

    @Resource
    ZyLotteryMapper zyLotteryMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param ticketId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ZyTicket selectZyTicketByTicketId(Long ticketId) {
        return zyTicketMapper.selectZyTicketByTicketId(ticketId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param zyTicket 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyTicket> selectZyTicketList(ZyTicket zyTicket) {
        return zyTicketMapper.selectZyTicketList(zyTicket);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param zyTicket 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyTicket(ZyTicket zyTicket) {
        if (zyTicket.getLotteryIds().isEmpty()){
            return 0;
        }

        List<ZyLottery> lotteryList = zyLotteryMapper.selectList(zyTicket.getLotteryIds());

        List<ZyTicket> list = new ArrayList<>();

        for (ZyLottery zy : lotteryList) {
            ZyTicket ticket = new ZyTicket();
            ticket.setLotteryId(zy.getLotteryId());
            ticket.setLotteryName(zy.getLotteryName());
            ticket.setLotteryImage(zy.getLotteryImage());
            ticket.setProbability(zy.getProbability());
            ticket.setLotteryType(zy.getLotteryType());
            ticket.setAmountMin(zy.getMoney());
            ticket.setAmountMax(zy.getMoney());
            ticket.setDiscount(zy.getDiscount());
            ticket.setSkuId(zy.getSkuId());
            ticket.setNotes(zy.getNotes());
            ticket.setCreateTime(DateUtils.getNowDate());
            list.add(ticket);
        }

        return zyTicketMapper.insertZyTickets(list);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param zyTicket 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyTicket(ZyTicket zyTicket) {
        return zyTicketMapper.updateZyTicket(zyTicket);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ticketIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteZyTicketByTicketIds(Long[] ticketIds) {
        return zyTicketMapper.deleteZyTicketByTicketIds(ticketIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param ticketId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteZyTicketByTicketId(Long ticketId) {
        return zyTicketMapper.deleteZyTicketByTicketId(ticketId);
    }
}
