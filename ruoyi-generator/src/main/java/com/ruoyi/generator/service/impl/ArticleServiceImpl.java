package com.ruoyi.generator.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.generator.domain.*;
import com.ruoyi.generator.mapper.*;
import com.ruoyi.generator.service.ArticleService;
import com.ruoyi.generator.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ZYArticleMapper zyArticleMapper;

    @Resource
    ZYSkuMapper zySkuMapper;

    @Resource
    ZYLayoutMapper zyLayoutMapper;

    @Resource
    ZYLayoutDataMapper zyLayoutDataMapper;

    @Resource
    ZYLayoutImageMapper zyLayoutImageMapper;

    @Resource
    ZYTextMapper zyTextMapper;

    @Resource
    ZYImageMapper zyImageMapper;

    @Override
    public AjaxResult articleAdd(ZYArticle zyArticle) {

        zyArticleMapper.insertArticle(zyArticle);//页面数据入库

        String articleId = zyArticle.getArticleId();//获取页面id

        List<ZYLayout> goZyLayout = zyArticle.getGoZyLayout();//获取页面行数据
        goZyLayout.forEach(o -> o.setArticleId(articleId));//行数据绑定页面id

        zyLayoutMapper.insertLayoutList(goZyLayout);//行数据入库

        List<ZYLayoutData> zyLayoutDataList = new ArrayList<>();

        //获取行布局参数绑定行布局
        for (ZYLayout zt : goZyLayout) {
            ZYLayoutData zyLayoutData = zt.getZyLayoutData();
            zyLayoutData.setLayoutId(zt.getLayoutId());
            zyLayoutDataList.add(zyLayoutData);

        }

        zyLayoutDataMapper.insertLayoutDateList(zyLayoutDataList);//行布局参数入库

        List<ZYLayout> arrangeZyLayout = goZyLayout;
        List<ZYText> zyTexts = new ArrayList<>();
        List<ZYLayoutImage> zyLayoutImages = new ArrayList<>();

        //无限循环获取行下的列数据和获取与列绑定的实体数据以及获取列下的列数据
        do {
            arrangeZyLayout = queryTerr(arrangeZyLayout);

            if (!arrangeZyLayout.isEmpty()){
                zyLayoutMapper.insertLayoutList(arrangeZyLayout);
                List<Object> objects = queryTerrData(arrangeZyLayout);

                for (Object obj : objects) {
                    if (obj instanceof ZYText){
                        zyTexts.add(JSONObject.parseObject(JSONObject.toJSONString(obj),ZYText.class));
                    }else if (obj instanceof ZYLayoutImage){
                        zyLayoutImages.add(JSONObject.parseObject(JSONObject.toJSONString(obj),ZYLayoutImage.class));
                    }
                }
            }
        } while (arrangeZyLayout.size() > 0);

        zyTextMapper.insertLayoutTextList(zyTexts);
        zyLayoutImageMapper.insertLayoutImageList(zyLayoutImages);

        return Result.success();
    }

    @Override
    public AjaxResult articleUpdate(ZYArticle zyArticle) {


        List<ZYLayout> goZyLayout = zyArticle.getGoZyLayout();

        List<ZYLayoutData> zyLayoutDataList= new ArrayList<>();
        List<ZYLayout> arrangeZyLayout = goZyLayout;
        List<ZYText> zyTexts = new ArrayList<>();
        List<ZYLayoutImage> zyLayoutImages = new ArrayList<>();


        for (ZYLayout zt : goZyLayout) {
            ZYLayoutData zyLayoutData = zt.getZyLayoutData();
            zyLayoutDataList.add(zyLayoutData);
        }

        zyLayoutDataMapper.updateZyLayoutData(zyLayoutDataList);

        do {
            arrangeZyLayout = queryArrange(arrangeZyLayout);
            zyLayoutMapper.updateZyLayout(arrangeZyLayout);
            List<Object> objects = queryArrangeData(arrangeZyLayout);

            for (Object obj : objects) {
                if (obj instanceof ZYText){
                    zyTexts.add(JSONObject.parseObject(JSONObject.toJSONString(obj),ZYText.class));
                }else if (obj instanceof ZYLayoutImage){
                    zyLayoutImages.add(JSONObject.parseObject(JSONObject.toJSONString(obj),ZYLayoutImage.class));
                }
            }

        } while (arrangeZyLayout.size() == 0);

        zyTextMapper.updateZyText(zyTexts);
        zyLayoutImageMapper.updateZyLayoutImage(zyLayoutImages);
        zyArticleMapper.updateArticle(zyArticle);

        return Result.success();
    }

    @Override
    public AjaxResult delete(ZYArticle zyArticle) {

        List<String> articleIds = zyArticle.getArticleIds();
        List<ZYLayout> layoutList = zyLayoutMapper.getLayoutListString(articleIds);

        List<ZYLayout> arrangeZyLayout = layoutList.stream().filter(item -> item.getLevel() != 0).collect(Collectors.toList());
        List<ZYLayout> goZyLayout = layoutList.stream().filter(item -> item.getLevel() == 0).collect(Collectors.toList());

        zyLayoutDataMapper.deleteZyLayoutData(goZyLayout);
        zyTextMapper.deleteZyText(arrangeZyLayout);
        zyLayoutImageMapper.deleteZyLayoutImage(arrangeZyLayout);
        zyLayoutMapper.deleteZyLayout(layoutList);
        zyArticleMapper.deleteArticle(articleIds);

        return Result.success();
    }

    @Override
    public TableDataInfo getList(ZYArticle zyArticle) {

        PageHelper.startPage(zyArticle.getPageNum(),zyArticle.getPageSize());
        List<ZYArticle> articleList = zyArticleMapper.getArticleList(zyArticle);

        if (articleList.isEmpty()) return Result.getDataTable(articleList);

        List<ZYLayout> layoutList = zyLayoutMapper.getLayoutList(articleList);

        List<ZYLayout> goLayoutList = new ArrayList<>();

        List<ZYLayout> arrangeZyLayout = new ArrayList<>();

        List<ZYLayout> skuZyLayout = new ArrayList<>();

        for (ZYLayout zt : layoutList) {
            if (0 != zt.getLevel() && null == zt.getSkuId()){
                arrangeZyLayout.add(zt);
            }else if (0 == zt.getLevel()){
                goLayoutList.add(zt);
            }else {
                skuZyLayout.add(zt);
            }
        }

        List<ZYLayoutData> layoutData = zyLayoutDataMapper.getLayoutData(goLayoutList);

        for (ZYLayout zt : goLayoutList) {
            String layoutId = zt.getLayoutId();
            for (ZYLayoutData zd : layoutData) {
                if (zd.getLayoutId().equals(layoutId)){
                    zt.setZyLayoutData(zd);
                }
            }
        }

        List<ZYText> text = zyTextMapper.getText(arrangeZyLayout);
        List<ZYLayoutImage> layoutImage = zyLayoutImageMapper.getLayoutImage(arrangeZyLayout);
        List<ZySku> layoutSku = zySkuMapper.getLayoutSku(skuZyLayout);

        if (!layoutSku.isEmpty()){
            List<ZyImage> image = zyImageMapper.getImages(layoutSku);

            for (ZySku zs : layoutSku) {
                String skuId = zs.getSkuId();
                List<ZyImage> list = new ArrayList<>();
                for (int i = 0; i < image.size(); i++) {
                    ZyImage zyImage = image.get(i);
                    String id = zyImage.getSkuId();
                    if (id.equals(skuId)){
                        list.add(zyImage);
                        image.remove(i);
                        i--;
                    }
                }
                zs.setImages(list);
            }

            for (ZYLayout zt : skuZyLayout) {
                String skuId = zt.getSkuId();
                for (int i = 0; i < layoutSku.size(); i++) {
                    ZySku zySku = layoutSku.get(i);
                    if (zySku.getSkuId().equals(skuId)){
                        zt.setZySku(zySku);
                        layoutSku.remove(i);
                        i--;
                    }
                }
                if (layoutData.size() == 0) break;
            }
        }


        for (ZYLayout zt : arrangeZyLayout) {
            String layoutId = zt.getLayoutId();
            for (int i = 0; i < layoutImage.size(); i++) {
                ZYLayoutImage zyLayoutImage = layoutImage.get(i);
                if (zyLayoutImage.getLayoutId().equals(layoutId)){
                    zt.setZyLayoutImage(zyLayoutImage);
                    layoutImage.remove(i);
                    i--;
                }
            }
            if (layoutImage.size() == 0) break;
        }

        for (ZYLayout zt : arrangeZyLayout) {
            String layoutId = zt.getLayoutId();
            for (int i = 0; i < text.size(); i++) {
                ZYText zyText = text.get(i);
                if (zyText.getLayoutId().equals(layoutId)){
                    zt.setZyText(zyText);
                    text.remove(i);
                    i--;
                }
            }
            if (text.size() == 0) break;
        }

        List<ZYLayout> tree = getTree(layoutList);

        for (ZYArticle za : articleList) {
            String articleId = za.getArticleId();
            List<ZYLayout> list = new ArrayList<>();
            for (int i = 0; i < tree.size(); i++) {
                ZYLayout zyLayout = tree.get(i);
                if (zyLayout.getArticleId().equals(articleId)){
                   list.add(zyLayout);
                    tree.remove(i);
                    i--;
               }
            }
            za.setGoZyLayout(list);
        }

        return Result.getDataTable(articleList);
    }

    /**
     * 完善行下的列数据以及列下的列数据
     *
     * @param list list数据
     * @return 组装完成的数据
     */
    public static List<ZYLayout> queryTerr(List<ZYLayout> list){

        List<ZYLayout> children = new ArrayList<>();

        for(ZYLayout t : list){
            List<ZYLayout> arrangeZyLayout = t.getArrangeZyLayout();
            if (null != arrangeZyLayout){
                String layoutId = t.getLayoutId();
                for (ZYLayout zy : arrangeZyLayout) {
                    zy.setParentId(layoutId);
                    children.add(zy);
                }
            }
        }

        return children;
    }

    /**
     * 获取行下的列数据以及列下的列数据
     *
     * @param list list数据
     * @return 组装完成的数据
     */
    public static List<ZYLayout> queryArrange(List<ZYLayout> list){

        List<ZYLayout> children = new ArrayList<>();

        for(ZYLayout t : list){
            List<ZYLayout> arrangeZyLayout = t.getArrangeZyLayout();
            if (null != arrangeZyLayout){
                children.addAll(arrangeZyLayout);
            }
        }
        return children;
    }

    /**
     * 完善列绑定的实体数据
     *
     * @param list list数据
     * @return 组装完成的数据
     */
    public static List<Object> queryTerrData(List<ZYLayout> list){

        List<Object> objects = new ArrayList<>();

        for(ZYLayout t : list){
            ZYText zyText = t.getZyText();
            ZYLayoutImage zyLayoutImage = t.getZyLayoutImage();
            String layoutId = t.getLayoutId();
            if (null != zyText){
                zyText.setLayoutId(layoutId);
                objects.add(zyText);
            }
            if (null != zyLayoutImage){
                zyLayoutImage.setLayoutId(layoutId);
                objects.add(zyLayoutImage);
            }
        }

        return objects;
    }

    /**
     * 获取列绑定的实体数据
     *
     * @param list list数据
     * @return 组装完成的数据
     */
    public static List<Object> queryArrangeData(List<ZYLayout> list){

        List<Object> objects = new ArrayList<>();

        for(ZYLayout t : list){
            ZYText zyText = t.getZyText();
            ZYLayoutImage zyLayoutImage = t.getZyLayoutImage();
            if (null != zyText){
                objects.add(zyText);
            }
            if (null != zyLayoutImage){
                objects.add(zyLayoutImage);
            }
        }

        return objects;
    }


    /**
     * 组装树形数据
     * @param zyLayouts
     * @return
     */
    public List<ZYLayout> getTree(List<ZYLayout> zyLayouts){

        List<ZYLayout> collect = zyLayouts.stream().filter(item -> item.getLevel() != 0).collect(Collectors.toList());

        Map<Integer, List<ZYLayout>> map = collect.stream().collect(Collectors.groupingBy(o -> Integer.parseInt(o.getParentId())));
        List<ZYLayout> childrenTree = getChildrenTree(zyLayouts, map);

        return childrenTree.stream().filter(item -> item.getLevel() == 0).collect(Collectors.toList());
    }

    public List<ZYLayout> getChildrenTree(List<ZYLayout> collect, Map<Integer, List<ZYLayout>> map) {

        for (ZYLayout zt : collect) {
            List<ZYLayout> childList = map.get(Integer.parseInt(zt.getLayoutId()));

            zt.setArrangeZyLayout(childList);
        }

        return collect;
    }
}
