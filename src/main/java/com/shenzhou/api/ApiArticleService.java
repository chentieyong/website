package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.article.ArticleDetail;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.article.ApiArticleBodyInfo;
import com.shenzhou.entity.article.ApiArticleListBodyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 文章接口
 */
@Service
public class ApiArticleService {
    @Autowired
    private ApiUtil apiUtil;

    public ApiBaseResponseInfo<ApiArticleListBodyInfo> getArticleList(Map<String, String> param) {
        ApiBaseResponseInfo<ApiArticleListBodyInfo> responseInfo = apiUtil.doApi(ApiArticleListBodyInfo.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETARTICLE_LIST), param);
        return responseInfo;
    }

    public ArticleDetail getArticleDetail(String articleID) {
        Map<String, String> param = new HashMap<>();
        param.put("articleID",articleID);
        ApiBaseResponseInfo<ApiArticleBodyInfo> responseInfo = apiUtil.doApi(ApiArticleBodyInfo.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETARTICLEDETAIL_URL), param);
        if (responseInfo != null && responseInfo.getHeader().getCode() == 0) {
            return responseInfo.getBody().getData();
        }
        return null;
    }
}
