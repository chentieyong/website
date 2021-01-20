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
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/hangye.css"/>
</head>

<body>
<div class="wrapper Hangye">
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
    <section class="Hangyecontainer">
        <div class="hangyetab">
            <div class="hylefttab">
                <ul class="clearfix">
                    <c:forEach items="${nodeNavigatorList}" var="item">
                        <li class="">
                            <a href="#${item.id}">${item.name}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="Hangyebox">
                <div class="hyitembox">
                    <c:forEach items="${nodeNavigatorList}" var="item">
                        <div class="hyitem" id="${item.id}">
                            <div class="hytitle">
                                <p>${item.name}</p>
                            </div>
                            <div class="hyinfocontainer">
                                <c:forEach items="${item.articleList}" var="articleItem">
                                    <div class="hyinfoitem">
                                        <div class="hyinfoimg"><img src="${articleItem.listImage}"/></div>
                                        <div class="hyproname">
                                            <p>${articleItem.title}</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <hr/>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>

    <jsp:include page="foot.jsp"/>

</div>
<a class="contracticon">
    <img src="${basepath}/static/website/img/contracticon.png"/>
    <p>Feedback</p></a>
<img src="${basepath}/static/website/img/backtotop.jpg" class="backtotop"/>
<script type="text/javascript" src="${basepath}/static/website/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/swiper.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/common.js"></script>
<script>
    $(window).scroll(function() {
        var _top = $(window).scrollTop();
        if(_top > ($('.header').height() + $('.slidebox').height())) {
            $('.hylefttab').css({
                'position': 'fixed',
                'top': '20px',
                'left': '5.2%'
            });
        } else {
            $('.hylefttab').css({
                'position': 'absolute',
                'top': '0',
                'left': '0'
            });
        }

        if(_top > ($('.Hangyebox').height() + $('.hylefttab').height())) {
            $('.hylefttab').css({
                'position': 'absolute',
                'top': '0',
                'left': '0'
            });
        }
    });
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
</script>
</body>

</html>