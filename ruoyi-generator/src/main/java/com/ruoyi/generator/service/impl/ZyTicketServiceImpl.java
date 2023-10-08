package com.ruoyi.generator.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.generator.mapper.ZyTicketMapper;
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
                zyTicket.setCreateTime(DateUtils.getNowDate());
            return zyTicketMapper.insertZyTicket(zyTicket);
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
