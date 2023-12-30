package com.ruoyi.generator.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
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
    public AjaxResult promotion(@RequestBody Object obj) {
        try {
            String phone = JSONObject.from(obj).get("phone").toString();
            String userId = JSONObject.from(obj).get("userId").toString();
            return promotionService.promotion(userId,phone);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.error();
        }
    }

    /*@PostMapping("/offline")
    public AjaxResult offline(@RequestBody String phone) {
        try {
            return promotionService.offline(phone);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.error();
        }
    }*/

    @PostMapping("/team")
    public TableDataInfo team(@RequestBody String userId) {
        try {
            String string = JSONObject.parseObject(userId).get("userId").toString();
            return promotionService.team(string);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.getError();
        }
    }

    @PostMapping("/superior")
    public AjaxResult superior(@RequestBody String userId) {
        try {
            String string = JSONObject.parseObject(userId).get("userId").toString();
            return promotionService.superior(string);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.error();
        }
    }

}
