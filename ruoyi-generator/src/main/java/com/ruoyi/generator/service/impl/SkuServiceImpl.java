package com.ruoyi.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.generator.mapper.ZYImageMapper;
import com.ruoyi.generator.mapper.ZYSkuMapper;
import com.ruoyi.generator.domain.ZyImage;
import com.ruoyi.generator.domain.ZySku;
import com.ruoyi.generator.service.SkuService;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Slf4j
public class SkuServiceImpl implements SkuService {

    @Resource
    ZYSkuMapper zySkuMapper;
    
    @Resource
    ZYImageMapper zyImageMapper;

    @Override
    public AjaxResult skuAdd(ZySku zySku) {

        String uuid = UUID.fastUUID().toString();
        String[] split = uuid.split("-");

        Calendar instance = Calendar.getInstance();
        int second = instance.get(Calendar.SECOND);

        String skuId = split[0] + second + split[4];

        zySku.setSkuId(skuId);

        zySkuMapper.skuAdd(zySku);

        List<ZyImage> list = new ArrayList<>();
        List<ZyImage> images = zySku.getImages();

        for (ZyImage ze : images) {
            ZyImage zyImage = new ZyImage();
            zyImage.setSkuId(skuId);
            zyImage.setImage(ze.getImage());
            zyImage.setImage(ze.getImage());
            zyImage.setSoft(ze.getSoft());
            list.add(zyImage);
        }
        
        zyImageMapper.imageAdd(list);

        return Result.success();
    }

    @Override
    public TableDataInfo getSku(ZySku zySku) {

        PageHelper.startPage(zySku.getPageNum(),zySku.getPageSize());
        List<ZySku> sku = zySkuMapper.getSku(zySku);

        if (sku.isEmpty()){
            return Result.getDataTable(sku);
        }

        List<String> list = new ArrayList<>();

        for (ZySku zy : sku) {
            list.add(zy.getSkuId());
        }

        List<ZyImage> image = zyImageMapper.getImage(list);

        for (ZySku zy : sku) {
            String skuId = zy.getSkuId();
            List<ZyImage> stringList = new ArrayList<>();
            for (int i = 0; i < image.size(); i++) {
                ZyImage zyImage = image.get(i);
                if (skuId.equals(zyImage.getSkuId())){
                    stringList.add(zyImage);
                    image.remove(i);
                    i--;
                }
            }
            zy.setImages(stringList);
        }
        return Result.getDataTable(sku);
    }

    @Override
    public AjaxResult  skuUpdate(ZySku zySku) {
        zySkuMapper.updateSku(zySku);
        zyImageMapper.update(zySku.getImages());
        return Result.success();
    }

    @Override
    public TableDataInfo skuDelete(ZySku zySku) {
        zySkuMapper.deleteSkus(zySku.getSkuIds());
        return Result.getDataTable();
    }
}
