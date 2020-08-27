package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.goodsShopParameter.GoodsShopParameterListBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApiGoodsShopParameterService {
    @Autowired
    private ApiUtil apiUtil;

    public ApiBaseResponseInfo<GoodsShopParameterListBody> getGoodsShopParameterList(Map<String, String> param) {
        ApiBaseResponseInfo<GoodsShopParameterListBody> responseInfo = apiUtil.doApi(GoodsShopParameterListBody.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETGOODSSHOPPARAMETERLIST_URL), param);
        return responseInfo;
    }
}
