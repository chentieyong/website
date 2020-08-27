package com.shenzhou.api;

import com.google.common.collect.Maps;
import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.CacheUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.focus.ApiFocusBodyInfo;
import com.shenzhou.entity.focus.FocusInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Coder on 2016/12/20.
 */
@Service
public class ApiFocusService {

    @Autowired
    private ApiUtil apiUtil;
    @Autowired
    private CacheUtil cacheUtil;

    /**
     * 获取轮播图
     *
     * @param focusID 焦点图ID
     * @param cache   是否缓存
     * @return
     */
    public List<FocusInfo> getFocusList(String focusID, boolean cache) {
        String focusKey = String.format("focus_%s", focusID);
        List<FocusInfo> focusInfoList = new ArrayList<>();
        if (cache) {
            focusInfoList = (List<FocusInfo>) this.cacheUtil.getCacheValue(focusKey);
            if (focusInfoList != null && focusInfoList.size() != 0) {
                return focusInfoList;
            }
        }

        Map<String, String> param = Maps.newConcurrentMap();
        param.put("focusID", focusID);
        param.put("pageNumber", "9999");
        ApiBaseResponseInfo<ApiFocusBodyInfo> baseResponseInfo = apiUtil.doApi(ApiFocusBodyInfo.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETFOCUSPICTURELIST_URL), param);
        if (baseResponseInfo.getHeader().getCode() == 0 && baseResponseInfo != null) {
            focusInfoList = baseResponseInfo.getBody().getData().getRows();
            if (cache) {
                this.cacheUtil.setCacheValue(focusKey, focusInfoList);
            }
        }
        return focusInfoList;
    }

}
