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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        Random random = new Random();
        int nextInt = random.nextInt(100);

        ZyTicket zyTicket = null;

        //创建一个空的list对象
        List<Integer> list = new ArrayList<>();

        //循环0-99的数字塞进list集合
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        //遍历转盘奖品对象
        for (ZyTicket zt : zyTickets) {
            //获取奖品中奖概率转int
            int parseInt = Integer.parseInt(zt.getProbability());
            //创建int数组，长度根据中奖概率决定
            Integer[] arr = new Integer[parseInt];
            //循环往arr数组塞list的数字，循环次数根据奖品概率决定
            for (int i = 0; i < parseInt;) {
                //数组下标塞值，塞的值从list里面取
                arr[parseInt - 1] = list.get(i);
                //塞完后把list的值删掉
                list.remove(i);
                //长度-1
                parseInt--;
            }
            //数组塞实体类
            zt.setStr(arr);
            //获取实体类数组
            Integer[] str = zt.getStr();
            //判断生成的随机数是否在这个数组中，在则取出当前对象并停止循环
            if (Arrays.asList(str).contains(nextInt)){
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
