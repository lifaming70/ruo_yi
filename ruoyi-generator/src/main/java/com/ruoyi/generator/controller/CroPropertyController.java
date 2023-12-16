package com.ruoyi.generator.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.generator.domain.CroProperty;
import com.ruoyi.generator.service.ICroPropertyService;
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
 * 资产Controller
 *
 * @author ruoyi
 * @date 2023-12-16
 */
@RestController
@RequestMapping("/system/property")
public class CroPropertyController extends BaseController {
    @Autowired
    private ICroPropertyService croPropertyService;

/**
 * 查询资产列表
 */
@PreAuthorize("@ss.hasPermi('system:property:list')")
@GetMapping("/list")
    public TableDataInfo list(CroProperty croProperty) {
        startPage();
        List<CroProperty> list = croPropertyService.selectCroPropertyList(croProperty);
        return getDataTable(list);
    }

    /**
     * 导出资产列表
     */
    @PreAuthorize("@ss.hasPermi('system:property:export')")
    @Log(title = "资产", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CroProperty croProperty) {
        List<CroProperty> list = croPropertyService.selectCroPropertyList(croProperty);
        ExcelUtil<CroProperty> util = new ExcelUtil<CroProperty>(CroProperty. class);
        util.exportExcel(response, list, "资产数据");
    }

    /**
     * 获取资产详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:property:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(croPropertyService.selectCroPropertyById(id));
    }

    /**
     * 新增资产
     */
    @PreAuthorize("@ss.hasPermi('system:property:add')")
    @Log(title = "资产", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CroProperty croProperty) {
        return toAjax(croPropertyService.insertCroProperty(croProperty));
    }

    /**
     * 修改资产
     */
    @PreAuthorize("@ss.hasPermi('system:property:edit')")
    @Log(title = "资产", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CroProperty croProperty) {
        return toAjax(croPropertyService.updateCroProperty(croProperty));
    }

    /**
     * 删除资产
     */
    @PreAuthorize("@ss.hasPermi('system:property:remove')")
    @Log(title = "资产", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(croPropertyService.deleteCroPropertyByIds(ids));
    }
}
