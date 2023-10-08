package com.ruoyi.generator.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.generator.pojo.ZyTicket;
import com.ruoyi.generator.service.IZyTicketService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-10-08
 */
@RestController
@RequestMapping("/system/ticket")
public class ZyTicketController extends BaseController {
    @Autowired
    private IZyTicketService zyTicketService;

/**
 * 查询【请填写功能名称】列表
 */
@PreAuthorize("@ss.hasPermi('system:ticket:list')")
@GetMapping("/list")
    public TableDataInfo list(ZyTicket zyTicket) {
        startPage();
        List<ZyTicket> list = zyTicketService.selectZyTicketList(zyTicket);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZyTicket zyTicket) {
        List<ZyTicket> list = zyTicketService.selectZyTicketList(zyTicket);
        ExcelUtil<ZyTicket> util = new ExcelUtil<ZyTicket>(ZyTicket. class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:query')")
    @GetMapping(value = "/{ticketId}")
    public AjaxResult getInfo(@PathVariable("ticketId") Long ticketId) {
        return success(zyTicketService.selectZyTicketByTicketId(ticketId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyTicket zyTicket) {
        return toAjax(zyTicketService.insertZyTicket(zyTicket));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyTicket zyTicket) {
        return toAjax(zyTicketService.updateZyTicket(zyTicket));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ticketIds}")
    public AjaxResult remove(@PathVariable Long[] ticketIds) {
        return toAjax(zyTicketService.deleteZyTicketByTicketIds(ticketIds));
    }
}
