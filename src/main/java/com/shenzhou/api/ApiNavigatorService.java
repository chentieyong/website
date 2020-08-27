package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.CacheUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.depthNavigator.ApiDepthNavigatorBodyInfo;
import com.shenzhou.entity.depthNavigator.ApiDepthNavigatorInfo;
import com.shenzhou.entity.navigator.ApiNavigatorBodyInfo;
import com.shenzhou.entity.navigator.ApiNavigatorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chent on 2017/9/29.
 */
@Service
public class ApiNavigatorService {
    @Autowired
    private ApiUtil apiUtil;
    @Autowired
    private CacheUtil cacheUtil;

    public List<ApiNavigatorInfo> getNodeNavigatorList(Map<String, String> param) {
        List<ApiNavigatorInfo> navList = new ArrayList<>();
        ApiBaseResponseInfo<ApiNavigatorBodyInfo> baseResponseInfo = apiUtil.doApi(ApiNavigatorBodyInfo.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETNODENAVIGATORLIST_URL), param);
        if (baseResponseInfo.getHeader().getCode() == 0 && baseResponseInfo != null) {
            navList = baseResponseInfo.getBody().getData().getRows();
        }
        return navList;
    }

    public List<ApiDepthNavigatorInfo> getNavigatorList(Map<String, String> param, boolean cache) {
        List<ApiDepthNavigatorInfo> navList = new ArrayList<>();
        if (cache) {
            navList = (List<ApiDepthNavigatorInfo>) cacheUtil.getCacheValue("NAV_LIST");
        }
        if (navList == null || navList.size() == 0) {
            ApiBaseResponseInfo<ApiDepthNavigatorBodyInfo> baseResponseInfo = apiUtil.doApi(ApiDepthNavigatorBodyInfo.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETNAVIGATORLIST_URL), param);
            if (baseResponseInfo.getHeader().getCode() == 0 && baseResponseInfo != null) {
                navList = baseResponseInfo.getBody().getData().getData().getNodes();
                cacheUtil.setCacheValue("NAV_LIST", navList);
            }
        }
        return navList;
    }
}
