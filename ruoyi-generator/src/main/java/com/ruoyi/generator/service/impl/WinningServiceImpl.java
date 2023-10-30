package com.ruoyi.generator.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.generator.mapper.ZYWinningMapper;
import com.ruoyi.generator.mapper.ZyTicketMapper;
import com.ruoyi.generator.pojo.ZyTicket;
import com.ruoyi.generator.pojo.ZyWinning;
import com.ruoyi.generator.service.WinningService;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
public class WinningServiceImpl implements WinningService {

    @Resource
    ZyTicketMapper zyTicketMapper;

    @Resource
    ZYWinningMapper zyWinningMapper;

    @Override
    public AjaxResult getPrize(String userId) {
        //获取用户id
        String s = JSONObject.parseObject(userId).get("userId").toString();
        //查询转盘所有奖品
        List<ZyTicket> zyTickets = zyTicketMapper.selectAll();
        //生成一个0-99的随机数
        int choose = RandomUtils.nextInt(0, 100);

        ZyTicket zyTicket = null;

        for (ZyTicket zt : zyTickets) {
            int parseInt = Integer.parseInt(zt.getProbability());

            Set<Integer> pool = new HashSet<>();

            do {
                pool.add(RandomUtils.nextInt(0, 100));
            }
            while (pool.size() < parseInt);

            if (pool.contains(choose)){
                zyTicket = zt;
                break;
            }
        }

        ZyWinning zyWinning = new ZyWinning();
        zyWinning.setUserId(Integer.parseInt(s));
        assert zyTicket != null;
        zyWinning.setLotteryId(zyTicket.getLotteryId());
        zyWinningMapper.add(zyWinning);

        return Result.success(zyTicket);
    }
}
