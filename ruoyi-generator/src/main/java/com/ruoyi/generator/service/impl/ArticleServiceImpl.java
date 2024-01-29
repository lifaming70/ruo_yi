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

        List<ZYLayout> goZyLayout = zyArticle.getChildZyLayout();//获取页面行数据
        goZyLayout.forEach(o -> o.setArticleId(articleId));//行数据绑定页面id

        List<ZYText> zyTexts = new ArrayList<>();
        List<ZYLayoutImage> zyLayoutImages = new ArrayList<>();
        List<ZYLayoutData> zyLayoutDataList = new ArrayList<>();

        boolean mark = false;

        //无限循环获取行下的列数据和获取与列绑定的实体数据以及获取列下的列数据
        do {
            if (mark) goZyLayout = queryTerr(goZyLayout);

            if (!goZyLayout.isEmpty()){
                zyLayoutMapper.insertLayoutList(goZyLayout);
                List<Object> objects = queryTerrData(goZyLayout);

                getObj(zyTexts, zyLayoutImages, zyLayoutDataList, objects);
            }
            mark = true;
        } while (goZyLayout.size() > 0);

        if (!zyLayoutDataList.isEmpty()) zyLayoutDataMapper.insertLayoutDateList(zyLayoutDataList);
        if (!zyTexts.isEmpty()) zyTextMapper.insertLayoutTextList(zyTexts);
        if (!zyLayoutImages.isEmpty()) zyLayoutImageMapper.insertLayoutImageList(zyLayoutImages);

        return Result.success();
    }



    @Override
    public AjaxResult articleUpdate(ZYArticle zyArticle) {


        List<ZYLayout> goZyLayout = zyArticle.getChildZyLayout();

        List<ZYLayoutData> zyLayoutDataList= new ArrayList<>();
        List<ZYText> zyTexts = new ArrayList<>();
        List<ZYLayoutImage> zyLayoutImages = new ArrayList<>();

        boolean mark = false;
        do {
            if (mark) goZyLayout = queryArrange(goZyLayout);

            for (ZYLayout zt : goZyLayout) {
                if (null != zt.getSkuId()){
                    zyLayoutMapper.updateZyLayout(goZyLayout);
                }
            }

            List<Object> objects = queryArrangeData(goZyLayout);

            getObj(zyTexts, zyLayoutImages, zyLayoutDataList, objects);
            mark = true;
        } while (goZyLayout.size() > 0);

        zyTextMapper.updateZyText(zyTexts);
        zyLayoutImageMapper.updateZyLayoutImage(zyLayoutImages);
        zyArticleMapper.updateArticle(zyArticle);
        zyLayoutDataMapper.updateZyLayoutData(zyLayoutDataList);

        return Result.success();
    }

    @Override
    public AjaxResult delete(ZYArticle zyArticle) {

        List<String> articleIds = zyArticle.getArticleIds();
        List<ZYLayout> layoutList = zyLayoutMapper.getLayoutListString(articleIds);

        zyLayoutDataMapper.deleteZyLayoutData(layoutList);
        zyTextMapper.deleteZyText(layoutList);
        zyLayoutImageMapper.deleteZyLayoutImage(layoutList);
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

        if (!layoutList.isEmpty()) {

            List<ZYLayout> skuZyLayout = new ArrayList<>();

            for (ZYLayout zt : layoutList) {
                if (null != zt.getSkuId()) {
                    skuZyLayout.add(zt);
                }
            }

            List<ZYLayoutData> layoutData = zyLayoutDataMapper.getLayoutData(layoutList);

            for (ZYLayout zt : layoutList) {
                String layoutId = zt.getLayoutId();
                for (ZYLayoutData zd : layoutData) {
                    if (zd.getLayoutId().equals(layoutId)) {
                        zt.setZyLayoutData(zd);
                    }
                }
            }

            List<ZYText> text = zyTextMapper.getText(layoutList);
            List<ZYLayoutImage> layoutImage = zyLayoutImageMapper.getLayoutImage(layoutList);
            List<ZySku> layoutSku = null;
            if (!skuZyLayout.isEmpty()) layoutSku = zySkuMapper.getLayoutSku(skuZyLayout);

            if (null != layoutSku) {
                List<ZyImage> image = zyImageMapper.getImages(layoutSku);

                for (ZySku zs : layoutSku) {
                    String skuId = zs.getSkuId();
                    List<ZyImage> list = new ArrayList<>();
                    for (int i = 0; i < image.size(); i++) {
                        ZyImage zyImage = image.get(i);
                        String id = zyImage.getSkuId();
                        if (id.equals(skuId)) {
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
                        if (zySku.getSkuId().equals(skuId)) {
                            zt.setZySku(zySku);
                            layoutSku.remove(i);
                            i--;
                        }
                    }
                    if (layoutData.size() == 0) break;
                }
            }


            for (ZYLayout zt : layoutList) {
                String layoutId = zt.getLayoutId();
                for (int i = 0; i < layoutImage.size(); i++) {
                    ZYLayoutImage zyLayoutImage = layoutImage.get(i);
                    if (zyLayoutImage.getLayoutId().equals(layoutId)) {
                        zt.setZyLayoutImage(zyLayoutImage);
                        layoutImage.remove(i);
                        i--;
                    }
                }
                if (layoutImage.size() == 0) break;
            }

            for (ZYLayout zt : layoutList) {
                String layoutId = zt.getLayoutId();
                for (int i = 0; i < text.size(); i++) {
                    ZYText zyText = text.get(i);
                    if (zyText.getLayoutId().equals(layoutId)) {
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
                    if (zyLayout.getArticleId().equals(articleId)) {
                        list.add(zyLayout);
                        tree.remove(i);
                        i--;
                    }
                }
                za.setChildZyLayout(list);
            }
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
            List<ZYLayout> arrangeZyLayout = t.getChildZyLayout();
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
            List<ZYLayout> arrangeZyLayout = t.getChildZyLayout();
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
            ZYLayoutData zyLayoutData = t.getZyLayoutData();
            String layoutId = t.getLayoutId();

            if (null != zyText){
                zyText.setLayoutId(layoutId);
                objects.add(zyText);
            }
            if (null != zyLayoutImage){
                zyLayoutImage.setLayoutId(layoutId);
                objects.add(zyLayoutImage);
            }
            if (null != zyLayoutData){
                zyLayoutData.setLayoutId(layoutId);
                objects.add(zyLayoutData);
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
            ZYLayoutData zyLayoutData = t.getZyLayoutData();
            if (null != zyText){
                objects.add(zyText);
            }
            if (null != zyLayoutImage){
                objects.add(zyLayoutImage);
            }
            if (null != zyLayoutData){
                objects.add(zyLayoutData);
            }
        }

        return objects;
    }


    private void getObj(List<ZYText> zyTexts, List<ZYLayoutImage> zyLayoutImages, List<ZYLayoutData> zyLayoutDataList, List<Object> objects) {
        for (Object obj : objects) {
            if (obj instanceof ZYText){
                zyTexts.add(JSONObject.parseObject(JSONObject.toJSONString(obj),ZYText.class));
            }else if (obj instanceof ZYLayoutImage){
                zyLayoutImages.add(JSONObject.parseObject(JSONObject.toJSONString(obj),ZYLayoutImage.class));
            }else if (obj instanceof ZYLayoutData){
                zyLayoutDataList.add(JSONObject.parseObject(JSONObject.toJSONString(obj),ZYLayoutData.class));
            }
        }
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

            zt.setChildZyLayout(childList);
        }

        return collect;
    }
}
