package com.shenzhou.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Lazy(false)
public class Config {

    public static String[] WEBSITE_MEMBER_LOGIN_NAME;

    public static String[] WEBSITE_MEMBER_PASSWORD;

    public static String WEBSITE_MEMBER_DEVICE_ID;

    public static String[] WEBSITE_MEMBER_SITE_ID;

    public static String[] WEIXIN_PUBLICNO;

    public static String[] PROJECT_NAME;

    public static String SERVER_URL;

    public static String WEIXIN_SERVER_URL;

    public static String QINIU_SERVER; //七牛up服务

    public static String IMG_SERVER_DOWNLOAD;

    public static final String ARTICLE_OBJECTDEFINEID = "422429993731";//文章对象定义id

    public static final String GOODSSHOP_OBJECTDEFINEID = "422429993732";//店铺商品对象定义id

    public static final String PRODUCTITEM_OBJECTDEFINEID = "ff80808173f0a0030173f0a243b60003";//产品特色

    public static final String PRODUCTFILE_OBJECTDEFINEID = "ff80808173f0a0030173f0a2d5070005";//产品文档

    //交大神舟应用id
    public static final String SHENZHOU_APPLICATION_ID = "ff8080816dfbff6d016dfc459baa0007";

    @Value("${WEBSITE_MEMBER_LOGIN_NAME}")
    public void setWebsiteMemberLoginName(String[] websiteMemberLoginName) {
        WEBSITE_MEMBER_LOGIN_NAME = websiteMemberLoginName;
    }

    @Value("${WEBSITE_MEMBER_PASSWORD}")
    public void setWebsiteMemberPassword(String[] websiteMemberPassword) {
        WEBSITE_MEMBER_PASSWORD = websiteMemberPassword;
    }

    @Value("${WEBSITE_MEMBER_DEVICE_ID}")
    public void setWebsiteMemberDeviceId(String websiteMemberDeviceId) {
        WEBSITE_MEMBER_DEVICE_ID = websiteMemberDeviceId;
    }

    @Value("${WEBSITE_MEMBER_SITE_ID}")
    public void setWebsiteMemberSiteId(String[] websiteMemberSiteId) {
        WEBSITE_MEMBER_SITE_ID = websiteMemberSiteId;
    }

    @Value("${WEIXIN_PUBLICNO}")
    public void setWebsitePublicno(String[] websitePublicno) {
        WEIXIN_PUBLICNO = websitePublicno;
    }

    @Value("${PROJECT_NAME}")
    public void setProjectName(String[] projectName) {
        PROJECT_NAME = projectName;
    }

    @Value("${SERVER_URL}")
    public void setServerUrl(String serverUrl) {
        SERVER_URL = serverUrl;
    }

    @Value("${WEIXIN_SERVER_URL}")
    public void setWeixinServerUrl(String weixinServerUrl) {
        WEIXIN_SERVER_URL = weixinServerUrl;
    }


    public static String getSiteID(String basePath) {
        List<String> basePathList = Arrays.asList(PROJECT_NAME);
        int index = basePathList.indexOf(basePath);
        if (index < 0) {
            return null;
        }
        return WEBSITE_MEMBER_SITE_ID[index];
    }

    public static String getPublicNo(String basePath) {
        List<String> basePathList = Arrays.asList(PROJECT_NAME);
        int index = basePathList.indexOf(basePath);
        if (index < 0) {
            return null;
        }
        return WEIXIN_PUBLICNO[index];
    }

    public static String getMemberName(String basePath) {
        List<String> basePathList = Arrays.asList(PROJECT_NAME);
        int index = basePathList.indexOf(basePath);
        if (index < 0) {
            return null;
        }
        return WEBSITE_MEMBER_LOGIN_NAME[index];
    }

    public static String getMemberPwd(String basePath) {
        List<String> basePathList = Arrays.asList(PROJECT_NAME);
        int index = basePathList.indexOf(basePath);
        if (index < 0) {
            return null;
        }
        return WEBSITE_MEMBER_PASSWORD[index];
    }

    @Value("${com.kingpivot.imgserver.download}")
    public void setImgServerDownload(String imgServerDownload) {
        IMG_SERVER_DOWNLOAD = imgServerDownload;
    }

    @Value("${com.kingpivot.qiniu.upserver}")
    public void setQINIU_SERVER(String qINIU_SERVER) {
        QINIU_SERVER = qINIU_SERVER;
    }

}
