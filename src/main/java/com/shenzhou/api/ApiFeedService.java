package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.feed.SubmitOneFeedBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApiFeedService {
    @Autowired
    private ApiUtil apiUtil;

    public String submitOneFeed(Map<String, String> param) {
        ApiBaseResponseInfo<SubmitOneFeedBody> responseInfo = apiUtil.doApi(SubmitOneFeedBody.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.SUBMITONEFEED_URL), param);
        if (responseInfo != null && responseInfo.getHeader().getCode() == 0) {
            return "SUCCESS";
        } else {
            return responseInfo.getHeader().getMsg();
        }
    }
}
