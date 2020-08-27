package com.shenzhou.entity.site;

public class ApiSiteServicerDto {
    private String id;
    private String siteID;
    private String name;
    private String qqName;
    private String phone;
    private String isOnline;
    private String orderSeq;
    private String weixin;
    private String weixinQcode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQqName() {
        return qqName;
    }

    public void setQqName(String qqName) {
        this.qqName = qqName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public String getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(String orderSeq) {
        this.orderSeq = orderSeq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getWeixinQcode() {
        return weixinQcode;
    }

    public void setWeixinQcode(String weixinQcode) {
        this.weixinQcode = weixinQcode;
    }
}
