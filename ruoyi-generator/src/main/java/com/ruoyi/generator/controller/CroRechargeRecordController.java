package com.ruoyi.generator.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.generator.domain.CroRechargeRecord;
import com.ruoyi.generator.service.ICroRechargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 充值记录订单Controller
 *
 * @author ruoyi
 * @date 2023-12-16
 */
@RestController
@RequestMapping("/system/record")
public class CroRechargeRecordController extends BaseController {
    @Autowired
    private ICroRechargeRecordService croRechargeRecordService;

/**
 * 查询充值记录订单列表
 */
@PreAuthorize("@ss.hasPermi('system:record:list')")
@GetMapping("/list")
    public TableDataInfo list(CroRechargeRecord croRechargeRecord) {
        startPage();
        List<CroRechargeRecord> list = croRechargeRecordService.selectCroRechargeRecordList(croRechargeRecord);
        return getDataTable(list);
    }

    /**
     * 导出充值记录订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "充值记录订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CroRechargeRecord croRechargeRecord) {
        List<CroRechargeRecord> list = croRechargeRecordService.selectCroRechargeRecordList(croRechargeRecord);
        ExcelUtil<CroRechargeRecord> util = new ExcelUtil<CroRechargeRecord>(CroRechargeRecord. class);
        util.exportExcel(response, list, "充值记录订单数据");
    }

    /**
     * 获取充值记录订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(croRechargeRecordService.selectCroRechargeRecordById(id));
    }

    /**
     * 新增充值记录订单
     */
    @PreAuthorize("@ss.hasPermi('system:record:add')")
    @Log(title = "充值记录订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CroRechargeRecord croRechargeRecord) {
        return toAjax(croRechargeRecordService.insertCroRechargeRecord(croRechargeRecord));
    }

    /**
     * 修改充值记录订单
     */
    @PreAuthorize("@ss.hasPermi('system:record:edit')")
    @Log(title = "充值记录订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CroRechargeRecord croRechargeRecord) {
        return toAjax(croRechargeRecordService.updateCroRechargeRecord(croRechargeRecord));
    }

    /**
     * 删除充值记录订单
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "充值记录订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(croRechargeRecordService.deleteCroRechargeRecordByIds(ids));
    }
}
