<%@include file="/WEB-INF/view/website/taglibs.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <div class="container-fluid nav-top-lg">
        <div class="header-top">
            <img src="${basepath}/static/website/img/logo.png" class="navlogo"/>
            <div class="navline"></div>
            <div class="sloganbox">
                <p class="navslogan">用节能环保的汽车技术服务社会</p>
                <p class="navsloganEn">Serving Society with Eco-friendly Vehicle Technology</p>
            </div>
            <div class="languagebox">
                <img src="${basepath}/static/website/img/languageicon.png"/>
                <span><a href="${basepath}/index">中</a>/<a class="lgeactive" href="#">En</a></span>
            </div>
            <button class="nav-button" id="navbtn">
                <div class="line line__1"></div>
                <div class="line line__2"></div>
                <div class="line line__3"></div>
            </button>
        </div>
        <div class="navbox">
            <ul class="ul">
                <c:forEach items="${headNavigatorList}" var="item">
                    <li>
                        <a href="${item.functionUrl}">${item.name}
                            <c:if test="${!empty item.nodes}">
                                <img src="${basepath}/static/website/img/selecticon.png"/>
                            </c:if>
                        </a>
                        <ul class="nav_droplist">
                            <c:forEach items="${item.nodes}" var="nodeItem">
                                <li>
                                    <a href="${nodeItem.functionUrl}">${nodeItem.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </div>

    </div>
</div>