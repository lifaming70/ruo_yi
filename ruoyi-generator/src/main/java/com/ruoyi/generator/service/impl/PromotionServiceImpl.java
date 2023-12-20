package com.ruoyi.generator.service.impl;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.service.PromotionService;
import com.ruoyi.generator.util.Result;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Override
    public AjaxResult promotion(String userId, String phone) {
        String url = stringRedisTemplate.opsForValue().get("promotionURL");

        if (null == url) return null;

        String sum = stringRedisTemplate.opsForValue().get(userId + "_" + phone);

        if (null == sum){
            stringRedisTemplate.opsForValue().set(userId + "_" + phone,userId + "_" + phone,3, TimeUnit.DAYS);
        }else {
            return Result.error("请勿重复分享");
        }

        return Result.success(url);
    }
}
