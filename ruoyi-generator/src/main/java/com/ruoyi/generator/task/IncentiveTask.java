package com.ruoyi.generator.task;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.generator.mapper.ZYTeamMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component("IncentiveTask")
@Slf4j
public class IncentiveTask {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    ZYTeamMapper zyTeamMapper;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Scheduled(cron ="0 0/1 * * * ?")
    public void Incentive() {

        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<推广激励定时任务开始执行");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, -20);// 20分钟前

        String  minute =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

        List<String> strings = sysUserMapper.selectTime(minute);

        log.info("<<<<<<<<<<<<<<激励定时任务扫描到20分钟前的新增用户为：" + strings.size());

        int sum = 0;

        for (String phone : strings) {

            String userId = stringRedisTemplate.opsForValue().get(phone);

            if (null != userId){

                SysUser sysUser = sysUserMapper.selectUserById(Long.parseLong(userId));
                sysUser.setNumber(null == sysUser.getNumber() ? 1 : sysUser.getNumber() + 1);
                sysUserMapper.updateNumber(sysUser);
                stringRedisTemplate.delete(phone);

                SysUser user = sysUserMapper.checkPhoneUnique(phone);
                zyTeamMapper.insertTeam(userId,user.getUserId().toString());

                sum++;
            }

        }

        log.info("<<<<<<<<<<<<<<激励定时任务执行完毕，已成功为：" + sum + "个用户新增抽奖次数");
    }
}
