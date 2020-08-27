package com.shenzhou.core;

import com.google.common.collect.Maps;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.utils.HttpUtil;
import com.shenzhou.utils.JsonUtil;
import com.shenzhou.utils.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("apiUtil")
public class ApiUtil {

    public <T> ApiBaseResponseInfo<T> doApi(Class clazz, String url, Map<String, String> param) {
        try {
            if (param == null) {
                param = Maps.newConcurrentMap();
            }
            ApiBaseResponseInfo<T> responseInfo = null;
            String responseStr = HttpUtil.doGet(url, param);
            if (StringUtils.isEmpty(responseStr)) {
                return null;
            }
            responseInfo = JsonUtil.readObject(responseStr, ApiBaseResponseInfo.class);
            if (null == responseInfo || null == responseInfo.getBody() || null == responseInfo.getHeader()) {
                return null;
            }
            if (StringUtils.isNotEmpty(responseInfo.getBody().toString())) {
                if (responseInfo.getBody().toString().contains("=")) {
                    responseInfo.setBody((T) MapUtil.toBean((Map<String, Object>) responseInfo.getBody(), clazz));
                }
            }
            return responseInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
