package com.ruoyi.generator.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.generator.domain.CroPropertyAlteration;
import com.ruoyi.generator.service.ICroPropertyAlterationService;
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
 * 资产变更Controller
 *
 * @author ruoyi
 * @date 2023-12-16
 */
@RestController
@RequestMapping("/system/alteration")
public class CroPropertyAlterationController extends BaseController {
    @Autowired
    private ICroPropertyAlterationService croPropertyAlterationService;

/**
 * 查询资产变更列表
 */
@GetMapping("/list")
    public TableDataInfo list(CroPropertyAlteration croPropertyAlteration) {
        startPage();
        List<CroPropertyAlteration> list = croPropertyAlterationService.selectCroPropertyAlterationList(croPropertyAlteration);
        return getDataTable(list);
    }

    /**
     * 导出资产变更列表
     */
    @Log(title = "资产变更", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CroPropertyAlteration croPropertyAlteration) {
        List<CroPropertyAlteration> list = croPropertyAlterationService.selectCroPropertyAlterationList(croPropertyAlteration);
        ExcelUtil<CroPropertyAlteration> util = new ExcelUtil<CroPropertyAlteration>(CroPropertyAlteration. class);
        util.exportExcel(response, list, "资产变更数据");
    }

    /**
     * 获取资产变更详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(croPropertyAlterationService.selectCroPropertyAlterationById(id));
    }

    /**
     * 新增资产变更
     */
    @Log(title = "资产变更", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CroPropertyAlteration croPropertyAlteration) {
        return toAjax(croPropertyAlterationService.insertCroPropertyAlteration(croPropertyAlteration));
    }

    /**
     * 修改资产变更
     */
    @Log(title = "资产变更", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CroPropertyAlteration croPropertyAlteration) {
        return toAjax(croPropertyAlterationService.updateCroPropertyAlteration(croPropertyAlteration));
    }

    /**
     * 删除资产变更
     */
    @Log(title = "资产变更", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(croPropertyAlterationService.deleteCroPropertyAlterationByIds(ids));
    }
}
