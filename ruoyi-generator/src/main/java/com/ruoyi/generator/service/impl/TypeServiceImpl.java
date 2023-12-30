package com.ruoyi.generator.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.ZYTypeConfig;
import com.ruoyi.generator.mapper.ZYTypeConfigMapper;
import com.ruoyi.generator.service.TypeService;
import com.ruoyi.generator.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    ZYTypeConfigMapper zyTypeConfigMapper;

    @Override
    public TableDataInfo typeCrud(ZYTypeConfig zyTypeConfig, String type) {

        String values = JSONObject.parseObject(type).get("type").toString();

        switch (values) {
            case "1":
                zyTypeConfigMapper.insertType(zyTypeConfig);
                break;
            case "2":
                zyTypeConfigMapper.deleteType(zyTypeConfig.getTypeIds());
                break;
            case "3":
                zyTypeConfigMapper.updateType(zyTypeConfig);
                break;
            case "4":
                PageHelper.startPage(zyTypeConfig.getPageNumber(),zyTypeConfig.getPageSize());
                List<ZYTypeConfig> list = zyTypeConfigMapper.getTypeList(zyTypeConfig);

                return Result.getDataTable(list);
            case "5":
                List<ZYTypeConfig> configList= zyTypeConfigMapper.getType(zyTypeConfig.getTypeId());

                return Result.getDataTable(configList);
        }

        return Result.getDataTable();
    }
}
