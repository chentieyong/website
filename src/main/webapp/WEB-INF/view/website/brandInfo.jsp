<%@include file="/WEB-INF/view/website/taglibs.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>${pageNode.name}</title>
    <meta name="keywords" content="${pageNode.metaName}"/>
    <meta name="description" content="${pageNode.metaDescription}"/>
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/swiper.min.css"/>
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/fonts.css"/>
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/Brandstory.css"/>
</head>

<body>
<div class="wrapper brandstoryinfo">
    <jsp:include page="head.jsp"/>

    <section class="slidebox">
        <div class="swiper-container" id="bannerswiper">
            <div class="swiper-wrapper">
                <c:forEach items="${focusList}" var="item" varStatus="xh">
                    <c:if test="${xh.index==0}">
                        <div class="swiper-slide">
                            <img src="${item.picturePath}"/>
                            <div class="bannerslidebox">
                                <div class="slidecont">
                                    <p>品牌故事</p>
                                    <div class="bannerslideline"></div>
                                    <p>用节能环保的汽车技术服务社会</p>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${xh.index!=0}">
                        <div class="swiper-slide">
                            <img src="${item.picturePath}"/>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="swiper-pagination"></div>
        </div>
    </section>
    <section class="brandinfocontainer">
        <div class="brandinfobox">
            <div class="sharebox">
                <a><img src="${basepath}/static/website/img/shareicon.png"/>
                    <p>一键分享</p>
                </a>
            </div>
            <div class="brandinfotitle">
                <p>${article.title}</p>
            </div>
            <div class="newContent">
                ${article.content}
            </div>
        </div>
        <%--<div class="brandnextprebox">
            <div class="brandpre"><a>上一篇故事：交大神舟荣获梅陇品牌之星最具影响力奖！</a></div>
            <div class="brandnext"><a>下一篇故事：交大神舟荣获梅陇品牌之星最具影响力奖！</a></div>
        </div>--%>
    </section>

    <jsp:include page="foot.jsp"/>
</div>

<a href="tencent://message/?uin=2975463389&Site=&Menu=yes" class="contracticon"><img
        src="${basepath}/static/website/img/contracticon.png"/>
    <p>联系我们</p></a>
<img src="${basepath}/static/website/img/backtotop.jpg" class="backtotop"/>
<script type="text/javascript" src="${basepath}/static/website/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/swiper.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/common.js"></script>
<script>
    var bannerswiper = new Swiper('#bannerswiper', {
        speed: 1500,
        loop: true,
        autoplay: {
            delay: 2500
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
    })
</script>
</body>

</html>