package com.ruoyi.generator.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.service.UserEquityService;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/UserEquityWeb")
@Slf4j
public class UserEquityWeb {

    @Resource
    UserEquityService userEquityService;

    @PostMapping("/coupon")
    public TableDataInfo coupon(@RequestBody String userId) {
        try {
            String string = JSONObject.parseObject(userId).get("userId").toString();
            return userEquityService.coupon(string);
        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>>>>服务异常");
            log.error(e.getMessage(),e);
            return Result.getError();
        }
    }

}
