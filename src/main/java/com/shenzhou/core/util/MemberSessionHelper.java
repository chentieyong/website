package com.shenzhou.core.util;


import com.shenzhou.core.CacheUtil;
import com.shenzhou.core.Config;
import com.shenzhou.entity.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 2014/12/25.
 */
@Component("memberSessionHelper")
public class MemberSessionHelper {

    @Autowired
    private CacheUtil cacheUtil;
    private static final String AUTHORIZE_PREFIX_CURRENTUSER = "currentUser_";

    private static final String AUTHORIZE_IS_CURRENTUSER = "IS_FIRST_";

    /**
     * 获取当前用户ID
     *
     * @return
     */
    public Member getCurrentUser(String sessionID, String basePath) {
        String siteID = Config.getSiteID(basePath);
        Object cacheValue = cacheUtil.getCacheValue(AUTHORIZE_PREFIX_CURRENTUSER + sessionID + siteID);
        if (StringUtils.isEmpty(cacheValue)) {
            return null;
        }
        return (Member) cacheValue;
    }

    /**
     * 设置当前用户ID
     *
     * @return
     */
    public void setCurrentUser(String sessionID, String basePath, Member member) {
        String siteID = Config.getSiteID(basePath);
        cacheUtil.setCacheValue(AUTHORIZE_PREFIX_CURRENTUSER + sessionID + siteID, member);
    }

    /**
     * 将当前用户放入缓存
     *
     * @param member
     */
    public void setCurrentUser(HttpServletRequest request, Member member, String basePath) {
        if (null == member) {
            return;
        }
        if (null != member && org.apache.commons.lang3.StringUtils.isNotEmpty(member.getLoginName())) {
            if (org.apache.commons.lang3.StringUtils.isBlank(member.getShortName())) {
                String shortName = member.getLoginName().substring(0, 3) + "****" + member.getLoginName().substring(7);
                member.setLoginName(shortName);
            }
        }
        String siteID = Config.getSiteID(basePath);
        String sessionId = request.getSession().getId();
        cacheUtil.setCacheValue(AUTHORIZE_PREFIX_CURRENTUSER + sessionId + siteID, member);
    }

    public void setCurrentUserSessionId(String sessionID, String basePath) {
        String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
        String siteID = Config.getSiteID(basePath);
        cacheUtil.setCacheValue(AUTHORIZE_IS_CURRENTUSER + sessionId + siteID, sessionID);
    }

    public boolean getCurrentUserSessionId(String basePath) {
        String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
        String siteID = Config.getSiteID(basePath);
        Object obj = cacheUtil.getCacheValue(AUTHORIZE_IS_CURRENTUSER + sessionId + siteID);
        if (null == obj) {
            return true;
        }
        return false;
    }

    /**
     * 将当前用户信息从缓存中清空
     */
    public void destroyCurrentUser(String basePath) {
        String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
        String siteID = Config.getSiteID(basePath);
        cacheUtil.removeCacheValue(AUTHORIZE_PREFIX_CURRENTUSER + sessionId + siteID);
    }

    public String getCurrentMemberSessionId(String basePath) {
        String sessionID = RequestContextHolder.getRequestAttributes().getSessionId();
        Member member = getCurrentUser(sessionID, basePath);
        if (null != member && org.apache.commons.lang3.StringUtils.isNotEmpty(member.getSessionId())) {
            return member.getSessionId();
        }
        return null;
    }

    public String getCurrentMemberId(String basePath) {
        String sessionID = RequestContextHolder.getRequestAttributes().getSessionId();
        Member member = getCurrentUser(sessionID, basePath);
        if (null != member && org.apache.commons.lang3.StringUtils.isNotEmpty(member.getSessionId())) {
            return member.getId();
        }
        return null;
    }

    public Member getCurrentMember(String basePath) {
        String sessionID = RequestContextHolder.getRequestAttributes().getSessionId();
        Member member = getCurrentUser(sessionID, basePath);

        if (null != member && org.apache.commons.lang3.StringUtils.isNotEmpty(member.getSessionId())) {
            return member;
        }
        return null;
    }

}
