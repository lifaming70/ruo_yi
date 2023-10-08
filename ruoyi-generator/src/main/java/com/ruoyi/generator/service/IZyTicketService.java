package com.ruoyi.generator.service;

import java.util.List;

import com.ruoyi.generator.pojo.ZyTicket;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-10-08
 */
public interface IZyTicketService {
    /**
     * 查询【请填写功能名称】
     *
     * @param ticketId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ZyTicket selectZyTicketByTicketId(Long ticketId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param zyTicket 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyTicket> selectZyTicketList(ZyTicket zyTicket);

    /**
     * 新增【请填写功能名称】
     *
     * @param zyTicket 【请填写功能名称】
     * @return 结果
     */
    public int insertZyTicket(ZyTicket zyTicket);

    /**
     * 修改【请填写功能名称】
     *
     * @param zyTicket 【请填写功能名称】
     * @return 结果
     */
    public int updateZyTicket(ZyTicket zyTicket);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ticketIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteZyTicketByTicketIds(Long[] ticketIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param ticketId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteZyTicketByTicketId(Long ticketId);
}
