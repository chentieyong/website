package com.shenzhou.api;

import com.google.common.collect.Maps;
import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.parameter.ApiGetParameterBodyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ApiParameterService {
    @Autowired
    private ApiUtil apiUtil;

    /**
     * 获取系统参数
     */
    public String getValue(String code) {
        String value = "";
        Map<String, String> param1 = Maps.newConcurrentMap();
        param1.put("code", code);
        ApiBaseResponseInfo<ApiGetParameterBodyInfo> baseResponseInfo1 = apiUtil.doApi(ApiGetParameterBodyInfo.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETSYSTEMPARAMETER_URL), param1);
        if (baseResponseInfo1 != null && baseResponseInfo1.getHeader().getCode() == 0) {
            value = baseResponseInfo1.getBody().getValue();
            if (value != null && value != "") {
                return value;
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}
