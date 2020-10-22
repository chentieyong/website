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
                    <div class="compHonorbox">
                        <div class="comphonortitle"><p>荣誉资质</p></div>
                        <hr/>
                        <div class="comphonorlistbox">
                            <c:forEach items="${honorArticleList}" var="item">
                                <div class="comphonoritem">
                                    <img src="${item.listImage}"/>
                                    <div class="comphonorname"><p>${item.title}</p></div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="compBigPhoto hidden">
                        <img src=""/>
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
    $(window).scroll(function() {
        var _top = $(window).scrollTop();
        if(_top > ($('.header').height() + $('.slidebox').height())) {
            $('.tab').css({
                'position': 'fixed',
                'top': '20px',
                'left': '5.2%'
            });
        } else {
            $('.tab').css({
                'position': 'absolute',
                'top': '0',
                'left': '0'
            });
        }

        if(_top > ($('.box').height() + $('.tab').height())) {
            $('.tab').css({
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

    $('.comphonoritem img').click(function () {
        $('.compBigPhoto').removeClass('hidden');
        $('.compBigPhoto').children('img').attr('src', $(this).attr('src'));
    });
    $('.compBigPhoto').click(function () {
        $('.compBigPhoto').addClass('hidden');
    });
</script>
</body>

</html>