package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.CacheUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.category.NodeCategoryBody;
import com.shenzhou.entity.category.NodeCategoryListDto;
import com.shenzhou.entity.depthCategory.ApiDepthCategoryBodyInfo;
import com.shenzhou.entity.depthCategory.ApiDepthCategoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ApiCategoryService {

    @Autowired
    private ApiUtil apiUtil;
    @Autowired
    private CacheUtil cacheUtil;

    public List<NodeCategoryListDto> getNodeCategoryList(Map<String, String> param) {
        List<NodeCategoryListDto> navList = new ArrayList<>();
        ApiBaseResponseInfo<NodeCategoryBody> baseResponseInfo = apiUtil.doApi(NodeCategoryBody.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETNODECATEGORYLIST_URL), param);
        if (baseResponseInfo.getHeader().getCode() == 0 && baseResponseInfo != null) {
            navList = baseResponseInfo.getBody().getData().getRows();
        }
        return navList;
    }

    public List<ApiDepthCategoryInfo> getCategoryList(Map<String, String> param, boolean cache) {
        List<ApiDepthCategoryInfo> categoryList = new ArrayList<>();
        if (cache) {
            categoryList = (List<ApiDepthCategoryInfo>) cacheUtil.getCacheValue("CATEGORY_LIST");
        }
        if (categoryList == null || categoryList.size() == 0) {
            ApiBaseResponseInfo<ApiDepthCategoryBodyInfo> baseResponseInfo = apiUtil.doApi(ApiDepthCategoryBodyInfo.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETCATEGORYLIST_URL), param);
            if (baseResponseInfo.getHeader().getCode() == 0 && baseResponseInfo != null) {
                categoryList = baseResponseInfo.getBody().getData().getData().getNodes();
                cacheUtil.setCacheValue("CATEGORY_LIST", categoryList);
            }
        }
        return categoryList;
    }

}
