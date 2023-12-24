package com.ruoyi.generator.service.impl;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.mapper.ZYTeamMapper;
import com.ruoyi.generator.service.PromotionService;
import com.ruoyi.generator.util.Result;
import com.ruoyi.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private QrConfig qrConfig;

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    ZYTeamMapper zyTeamMapper;

    @Override
    public AjaxResult promotion(String userId, String phone) {

        SysUser user = sysUserMapper.checkPhoneUnique(phone);

        if (null == user){
            String url = stringRedisTemplate.opsForValue().get("promotionURL");
            String base64 = QrCodeUtil.generateAsBase64(url, qrConfig, "PNG");
            String s = stringRedisTemplate.opsForValue().get(phone);
            if (null == s) stringRedisTemplate.opsForValue().set(phone,userId,1, TimeUnit.DAYS);
            return Result.success(base64);
        }else {
            return Result.error("该用户已被邀请，勿重复分享");
        }
    }

    @Override
    public AjaxResult offline(String phone) {
        String string = JSONObject.parseObject(phone).get("phone").toString();
        String userId = stringRedisTemplate.opsForValue().get(string);

        if (null == userId) return Result.error("请输入正确的手机号");

        SysUser sysUser = sysUserMapper.selectUserById(Long.parseLong(userId));
        sysUser.setNumber(null == sysUser.getNumber() ? 1 : sysUser.getNumber() + 1);
        sysUserMapper.updateNumber(sysUser);
        stringRedisTemplate.delete(phone);

        SysUser user = sysUserMapper.checkPhoneUnique(phone);
        zyTeamMapper.insertTeam(userId,user.getUserId().toString());
        return Result.success("上线抽奖次数已成功增加");
    }

    @Override
    public TableDataInfo team(String userId) {
        String string = JSONObject.parseObject(userId).get("userId").toString();
        List<SysUser> strings = zyTeamMapper.listUser(string);

        return Result.getDataTable(strings);
    }
}
