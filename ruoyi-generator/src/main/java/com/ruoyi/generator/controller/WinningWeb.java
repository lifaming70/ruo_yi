package com.ruoyi.generator.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.generator.service.WinningService;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/winningWeb")
@Slf4j
public class WinningWeb {

    @Resource
    WinningService winningService;

    @Anonymous
        @PostMapping("/getPrize")
    public AjaxResult getPrize(@RequestBody String userId) {
        try {
            return winningService.getPrize(userId);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.error();
        }
    }
}
