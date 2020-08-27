package com.shenzhou.entity.member;

import java.io.Serializable;
import java.sql.Timestamp;

public class Member implements Serializable {

    private static final long serialVersionUID = -1300306668752973060L;

    private String id;//主键

    private String qq;//名称

    private String qqToken;//名称
    private String peopleID;//人员ID 未实现

    private String majorID;//人员ID 未实现

    private String companyID;//公司ID 未实现

    private String applicationID;//应用ID 未实现

    private String rankID;

    private String districtID;//名称

    private String cityID;//名称

    private String tradePassword;//名称

    private String name;//名称

    private String shortName;//简称

    private String loginName;//登录名

    private String loginPassword;//登录密码

    private String realPassword;//原密码

    private String buyPassword; //deal pass

    private String phone;//手机号码

    private String email;//电子邮件

    private String weibo;//微博号

    private String weiboToken;//微博token

    private String weixin;//微信号

    private String weixinToken;//微信token

    private String homeAddr;//家庭地址

    private String homeZip;//邮编

    private Timestamp lastConsumeDate;//

    private String lastConsumeShop;//最后消费商户，功能未实现

    private String lastConsumeLocal;//最后消费地点

    private String avatarURL;//头像URL

    private String avatarSmall;//头像URL

    private String avatarMIddle;//头像URL

    private String avatarLarge;//头像URL

    private String gradeID;//等级id，未实现

    private int point = 0;//积分

    private int pointTotal = 0;//累计积分

    private int golden = 0;//金币

    private float cash = 0.0f;

    private String recommandID;//

    private String recommandCode;//

    private String recommandName;//

    private String title;//

    private String titleID;


    private Timestamp birthday;

    private String birthdayStr;

    private String shortDescription;

    private String description;

    private String sessionId;

    private Timestamp createdTime;//创建时间

    private Timestamp modifiedTime;//最后修改时间

    private String siteID;

    public Member() {
    }

    public Member(String loginName, String sessionId) {
        this.loginName = loginName;
        this.sessionId = sessionId;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getQqToken() {
        return qqToken;
    }

    public void setQqToken(String qqToken) {
        this.qqToken = qqToken;
    }

    public String getPeopleID() {
        return peopleID;
    }

    public void setPeopleID(String peopleID) {
        this.peopleID = peopleID;
    }

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getRankID() {
        return rankID;
    }

    public void setRankID(String rankID) {
        this.rankID = rankID;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getBuyPassword() {
        return buyPassword;
    }

    public void setBuyPassword(String buyPassword) {
        this.buyPassword = buyPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getWeiboToken() {
        return weiboToken;
    }

    public void setWeiboToken(String weiboToken) {
        this.weiboToken = weiboToken;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getWeixinToken() {
        return weixinToken;
    }

    public void setWeixinToken(String weixinToken) {
        this.weixinToken = weixinToken;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    public Timestamp getLastConsumeDate() {
        return lastConsumeDate;
    }

    public void setLastConsumeDate(Timestamp lastConsumeDate) {
        this.lastConsumeDate = lastConsumeDate;
    }

    public String getLastConsumeShop() {
        return lastConsumeShop;
    }

    public void setLastConsumeShop(String lastConsumeShop) {
        this.lastConsumeShop = lastConsumeShop;
    }

    public String getLastConsumeLocal() {
        return lastConsumeLocal;
    }

    public void setLastConsumeLocal(String lastConsumeLocal) {
        this.lastConsumeLocal = lastConsumeLocal;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getAvatarSmall() {
        return avatarSmall;
    }

    public void setAvatarSmall(String avatarSmall) {
        this.avatarSmall = avatarSmall;
    }

    public String getAvatarMIddle() {
        return avatarMIddle;
    }

    public void setAvatarMIddle(String avatarMIddle) {
        this.avatarMIddle = avatarMIddle;
    }

    public String getAvatarLarge() {
        return avatarLarge;
    }

    public void setAvatarLarge(String avatarLarge) {
        this.avatarLarge = avatarLarge;
    }

    public String getGradeID() {
        return gradeID;
    }

    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(int pointTotal) {
        this.pointTotal = pointTotal;
    }

    public int getGolden() {
        return golden;
    }

    public void setGolden(int golden) {
        this.golden = golden;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }

    public String getRecommandID() {
        return recommandID;
    }

    public void setRecommandID(String recommandID) {
        this.recommandID = recommandID;
    }

    public String getRecommandCode() {
        return recommandCode;
    }

    public void setRecommandCode(String recommandCode) {
        this.recommandCode = recommandCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleID() {
        return titleID;
    }

    public void setTitleID(String titleID) {
        this.titleID = titleID;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRealPassword() {
        return realPassword;
    }

    public void setRealPassword(String realPassword) {
        this.realPassword = realPassword;
    }

    public String getRecommandName() {
        return recommandName;
    }

    public void setRecommandName(String recommandName) {
        this.recommandName = recommandName;
    }
}
