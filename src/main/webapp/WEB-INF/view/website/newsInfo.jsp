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
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/AboutUs.css"/>
</head>

<body>
<div class="wrapper news">
    <jsp:include page="head.jsp"/>

    <section class="slidebox">
        <div class="swiper-container" id="bannerswiper">
            <div class="swiper-wrapper">
                <c:forEach items="${focusList}" var="item" varStatus="xh">
                    <div class="swiper-slide">
                        <img src="${item.picturePath}"/>
                        <c:if test="${!empty item.name}">
                            <div class="bannerslidebox">
                                <div class="slidecont">
                                    <p>${item.name}</p>
                                    <div class="bannerslideline"></div>
                                    <p>${item.description}</p>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
            <div class="swiper-pagination"></div>
        </div>
    </section>
    <section class="newscontainer">
        <div class="tab-box newstab">
            <div class="tab">
                <ul class="clearfix">
                    <c:forEach items="${nodeNavigatorList}" var="item">
                        <li class="${item.functionUrl==url?'action':''}">
                            <a href="${item.functionUrl}">${item.name}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="box">
                <div class="item">
                    <div class="compNewsInfobox">
                        <div class="sharebox"><a><img src="${basepath}/static/website/img/shareicon.png"/>
                            <p>一键分享</p></a></div>
                        <div class="newstitle"><p>${article.title}</p></div>
                        <div class="newsdate"><p>${article.createdTimeStr}</p></div>
                        <div class="newContent">
                            ${article.content}
                        </div>

                        <%--<div class="newsnextprebox">
                            <div class="newspre"><a>上一篇故事：交大神舟荣获梅陇品牌之星最具影响力奖！</a></div>
                            <div class="newsnext"><a>下一篇故事：交大神舟荣获梅陇品牌之星最具影响力奖！</a></div>
                        </div>--%>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="foot.jsp"/>

</div>
<a class="contracticon"><img
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
    });

    $('.sharebox').on('click', function () {
        var url = window.location.href;
        copyUrl(url);
        alert("复制成功！");
    });

    function copyUrl(id) {
        $("body").after("<input id='copyVal'></input>");
        var text = id;
        var input = document.getElementById("copyVal");
        input.value = text;
        input.select();
        input.setSelectionRange(0, input.value.length);
        document.execCommand("copy");
        $("#copyVal").remove();
    }
</script>
</body>

</html>