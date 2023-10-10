package com.ruoyi.generator.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.generator.pojo.ZyLottery;
import com.ruoyi.generator.service.IZyLotteryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/system/lottery")
public class ZyLotteryController extends BaseController {
    @Autowired
    private IZyLotteryService zyLotteryService;

/**
 * 查询【请填写功能名称】列表
 */
@PreAuthorize("@ss.hasPermi('system:lottery:list')")
@GetMapping("/list")
    public TableDataInfo list(@RequestParam String pageNumber,
                              @RequestParam String pageSize,
                              @RequestParam String lotteryName,
                              @RequestParam String lotteryType) {
        startPage();

        ZyLottery zyLottery = new ZyLottery();
        zyLottery.setPageNumber(pageNumber);
        zyLottery.setPageSize(pageSize);
        zyLottery.setLotteryName(lotteryName);
        zyLottery.setLotteryType(lotteryType);
        List<ZyLottery> list = zyLotteryService.selectZyLotteryList(zyLottery);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:lottery:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZyLottery zyLottery) {
        List<ZyLottery> list = zyLotteryService.selectZyLotteryList(zyLottery);
        ExcelUtil<ZyLottery> util = new ExcelUtil<ZyLottery>(ZyLottery. class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:lottery:query')")
    @GetMapping(value = "/{lotteryId}")
    public AjaxResult getInfo(@PathVariable("lotteryId") Long lotteryId) {
        return success(zyLotteryService.selectZyLotteryByLotteryId(lotteryId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:lottery:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyLottery zyLottery) {
        return toAjax(zyLotteryService.insertZyLottery(zyLottery));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:lottery:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyLottery zyLottery) {
        return toAjax(zyLotteryService.updateZyLottery(zyLottery));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:lottery:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{lotteryIds}")
    public AjaxResult remove(@PathVariable Long[] lotteryIds) {
        return toAjax(zyLotteryService.deleteZyLotteryByLotteryIds(lotteryIds));
    }
}
