package com.ruoyi.generator.service;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.generator.mapper.ZYImageMapper;
import com.ruoyi.generator.mapper.ZYSkuMapper;
import com.ruoyi.generator.pojo.ZyImage;
import com.ruoyi.generator.pojo.ZySku;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Slf4j
public class SkuServiceImpl implements SkuService{

    @Resource
    ZYSkuMapper zySkuMapper;
    
    @Resource
    ZYImageMapper zyImageMapper;

    @Override
    public TableDataInfo skuAdd(ZySku zySku) {

        String uuid = UUID.fastUUID().toString();
        String[] split = uuid.split("-");

        Calendar instance = Calendar.getInstance();
        int second = instance.get(Calendar.SECOND);

        String skuId = split[0] + second + split[4];

        zySku.setSkuId(skuId);

        zySkuMapper.skuAdd(zySku);

        List<ZyImage> list = new ArrayList<>();
        List<String> String = zySku.getImage();

        for (String str : String) {
            ZyImage zyImage = new ZyImage();
            zyImage.setSkuId(skuId);
            zyImage.setImage(str);
            list.add(zyImage);
        }
        
        zyImageMapper.imageAdd(list);

        return Result.getDataTable();
    }

    @Override
    public TableDataInfo getSku(ZySku zySku) {

        PageHelper.startPage(zySku.getPageNumber(),zySku.getPageSize());
        List<ZySku> sku = zySkuMapper.getSku(zySku);
        return Result.getDataTable(sku);
    }
}
