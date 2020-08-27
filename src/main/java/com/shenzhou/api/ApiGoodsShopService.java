package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.goodsShop.ApiGoodsShopDetailBody;
import com.shenzhou.entity.goodsShop.ApiGoodsShopListBodyInfo;
import com.shenzhou.entity.goodsShop.GoodsShopDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiGoodsShopService {
    @Autowired
    private ApiUtil apiUtil;

    public ApiBaseResponseInfo<ApiGoodsShopListBodyInfo> getGoodsShopList(Map<String, String> param) {
        ApiBaseResponseInfo<ApiGoodsShopListBodyInfo> responseInfo = apiUtil.doApi(ApiGoodsShopListBodyInfo.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETGOODSSHOPLIST_URL), param);
        return responseInfo;
    }

    public GoodsShopDetailDto getGoodsShopDetail(String goodsShopID) {
        Map<String, String> param = new HashMap<>();
        param.put("goodsShopID", goodsShopID);
        ApiBaseResponseInfo<ApiGoodsShopDetailBody> responseInfo = apiUtil.doApi(ApiGoodsShopDetailBody.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETGOODSSHOPDETAIL_URL), param);
        if (responseInfo != null && responseInfo.getBody() != null && responseInfo.getBody().getData() != null) {
            return responseInfo.getBody().getData();
        }
        return null;
    }
}
