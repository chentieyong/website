package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.siteView.SubmitOneSiteViewBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApiSiteViewService {
    @Autowired
    private ApiUtil apiUtil;

    public boolean submitOneSiteView(Map<String, String> param) {
        ApiBaseResponseInfo<SubmitOneSiteViewBody> responseInfo = apiUtil.doApi(SubmitOneSiteViewBody.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.SUBMITONESITEVIEW_URL), param);
        if (responseInfo != null && responseInfo.getHeader().getCode() == 0) {
            return true;
        }
        return false;
    }
}
