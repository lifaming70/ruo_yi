package com.ruoyi.generator.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.ZyLottery;
import com.ruoyi.generator.mapper.ZYWinningMapper;
import com.ruoyi.generator.mapper.ZyLotteryMapper;
import com.ruoyi.generator.mapper.ZyTicketMapper;
import com.ruoyi.generator.domain.ZyTicket;
import com.ruoyi.generator.domain.ZyWinning;
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
    ZyLotteryMapper zyLotteryMapper;

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

        do {
            zyTicket = winningTheLottery(zyTickets,choose);
        }while (null == zyTicket);

        ZyWinning zyWinning = new ZyWinning();
        zyWinning.setUserId(Integer.parseInt(s));
        assert false;
        zyWinning.setLotteryId(zyTicket.getLotteryId());
        zyWinningMapper.add(zyWinning);

        return Result.success(zyTicket);
    }

    public ZyTicket winningTheLottery(List<ZyTicket> zyTickets,int choose) {

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
                return zyTicket;
            }
        }
        return null;
    }

    @Override
    public TableDataInfo coupon(String userId) {
        List<String> stringList = zyWinningMapper.getLotteryList(userId);

        if (stringList.isEmpty()) return Result.getDataTable();

        List<ZyLottery> lotteryList = zyLotteryMapper.selectList(stringList);

        int sum = 0;

        for (int i = 0; i < lotteryList.size(); i++) {
            ZyLottery zyLottery = lotteryList.get(i);
            String id = String.valueOf(zyLottery.getLotteryId());
            for (int j = 0; j < stringList.size(); j++) {
                String lotteryId = stringList.get(j);
                if (lotteryId.equals(id)){
                    sum++;
                    stringList.remove(j);
                    j--;
                }
            }
            zyLottery.setNumber(sum);
            sum = 0;
        }


        return Result.getDataTable(lotteryList);
    }
}
