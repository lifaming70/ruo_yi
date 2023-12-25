package com.ruoyi.generator.service.impl;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.ZyLottery;
import com.ruoyi.generator.mapper.ZYWinningMapper;
import com.ruoyi.generator.mapper.ZyLotteryMapper;
import com.ruoyi.generator.service.UserEquityService;
import com.ruoyi.generator.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserEquityServiceImpl implements UserEquityService {

    @Resource
    ZYWinningMapper zyWinningMapper;

    @Resource
    ZyLotteryMapper zyLotteryMapper;

    @Override
    public TableDataInfo coupon(String userId) {

        List<String> stringList = zyWinningMapper.getLotteryList(userId);

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
