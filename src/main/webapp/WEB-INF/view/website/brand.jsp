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
<div class="wrapper brandstory">
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
    <section class="brandcontainer">
        <div class="daoyanbox">
            <div class="daoyaninfobox">
                <div class="daoyantitile">
                    <p>导言</p>
                </div>
                <hr/>
                <div class="daoyaninfo">
                    <p>
                        ${description}
                    </p>
                </div>
            </div>
        </div>
        <div class="brandstoryinfobox">
            <div class="storylistbox">
                <c:forEach items="${brandArticleList}" var="item">
                    <div class="branditem">
                        <img src="${item.listImage}"/>
                        <div class="brandtitle">
                            <p>${item.title}</p>
                        </div>
                        <div class="branddes">
                            <p>
                                    ${item.description}
                            </p>
                        </div>
                        <div class="brandmoreinfo"><a href="brandInfo.html?artId=${item.id}">了解详情 > </a></div>
                    </div>
                </c:forEach>
            </div>
            <div class="pagesbox">
                <button class="firstpage" type="button" onclick="pageBrand(1)">第一页</button>
                <button class="prevpage" type="button" onclick="pageBrand(${currentPage-1==0?1:currentPage-1})">上一页
                </button>
                <p class="currentPage">${currentPage}</p>
                <button class="nextpage" type="button"
                        onclick="pageBrand(${currentPage==totalPage?currentPage:currentPage+1})">下一页
                </button>
                <button class="endpage" type="button" onclick="pageBrand(${totalPage})">最末页</button>
            </div>
        </div>
    </section>

    <jsp:include page="foot.jsp"/>
</div>

<a href="tencent://message/?uin=2975463389&Site=&Menu=yes" class="contracticon"><img
        src="${basepath}/static/website/img/contracticon.png"/>
    <p>联系我们</p></a>
<img src="${basepath}/static/website/img/backtotop.png" class="backtotop"/>
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

    function pageBrand(s) {
        location.href = basepath + '/brand.html?s=' + s
    }
</script>
</body>

</html>