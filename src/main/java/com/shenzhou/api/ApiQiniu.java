package com.shenzhou.api;

import com.shenzhou.core.ApiUtil;
import com.shenzhou.core.Config;
import com.shenzhou.core.UrlConstants;
import com.shenzhou.entity.base.ApiBaseResponseInfo;
import com.shenzhou.entity.qiniu.QiniuInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chent on 2017/9/26.
 */
@Service
public class ApiQiniu {
    @Autowired
    private ApiUtil apiUtil;

    public ApiBaseResponseInfo<QiniuInfoDto> getQiniuinfo() {
        ApiBaseResponseInfo<QiniuInfoDto> baseResponseInfo = apiUtil.doApi(QiniuInfoDto.class, String.format("%s%s", Config.SERVER_URL, UrlConstants.QINIUINFO_URL), null);
        return baseResponseInfo;
    }
}
