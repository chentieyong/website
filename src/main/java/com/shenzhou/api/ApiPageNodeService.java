package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.pageNode.PageNodeByViewUrlBody;
import com.shenzhou.entity.pageNode.PageNodeByViewUrlDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiPageNodeService {
    @Autowired
    private ApiUtil apiUtil;

    public PageNodeByViewUrlDto getPageNodeByViewUrl(String viewUrl) {
        Map<String, String> param = new HashMap<>();
        if (StringUtils.isEmpty(viewUrl)) {
            viewUrl = "index";
        }
        param.put("viewUrl", viewUrl);
        ApiBaseResponseInfo<PageNodeByViewUrlBody> responseInfo = apiUtil.doApi(PageNodeByViewUrlBody.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETPAGENODEBYVIEWURL_URL), param);
        if (responseInfo.getHeader().getCode() == 0 && responseInfo != null) {
            return responseInfo.getBody().getData();
        }
        return null;
    }
}
