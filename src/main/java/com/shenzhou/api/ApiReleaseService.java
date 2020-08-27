package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.releaseArticle.ApiReleaseArticleListBodyInfo;
import com.shenzhou.entity.releaseGoodsShop.ApiReleaseGoodsShopListBodyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApiReleaseService {
    @Autowired
    private ApiUtil apiUtil;

    public ApiBaseResponseInfo<ApiReleaseGoodsShopListBodyInfo> getNavigatorReleaseGoodsShopList(Map<String, String> param) {
        ApiBaseResponseInfo<ApiReleaseGoodsShopListBodyInfo> responseInfo = apiUtil.doApi(ApiReleaseGoodsShopListBodyInfo.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETNAVIGATORRELEASELIST_URL), param);
        return responseInfo;
    }

    public ApiBaseResponseInfo<ApiReleaseArticleListBodyInfo> getNavigatorReleaseArticleList(Map<String, String> param) {
        ApiBaseResponseInfo<ApiReleaseArticleListBodyInfo> responseInfo = apiUtil.doApi(ApiReleaseArticleListBodyInfo.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETNAVIGATORRELEASELIST_URL), param);
        return responseInfo;
    }
}
