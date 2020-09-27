package com.shenzhou.controller;

import com.shenzhou.api.*;
import com.shenzhou.core.Config;
import com.shenzhou.entity.article.ApiArticleListBodyInfo;
import com.shenzhou.entity.article.ArticleDetail;
import com.shenzhou.entity.attachment.ObjectAttachmentListBody;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.depthCategory.ApiDepthCategoryInfo;
import com.shenzhou.entity.depthNavigator.ApiDepthNavigatorInfo;
import com.shenzhou.entity.goodsShop.ApiGoodsShopListBodyInfo;
import com.shenzhou.entity.goodsShop.GoodsShopDetailDto;
import com.shenzhou.entity.goodsShopCase.GoodsShopCaseListBody;
import com.shenzhou.entity.goodsShopParameter.GoodsShopParameterListBody;
import com.shenzhou.entity.navigator.ApiNavigatorInfo;
import com.shenzhou.entity.pageNode.PageNodeByViewUrlDto;
import com.shenzhou.entity.releaseGoodsShop.ApiReleaseGoodsShopListBodyInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SiteController {
    @Autowired
    private ApiNavigatorService apiNavigatorService;
    @Autowired
    private ApiFocusService apiFocusService;
    @Autowired
    private ApiArticleService apiArticleService;
    @Autowired
    private ApiCategoryService apiCategoryService;
    @Autowired
    private ApiGoodsShopService apiGoodsShopService;
    @Autowired
    private ApiAttachmentService apiAttachmentService;
    @Autowired
    private ApiGoodsShopCaseService apiGoodsShopCaseService;
    @Autowired
    private ApiGoodsShopParameterService apiGoodsShopParameterService;
    @Autowired
    private ApiFeedService apiFeedService;
    @Autowired
    private ApiPageNodeService apiPageNodeService;
    @Autowired
    private ApiReleaseService apiReleaseService;

    //首页轮播
    private static final String FOCUS_ID = "ff8080816dfbff6d016dfc4a06ea004e";
    //导航头部ROOT_ID
    private static final String HEAD_NAVIGATOR_ROOT_ID = "620883176dd440b7bee6c12eb55021ec";
    //导航底部ROOT_ID
    private static final String FOOT_NAVIGATOR_ROOT_ID = "caa14727e3b04e08a4ac166f309f7bde";
    //探索我们的产品导航id
    private static final String PRODUCT_RECOMMEND_NAVIGATOR_ID = "ef5192837aa24322986bb6831eeec1fb";
    //吸尘车作业锦集文章id
    private static final String WORK_ARTICLE_ID = "2c93fcff73dc20cb0173dd34e8d8005e";
    //自主创新文章id
    private static final String INNOVATE_ARTICLE_ID = "2c93fcff73dc20cb0173dd354b220060";
    //品牌故事文章id
    private static final String BRAND_STORY_ARTICLE_ID = "2c93fcff73dc20cb0173dd35cc590063";
    //售后服务文章id
    private static final String AFTER_SERVICE_ARTICLE_ID = "2c93fcff73dc20cb0173dd360c3e0065";
    //金融支持文章id
    private static final String SUPPORT_ARTICLE_ID = "2c93fcff73dc20cb0173dd5c58c7007c";
    //首页文章推荐
    private static final String INDEX_ARTICLE_RECOMMEND_NAVIGATOR_ID = "6486591901cd4d02abe7ccb100f4eb5a";
    //产品分类ROOT_ID
    private static final String PRODUCT_ROOT_ID = "36cc8014-758b-4156-99cb-a4608287bacf";
    //公司介绍文章id
    private static final String COMPANY_ARTICLE_ID = "2c93fcff73dc20cb0173dd5e55d90082";
    //车载称重系统产品id
    private static final String WEIGHTSYSTEM_PRODUCT_ID = "ff80808173f268c80173f26b1b1d0006";
    //作业质量管理产品id
    private static final String MASSSYSTEM_PRODUCT_ID = "ff80808173f268c80173f26ac57b0004";
    //产品底盘参数
    private static final String GOODSSHOP_DIPAN_PARAMETER_ID = "ff80808173f14fc30173f15525810012";
    //产品参数
    private static final String GOODSSHOP_PARAMETER_ID = "ff80808173f14fc30173f15525810011";

    @RequestMapping("")
    public String base(ModelMap modelMap, HttpServletRequest request) {
        return index(modelMap, request);
    }

    /**
     * 首页
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("index")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        //加载导航轮播基础类信息
        load(modelMap, request);
        //探索我们的产品
        Map<String, String> categoryParam = new HashMap<>();
        categoryParam.put("rootID", PRODUCT_ROOT_ID);
        categoryParam.put("depth", "2");
        List<ApiDepthCategoryInfo> categoryList = apiCategoryService.getCategoryList(categoryParam, false);
        modelMap.put("categoryList", categoryList);

        //吸尘车作业锦集
        modelMap.put("workArticle", apiArticleService.getArticleDetail(WORK_ARTICLE_ID));
        //自主创新
        modelMap.put("innovateArticle", apiArticleService.getArticleDetail(INNOVATE_ARTICLE_ID));
        //品牌故事
        modelMap.put("brandStoryArticle", apiArticleService.getArticleDetail(BRAND_STORY_ARTICLE_ID));
        //售后服务
        modelMap.put("afterServiceArticle", apiArticleService.getArticleDetail(AFTER_SERVICE_ARTICLE_ID));

        //首页文章推荐
        Map<String, String> newsParam = new HashMap<>();
        newsParam.put("navigatorID", INDEX_ARTICLE_RECOMMEND_NAVIGATOR_ID);
        ApiBaseResponseInfo<ApiArticleListBodyInfo> newsArticleBody = apiArticleService.getArticleList(newsParam);
        if (newsArticleBody != null && newsArticleBody.getBody() != null
                && newsArticleBody.getBody().getData() != null && newsArticleBody.getBody().getData().getRows() != null) {
            modelMap.put("indexRecommendArticleList", newsArticleBody.getBody().getData().getRows());
        }
        return "/website/index";
    }

    /**
     * 品牌
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("brand")
    public String brand(ModelMap modelMap, HttpServletRequest request) {
        String s = request.getParameter("s");//第几页
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        String navId = null;
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("brand")) {
                modelMap.put("description", data.getDescription());
                navId = data.getId();
                break;
            }
        }
        //文章列表
        if (StringUtils.isNotBlank(navId)) {
            Map<String, String> newsParam = new HashMap<>();
            newsParam.put("navigatorID", navId);
            newsParam.put("pageNumber", "2");
            if (StringUtils.isNotBlank(s)) {
                newsParam.put("currentPage", s);
            }
            ApiBaseResponseInfo<ApiArticleListBodyInfo> brandArticleBody = apiArticleService.getArticleList(newsParam);
            if (brandArticleBody != null && brandArticleBody.getBody() != null
                    && brandArticleBody.getBody().getData() != null
                    && brandArticleBody.getBody().getData().getRows() != null) {
                modelMap.put("currentPage", brandArticleBody.getBody().getData().getCurrentPage());
                modelMap.put("totalPage", brandArticleBody.getBody().getData().getTotalPage());
                modelMap.put("brandArticleList", brandArticleBody.getBody().getData().getRows());
            }
        }

        //左侧导航
        if (StringUtils.isNotBlank(navId)) {
            Map<String, String> newsParam = new HashMap<>();
            newsParam.put("navigatorID", navId);
            newsParam.put("pageNumber", "999");
            if (StringUtils.isNotBlank(s)) {
                newsParam.put("currentPage", s);
            }
            ApiBaseResponseInfo<ApiArticleListBodyInfo> brandArticleBody = apiArticleService.getArticleList(newsParam);
            if (brandArticleBody != null && brandArticleBody.getBody() != null
                    && brandArticleBody.getBody().getData() != null
                    && brandArticleBody.getBody().getData().getRows() != null) {
                modelMap.put("allBrandArticleList", brandArticleBody.getBody().getData().getRows());
            }
        }
        return "/website/brand";
    }

    /**
     * 品牌详情
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("brandInfo")
    public String brandInfo(ModelMap modelMap, HttpServletRequest request) {
        String artId = request.getParameter("artId");
        load(modelMap, request);
        ArticleDetail articleDetail = apiArticleService.getArticleDetail(artId);
        modelMap.put("article", articleDetail);
        return "/website/brandInfo";
    }

    /**
     * 产品
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("product")
    public String product(ModelMap modelMap, HttpServletRequest request) {
        load(modelMap, request);
        Map<String, String> categoryParam = new HashMap<>();
        categoryParam.put("rootID", PRODUCT_ROOT_ID);
        categoryParam.put("depth", "2");
        List<ApiDepthCategoryInfo> categoryList = apiCategoryService.getCategoryList(categoryParam, false);
        for (ApiDepthCategoryInfo data : categoryList) {
            if (data.getNodes() != null) {
                Map<String, String> goodsShopParam = null;
                for (ApiDepthCategoryInfo nodeData : data.getNodes()) {
                    goodsShopParam = new HashMap<>();
                    goodsShopParam.put("pageNumber", "9999");
                    goodsShopParam.put("goodsCategoryID", nodeData.getId());
                    ApiBaseResponseInfo<ApiGoodsShopListBodyInfo> goodsShopList = apiGoodsShopService.getGoodsShopList(goodsShopParam);
                    nodeData.setGoodsList(goodsShopList.getBody().getData().getRows());
                }
            }
        }
        modelMap.put("categoryList", categoryList);
        return "/website/product";
    }

    /**
     * 产品详情
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("productInfo")
    public String productInfo(HttpServletRequest request, ModelMap modelMap) {
        load(modelMap, request);
        String pid = request.getParameter("pid");
        String ccid = request.getParameter("ccid");
        if (StringUtils.isNotBlank(ccid)) {
            modelMap.put("ccid", ccid);
        }
        if (StringUtils.isNotBlank(pid)) {
            GoodsShopDetailDto product = apiGoodsShopService.getGoodsShopDetail(pid);
            modelMap.put("product", product);
        }
        Map<String, String> categoryParam = new HashMap<>();
        categoryParam.put("rootID", PRODUCT_ROOT_ID);
        categoryParam.put("depth", "2");
        List<ApiDepthCategoryInfo> categoryList = apiCategoryService.getCategoryList(categoryParam, false);
        for (ApiDepthCategoryInfo data : categoryList) {
            if (data.getNodes() != null) {
                Map<String, String> goodsShopParam = null;
                for (ApiDepthCategoryInfo nodeData : data.getNodes()) {
                    goodsShopParam = new HashMap<>();
                    goodsShopParam.put("pageNumber", "9999");
                    goodsShopParam.put("goodsCategoryID", nodeData.getId());
                    ApiBaseResponseInfo<ApiGoodsShopListBodyInfo> goodsShopList = apiGoodsShopService.getGoodsShopList(goodsShopParam);
                    nodeData.setGoodsList(goodsShopList.getBody().getData().getRows());
                }
            }
        }
        modelMap.put("categoryList", categoryList);

        //产品特色
        Map<String, String> productItemParam = new HashMap<>();
        productItemParam.put("objectID", pid);
        productItemParam.put("pageNumber", "9999");
        productItemParam.put("objectDefineID", Config.PRODUCTITEM_OBJECTDEFINEID);
        ApiBaseResponseInfo<ObjectAttachmentListBody> productItemBody = apiAttachmentService.getObjectAttachmentList(productItemParam);
        if (productItemBody != null && productItemBody.getBody() != null
                && productItemBody.getBody().getData() != null
                && productItemBody.getBody().getData().getRows() != null) {
            modelMap.put("productItemList", productItemBody.getBody().getData().getRows());
        }

        //产品参数
        Map<String, String> productParameterParam1 = new HashMap<>();
        productParameterParam1.put("goodsShopID", pid);
        productParameterParam1.put("pageNumber", "9999");
        productParameterParam1.put("goodsShopParameterDefineID", GOODSSHOP_PARAMETER_ID);
        ApiBaseResponseInfo<GoodsShopParameterListBody> productParameterListBody1 = apiGoodsShopParameterService.getGoodsShopParameterList(productParameterParam1);
        if (productParameterListBody1 != null && productParameterListBody1.getBody() != null
                && productParameterListBody1.getBody().getData() != null
                && productParameterListBody1.getBody().getData().getRows() != null) {
            modelMap.put("productParameterList1", productParameterListBody1.getBody().getData().getRows());
        }

        //产品底盘参数
        Map<String, String> productParameterParam2 = new HashMap<>();
        productParameterParam2.put("goodsShopID", pid);
        productParameterParam2.put("pageNumber", "9999");
        productParameterParam2.put("pageNumber", "9999");
        productParameterParam2.put("goodsShopParameterDefineID", GOODSSHOP_DIPAN_PARAMETER_ID);
        ApiBaseResponseInfo<GoodsShopParameterListBody> productParameterListBody2 = apiGoodsShopParameterService.getGoodsShopParameterList(productParameterParam2);
        if (productParameterListBody2 != null && productParameterListBody2.getBody() != null
                && productParameterListBody2.getBody().getData() != null
                && productParameterListBody2.getBody().getData().getRows() != null) {
            modelMap.put("productParameterList2", productParameterListBody2.getBody().getData().getRows());
        }

        //文档下载
        Map<String, String> productFileParam = new HashMap<>();
        productFileParam.put("objectID", pid);
        productFileParam.put("pageNumber", "9999");
        productFileParam.put("objectDefineID", Config.PRODUCTFILE_OBJECTDEFINEID);
        ApiBaseResponseInfo<ObjectAttachmentListBody> productFileListBody = apiAttachmentService.getObjectAttachmentList(productFileParam);
        if (productFileListBody != null && productFileListBody.getBody() != null
                && productFileListBody.getBody().getData() != null
                && productFileListBody.getBody().getData().getRows() != null) {
            modelMap.put("productFileList", productFileListBody.getBody().getData().getRows());
        }

        //客户案例
        Map<String, String> productCaseParam = new HashMap<>();
        productCaseParam.put("goodsShopID", pid);
        productCaseParam.put("pageNumber", "9999");
        ApiBaseResponseInfo<GoodsShopCaseListBody> productCaseListBody = apiGoodsShopCaseService.getGoodsShopCaseList(productCaseParam);
        if (productCaseListBody != null && productCaseListBody.getBody() != null
                && productCaseListBody.getBody().getData() != null
                && productCaseListBody.getBody().getData().getRows() != null) {
            modelMap.put("productCaseList", productCaseListBody.getBody().getData().getRows());
        }

        return "/website/productInfo";
    }

    /**
     * 称重系统
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("weightSystem")
    public String weightSystem(ModelMap modelMap, HttpServletRequest request) {
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("weightSystem")) {
                modelMap.put("nodeNavigatorList", data.getNodes());
                modelMap.put("url", "weightSystem.html");
                break;
            }
        }

        GoodsShopDetailDto product = apiGoodsShopService.getGoodsShopDetail(WEIGHTSYSTEM_PRODUCT_ID);
        modelMap.put("product", product);

        //产品特色
        Map<String, String> productItemParam = new HashMap<>();
        productItemParam.put("objectID", WEIGHTSYSTEM_PRODUCT_ID);
        productItemParam.put("pageNumber", "9999");
        productItemParam.put("objectDefineID", Config.PRODUCTITEM_OBJECTDEFINEID);
        ApiBaseResponseInfo<ObjectAttachmentListBody> productItemBody = apiAttachmentService.getObjectAttachmentList(productItemParam);
        if (productItemBody != null && productItemBody.getBody() != null
                && productItemBody.getBody().getData() != null
                && productItemBody.getBody().getData().getRows() != null) {
            modelMap.put("productItemList", productItemBody.getBody().getData().getRows());
        }

        //文档下载
        Map<String, String> productFileParam = new HashMap<>();
        productFileParam.put("objectID", WEIGHTSYSTEM_PRODUCT_ID);
        productFileParam.put("pageNumber", "9999");
        productFileParam.put("objectDefineID", Config.PRODUCTFILE_OBJECTDEFINEID);
        ApiBaseResponseInfo<ObjectAttachmentListBody> productFileListBody = apiAttachmentService.getObjectAttachmentList(productFileParam);
        if (productFileListBody != null && productFileListBody.getBody() != null
                && productFileListBody.getBody().getData() != null
                && productFileListBody.getBody().getData().getRows() != null) {
            modelMap.put("productFileList", productFileListBody.getBody().getData().getRows());
        }

        //客户案例
        Map<String, String> productCaseParam = new HashMap<>();
        productCaseParam.put("goodsShopID", WEIGHTSYSTEM_PRODUCT_ID);
        productCaseParam.put("pageNumber", "9999");
        ApiBaseResponseInfo<GoodsShopCaseListBody> productCaseListBody = apiGoodsShopCaseService.getGoodsShopCaseList(productCaseParam);
        if (productCaseListBody != null && productCaseListBody.getBody() != null
                && productCaseListBody.getBody().getData() != null
                && productCaseListBody.getBody().getData().getRows() != null) {
            modelMap.put("productCaseList", productCaseListBody.getBody().getData().getRows());
        }

        return "/website/weightSystem";
    }

    /**
     * 质量系统
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("massSystem")
    public String massSystem(ModelMap modelMap, HttpServletRequest request) {
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("weightSystem")) {
                modelMap.put("nodeNavigatorList", data.getNodes());
                modelMap.put("url", "massSystem.html");
                break;
            }
        }

        GoodsShopDetailDto product = apiGoodsShopService.getGoodsShopDetail(MASSSYSTEM_PRODUCT_ID);
        modelMap.put("product", product);

        //产品特色
        Map<String, String> productItemParam = new HashMap<>();
        productItemParam.put("objectID", MASSSYSTEM_PRODUCT_ID);
        productItemParam.put("pageNumber", "9999");
        productItemParam.put("objectDefineID", Config.PRODUCTITEM_OBJECTDEFINEID);
        ApiBaseResponseInfo<ObjectAttachmentListBody> productItemBody = apiAttachmentService.getObjectAttachmentList(productItemParam);
        if (productItemBody != null && productItemBody.getBody() != null
                && productItemBody.getBody().getData() != null
                && productItemBody.getBody().getData().getRows() != null) {
            modelMap.put("productItemList", productItemBody.getBody().getData().getRows());
        }

        //文档下载
        Map<String, String> productFileParam = new HashMap<>();
        productFileParam.put("objectID", MASSSYSTEM_PRODUCT_ID);
        productFileParam.put("pageNumber", "9999");
        productFileParam.put("objectDefineID", Config.PRODUCTFILE_OBJECTDEFINEID);
        ApiBaseResponseInfo<ObjectAttachmentListBody> productFileListBody = apiAttachmentService.getObjectAttachmentList(productFileParam);
        if (productFileListBody != null && productFileListBody.getBody() != null
                && productFileListBody.getBody().getData() != null
                && productFileListBody.getBody().getData().getRows() != null) {
            modelMap.put("productFileList", productFileListBody.getBody().getData().getRows());
        }

        //客户案例
        Map<String, String> productCaseParam = new HashMap<>();
        productCaseParam.put("goodsShopID", MASSSYSTEM_PRODUCT_ID);
        productCaseParam.put("pageNumber", "9999");
        ApiBaseResponseInfo<GoodsShopCaseListBody> productCaseListBody = apiGoodsShopCaseService.getGoodsShopCaseList(productCaseParam);
        if (productCaseListBody != null && productCaseListBody.getBody() != null
                && productCaseListBody.getBody().getData() != null
                && productCaseListBody.getBody().getData().getRows() != null) {
            modelMap.put("productCaseList", productCaseListBody.getBody().getData().getRows());
        }
        return "/website/massSystem";
    }

    /**
     * 关于我们
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("aboutUs")
    public String aboutUs(ModelMap modelMap, HttpServletRequest request) {
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("aboutUs")) {
                modelMap.put("nodeNavigatorList", data.getNodes());
                modelMap.put("url", "aboutUs.html");
                break;
            }
        }
        modelMap.put("companyArticle", apiArticleService.getArticleDetail(COMPANY_ARTICLE_ID));
        return "/website/aboutUs";
    }

    /**
     * 行业
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("industry")
    public String industry(ModelMap modelMap, HttpServletRequest request) {
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("aboutUs")) {
                for (ApiDepthNavigatorInfo nodeData : data.getNodes()) {
                    if (nodeData.getFunctionUrl().contains("industry")) {
                        Map<String, String> nodeNavParam = new HashMap<>();
                        nodeNavParam.put("rootID", nodeData.getId());
                        nodeNavParam.put("pageNumber", "9999");
                        nodeNavParam.put("depth", "1");
                        List<ApiNavigatorInfo> navigatorInfoList = apiNavigatorService.getNodeNavigatorList(nodeNavParam);
                        Map<String, String> articleParam = null;
                        for (ApiNavigatorInfo navData : navigatorInfoList) {
                            articleParam = new HashMap<>();
                            articleParam.put("navigatorID", navData.getId());
                            articleParam.put("pageNumber", "999");
                            navData.setArticleList(apiArticleService.getArticleList(articleParam).getBody().getData().getRows());
                        }
                        modelMap.put("nodeNavigatorList", navigatorInfoList);
                        break;
                    }
                }
                break;
            }
        }
        return "/website/industry";
    }

    /**
     * 新闻
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("news")
    public String news(ModelMap modelMap, HttpServletRequest request) {
        String s = request.getParameter("s");
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        List<ApiDepthNavigatorInfo> nodeNavigatorList = new ArrayList<>();
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("aboutUs")) {
                nodeNavigatorList = data.getNodes();
                modelMap.put("nodeNavigatorList", nodeNavigatorList);
                modelMap.put("url", "news.html");
                break;
            }
        }

        for (ApiDepthNavigatorInfo data : nodeNavigatorList) {
            if (data.getFunctionUrl().contains("news")) {
                Map<String, String> newsParam = new HashMap<>();
                newsParam.put("navigatorID", data.getId());
                newsParam.put("pageNumber", "2");
                if (StringUtils.isNotBlank(s)) {
                    newsParam.put("currentPage", s);
                }
                ApiBaseResponseInfo<ApiArticleListBodyInfo> newsArticleBody = apiArticleService.getArticleList(newsParam);
                if (newsArticleBody != null && newsArticleBody.getBody() != null
                        && newsArticleBody.getBody().getData() != null
                        && newsArticleBody.getBody().getData().getRows() != null) {
                    modelMap.put("currentPage", newsArticleBody.getBody().getData().getCurrentPage());
                    modelMap.put("totalPage", newsArticleBody.getBody().getData().getTotalPage());
                    modelMap.put("newsArticleList", newsArticleBody.getBody().getData().getRows());
                }
                break;
            }
        }
        return "/website/news";
    }

    /**
     * 新闻详情
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("newsInfo")
    public String newsInfo(ModelMap modelMap, HttpServletRequest request) {
        String artId = request.getParameter("artId");
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("aboutUs")) {
                modelMap.put("nodeNavigatorList", data.getNodes());
                modelMap.put("url", "news.html");
                break;
            }
        }
        ArticleDetail articleDetail = apiArticleService.getArticleDetail(artId);
        modelMap.put("article", articleDetail);
        return "/website/newsInfo";
    }

    /**
     * 荣誉
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("honor")
    public String honor(ModelMap modelMap, HttpServletRequest request) {
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        List<ApiDepthNavigatorInfo> nodeNavigatorList = new ArrayList<>();
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("aboutUs")) {
                nodeNavigatorList = data.getNodes();
                modelMap.put("nodeNavigatorList", nodeNavigatorList);
                modelMap.put("url", "honor.html");
                break;
            }
        }
        for (ApiDepthNavigatorInfo data : nodeNavigatorList) {
            if (data.getFunctionUrl().contains("honor")) {
                Map<String, String> newsParam = new HashMap<>();
                newsParam.put("navigatorID", data.getId());
                newsParam.put("pageNumber", "9999");
                ApiBaseResponseInfo<ApiArticleListBodyInfo> honorArticleBody = apiArticleService.getArticleList(newsParam);
                if (honorArticleBody != null && honorArticleBody.getBody() != null
                        && honorArticleBody.getBody().getData() != null
                        && honorArticleBody.getBody().getData().getRows() != null) {
                    modelMap.put("honorArticleList", honorArticleBody.getBody().getData().getRows());
                }
                break;
            }
        }
        return "/website/honor";
    }

    /**
     * 服务
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("service")
    public String service(ModelMap modelMap, HttpServletRequest request) {
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("download")) {
                modelMap.put("nodeNavigatorList", data.getNodes());
                modelMap.put("url", "service.html");
                break;
            }
        }
        //售后服务
        modelMap.put("afterServiceArticle", apiArticleService.getArticleDetail(AFTER_SERVICE_ARTICLE_ID));
        return "/website/service";
    }

    /**
     * 下载
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("download")
    public String download(ModelMap modelMap, HttpServletRequest request) {
        String name = request.getParameter("name");
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("download")) {
                modelMap.put("nodeNavigatorList", data.getNodes());
                modelMap.put("url", "download.html");
                break;
            }
        }

        //文档下载
        Map<String, String> productFileParam = new HashMap<>();
        productFileParam.put("objectDefineID", Config.PRODUCTFILE_OBJECTDEFINEID);
        if (StringUtils.isNotBlank(name)) {
            productFileParam.put("name", name);
            modelMap.put("name", name);
        }
        ApiBaseResponseInfo<ObjectAttachmentListBody> productFileListBody = apiAttachmentService.getObjectAttachmentList(productFileParam);
        if (productFileListBody != null && productFileListBody.getBody() != null
                && productFileListBody.getBody().getData() != null
                && productFileListBody.getBody().getData().getRows() != null) {
            modelMap.put("productFileList", productFileListBody.getBody().getData().getRows());
        }
        return "/website/download";
    }

    /**
     * 支持
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("support")
    public String support(ModelMap modelMap, HttpServletRequest request) {
        load(modelMap, request);
        List<ApiDepthNavigatorInfo> headNavigatorList = (List<ApiDepthNavigatorInfo>) modelMap.get("headNavigatorList");
        for (ApiDepthNavigatorInfo data : headNavigatorList) {
            if (data.getFunctionUrl().contains("download")) {
                modelMap.put("nodeNavigatorList", data.getNodes());
                modelMap.put("url", "support.html");
                break;
            }
        }
        //售后服务
        modelMap.put("supportArticle", apiArticleService.getArticleDetail(SUPPORT_ARTICLE_ID));
        return "/website/support";
    }

    /**
     * 提交一个意见反馈
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("submitOneFeed")
    public Map<String, Object> submitOneFeed(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);

        Map<String, String> feedParam = new HashMap<>();
        String contant = request.getParameter("contant");
        String contact = request.getParameter("contact");
        String contacts = request.getParameter("contacts");
        String title = request.getParameter("title");
        String sex = request.getParameter("sex");
        String companyName = request.getParameter("companyName");
        String industryName = request.getParameter("industryName");
        String departmentName = request.getParameter("departmentName");
        String jobName = request.getParameter("jobName");
        String email = request.getParameter("email");
        feedParam.put("applicationID", Config.SHENZHOU_APPLICATION_ID);
        feedParam.put("contant", contant);
        feedParam.put("contact", contact);
        feedParam.put("contacts", contacts);
        feedParam.put("title", title);
        feedParam.put("sex", sex);
        feedParam.put("companyName", companyName);
        feedParam.put("industryName", industryName);
        feedParam.put("departmentName", departmentName);
        feedParam.put("jobName", jobName);
        feedParam.put("email", email);
        String msg = apiFeedService.submitOneFeed(feedParam);
        if (msg.equals("SUCCESS")) {
            map.put("success", true);
            return map;
        }
        map.put("msg", msg);
        return map;
    }

    /**
     * 加载基本数据
     *
     * @param modelMap
     * @return
     */
    private ModelMap load(ModelMap modelMap, HttpServletRequest request) {
        //轮播
        modelMap.put("focusList", apiFocusService.getFocusList(FOCUS_ID, false));

        //头部导航
        Map<String, String> headNavigatorParam = new HashMap<>();
        headNavigatorParam.put("rootID", HEAD_NAVIGATOR_ROOT_ID);
        headNavigatorParam.put("pageNumber", "9999");
        headNavigatorParam.put("depth", "2");
        modelMap.put("headNavigatorList", apiNavigatorService.getNavigatorList(headNavigatorParam, false));

        //底部导航
        Map<String, String> footNavigatorParam = new HashMap<>();
        footNavigatorParam.put("rootID", FOOT_NAVIGATOR_ROOT_ID);
        footNavigatorParam.put("pageNumber", "9999");
        footNavigatorParam.put("depth", "2");
        modelMap.put("footNavigatorList", apiNavigatorService.getNavigatorList(footNavigatorParam, false));

        //seo信息
        PageNodeByViewUrlDto pageNode = null;
        String reqUrl = request.getServletPath();
        if (reqUrl.contains(".")) {
            pageNode = apiPageNodeService.getPageNodeByViewUrl(reqUrl.substring(reqUrl.lastIndexOf("/") + 1, reqUrl.lastIndexOf(".")));
        } else {
            pageNode = apiPageNodeService.getPageNodeByViewUrl(reqUrl.substring(reqUrl.lastIndexOf("/") + 1));
        }
        modelMap.put("pageNode", pageNode);
        return modelMap;
    }
}
