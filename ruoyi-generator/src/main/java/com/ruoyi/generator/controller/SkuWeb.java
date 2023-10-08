package com.ruoyi.generator.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.pojo.ZySku;
import com.ruoyi.generator.service.SkuService;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/SkuWeb")
@Slf4j
public class SkuWeb {

    @Resource
    SkuService service;

    @Anonymous
    @PostMapping("/skuAdd")
    public TableDataInfo skuAdd(@RequestBody ZySku zySku) {
        try {
            return service.skuAdd(zySku);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.getError();
        }
    }

    @Anonymous
    @PostMapping("/getSku")
    public TableDataInfo getSku(@RequestBody ZySku zySku) {
        try {
            return service.getSku(zySku);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.getError();
        }
    }

    @Anonymous
    @PostMapping("/skuUpdate")
    public TableDataInfo skuUpdate(@RequestBody ZySku zySku) {
        try {
            return service.skuUpdate(zySku);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.getError();
        }
    }
}
