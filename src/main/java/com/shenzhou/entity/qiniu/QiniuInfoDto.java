package com.shenzhou.entity.qiniu;

/**
 * Created by Administrator on 2017/6/15.
 */
public class QiniuInfoDto {
    private String uploadToken;
    private String coverSuffix;

    public String getUploadToken() {
        return uploadToken;
    }

    public void setUploadToken(String uploadToken) {
        this.uploadToken = uploadToken;
    }

    public String getCoverSuffix() {
        return coverSuffix;
    }

    public void setCoverSuffix(String coverSuffix) {
        this.coverSuffix = coverSuffix;
    }
}
