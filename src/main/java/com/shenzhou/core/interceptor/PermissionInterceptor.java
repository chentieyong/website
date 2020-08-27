
package com.shenzhou.core.interceptor;

import com.shenzhou.api.ApiSiteViewService;
import com.shenzhou.core.Config;
import com.shenzhou.utils.WebUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 拦截器
 */
@Component
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ApiSiteViewService apiSiteViewService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestURI = request.getRequestURI();
        try {
            if (requestURI.equals("/")
                    || requestURI.equals("index")
                    || requestURI.contains("html")) {
                UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
                Map<String, String> siteViewParam = new HashMap<>();
                siteViewParam.put("applicationID", Config.SHENZHOU_APPLICATION_ID);
                siteViewParam.put("ip", WebUtil.getRemortIP(request));
                siteViewParam.put("url", request.getRequestURI());
                siteViewParam.put("operatingSystem", userAgent.getOperatingSystem().toString());
                siteViewParam.put("browserType", userAgent.getBrowser().toString());
                siteViewParam.put("address", "");
                apiSiteViewService.submitOneSiteView(siteViewParam);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }

}
