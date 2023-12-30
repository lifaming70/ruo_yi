package com.ruoyi.generator.service.impl;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
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
            if (null == s){
                stringRedisTemplate.opsForValue().set(phone,userId);
                return Result.success("分享成功，激励将在下线注册后20分钟内到账",base64);
            }
            return Result.success("分享成功，该用户已是其他用户下线",base64);
        }else {
            return Result.error("该用户已被邀请，勿重复分享");
        }
    }

    /*@Override
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
    }*/

    @Override
    public TableDataInfo team(String userId) {

        List<SysUser> strings = zyTeamMapper.listUser(userId);

        return Result.getDataTable(strings);
    }

    @Override
    public AjaxResult superior(String userId) {

        try {
            SysUser sysUser = zyTeamMapper.getSuperior(userId);
            return Result.success(sysUser);
        }catch (Exception e){
            return Result.error();
        }
    }
}
