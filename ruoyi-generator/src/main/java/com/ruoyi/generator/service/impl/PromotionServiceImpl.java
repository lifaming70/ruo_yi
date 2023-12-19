package com.ruoyi.generator.service.impl;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.service.PromotionService;
import com.ruoyi.generator.util.Result;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Override
    public TableDataInfo promotion(String userId) {
        String url = stringRedisTemplate.opsForValue().get("promotionURL");

        if (null == url) return null;

        String sum = stringRedisTemplate.opsForValue().get(userId);

        if (null == sum){
            stringRedisTemplate.opsForValue().set(userId,"1");
        }else {
            String value = String.valueOf(Integer.parseInt(sum) + 1);
            stringRedisTemplate.opsForValue().set(userId,value);
        }

        return Result.getDataTable(url);
    }
}
