package com.ruoyi.generator.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.ZYTypeConfig;
import com.ruoyi.generator.service.TypeService;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/TypeWeb")
public class TypeWeb {

    @Resource
    TypeService typeService;

    /**
     * 类型crud
     * @return
     */
    @Anonymous
    @PostMapping("/typeCrud")
    public TableDataInfo typeCrud(@RequestBody ZYTypeConfig zyTypeConfig, @RequestBody String type) {
        try {
            return typeService.typeCrud(zyTypeConfig,type);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.getError();
        }
    }
}
