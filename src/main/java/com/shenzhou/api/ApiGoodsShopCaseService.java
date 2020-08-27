package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.goodsShopCase.GoodsShopCaseListBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApiGoodsShopCaseService {
    @Autowired
    private ApiUtil apiUtil;

    public ApiBaseResponseInfo<GoodsShopCaseListBody> getGoodsShopCaseList(Map<String, String> param) {
        ApiBaseResponseInfo<GoodsShopCaseListBody> responseInfo = apiUtil.doApi(GoodsShopCaseListBody.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETGOODSSHOPCASELIST_URL), param);
        return responseInfo;
    }
}
