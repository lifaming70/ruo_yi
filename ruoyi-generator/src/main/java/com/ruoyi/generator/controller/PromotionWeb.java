package com.ruoyi.generator.controller;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.service.PromotionService;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/promotionWeb")
@Slf4j
public class PromotionWeb {

    @Resource
    PromotionService promotionService;

    @PostMapping("/promotion")
    public TableDataInfo promotion(@RequestBody String userId) {
        try {
            return promotionService.promotion(userId);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.getError();
        }
    }

}
