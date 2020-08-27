package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.attachment.ObjectAttachmentListBody;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApiAttachmentService {
    @Autowired
    private ApiUtil apiUtil;

    public ApiBaseResponseInfo<ObjectAttachmentListBody> getObjectAttachmentList(Map<String, String> param) {
        ApiBaseResponseInfo<ObjectAttachmentListBody> responseInfo = apiUtil.doApi(ObjectAttachmentListBody.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.GETOBJECTATTACHMENTLIST_URL), param);
        return responseInfo;
    }
}
