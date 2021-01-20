<%@include file="/WEB-INF/view/website/taglibs.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8"/>
    <title>${pageNode.name}</title>
    <meta name="keywords" content="${pageNode.metaName}"/>
    <meta name="description" content="${pageNode.metaDescription}"/>
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${basepath}/static/website/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${basepath}/static/website/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/swiper.min.css"/>
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/fonts.css"/>
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/index.css"/>
</head>

<body>
<div class="wrapper index">
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
    <section class="searchbox">
        <div class="searchtitlebox">
            <p>探索我们的产品</p>
        </div>
        <div class="searchprobox">
            <div class="searchprocont">

                <c:forEach items="${categoryList}" var="item">
                    <c:if test="${item.name!='Systems'}">
                        <div class="searchproitem" onclick="toHref('${basepath}/product.html#${item.id}')">
                            <img src="${item.smallIcon}"/>
                            <div class="searchpronamebox">
                                <p>${item.name}</p>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </section>
    <section class="casetotalbox">
        <div class="casetotalvideobox">
            <video class="casetotalvideo" src="${workArticle.videoURL}" controls poster="${workArticle.videoImage}"
                   webkit-playsinline="true" x-webkit-airplay="true"
                   playsinline="true" x5-video-player-type="h5" x5-video-player-fullscreen="true" width="100%"
                   height="100%"
                   preload="auto" style="object-fit: cover"></video>
        </div>
        <div class="casetotaldesbox">
            <div class="totalbox">
                <div class="totaldestitlebox">
                    <p>${workArticle.title}</p>
                </div>
                <div class="totaldeswordsbox">
                    <p>${workArticle.subTitle}</p>
                </div>
                <hr/>
                <div class="totaldesinfobox">
                    <p>
                        ${workArticle.description}</p>
                </div>
                <div class="totalmoreinfobox">
                    <%--                    <a href="${basepath}/brandInfo.html?artId=${workArticle.id}">了解更多</a>--%>
                </div>
            </div>
        </div>
    </section>
    <section class="innovatebox">
        <img src="${innovateArticle.listImage}" class="partbgimg"/>
        <div class="compinfobox">
            <div class="cominfo">
                <div class="comptitlebox">
                    <p>${innovateArticle.title}</p>
                </div>
                <div class="compwordsbox">
                    <p>${innovateArticle.description}</p>
                </div>
                <div class="compmoreinfobox">
                    <button type="button" onclick="toHref('${basepath}/aboutUs.html')">
                        Read more >>
                    </button>
                </div>
            </div>
        </div>
    </section>
    <section class="brandstorybox">
        <img src="${brandStoryArticle.listImage}" class="partbgimg"/>
        <div class="compinfobox">
            <div class="cominfo">
                <div class="comptitlebox">
                    <p>${brandStoryArticle.title}</p>
                </div>
                <div class="compwordsbox">
                    <p>${brandStoryArticle.description}</p>
                </div>
                <div class="compmoreinfobox">
                    <button type="button" onclick="toHref('${basepath}/brand.html')">
                        Read more >>
                    </button>
                </div>
            </div>
        </div>
    </section>
    <section class="servicebox">
        <img src="${afterServiceArticle.listImage}" class="partbgimg"/>
        <div class="compinfobox">
            <div class="cominfo">
                <div class="comptitlebox">
                    <p>${afterServiceArticle.title}</p>
                </div>
                <div class="compwordsbox">
                    <p>${afterServiceArticle.description}</p>
                </div>
                <div class="compmoreinfobox">
                    <button type="button" onclick="toHref('${basepath}/service.html')">Read more >></button>
                </div>
            </div>
        </div>
    </section>
    <section class="news">
        <div class="newsinfobox">
            <c:forEach items="${indexRecommendArticleList}" var="item">
                <div class="newsproitem">
                    <img src="${item.listImage}"/>
                    <div class="newstitlebox">
                        <p>${item.title}</p>
                    </div>
                    <div class="newsdesbox">
                        <p>${item.description}</p>
                    </div>
                    <div class="newsmoreinfobox">
                        <a href="${basepath}/newsInfo.html?artId=${item.id}">Read more ></a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
    <section class="contractbox">
        <div class="contractfrmbox">
            <p class="contracttitle">Feedback</p>
            <form class="contractfrm" id="feed_form">
                <div class="contract_item">
                    <input type="text" class="ctipt username" name="contact" placeholder="Name"/>
                    <input type="text" class="ctipt usersex" name="sex" placeholder="Title"/>
                </div>
                <div class="contract_item">
                    <input type="text" class="ctipt usercompname" name="companyName" placeholder="Company name"/>
                    <input type="text" class="ctipt userhy" name="industryName" placeholder="Industry"/>
                </div>
                <div class="contract_item">
                    <input type="text" class="ctipt userdept" name="departmentName" placeholder="Department"/>
                    <input type="text" class="ctipt userpost" name="jobName" placeholder="Position"/>
                </div>
                <div class="contract_item">
                    <input type="email" class="ctipt useremail" name="email" placeholder="E-mail"/>
                    <input type="tel" class="ctipt usertel" name="contacts" placeholder="Phone"/>
                </div>
                <textarea class="usermessage" name="contant" placeholder="Your question"></textarea>
                <input type="button" class="contract_submit" value="Submit" onclick="submitOneFeed()"/>
            </form>
        </div>
        <div class="contractotherbox">
            <div class="QQ">
                <img src="${basepath}/static/website/img/qq.png"/>
                <p class="qqnum">2975 463 389</p>
            </div>
            <div class="phone">
                <img src="${basepath}/static/website/img/contect-phone.png"/>
                <p class="telnum">4006 081 080</p>
            </div>
            <img src="${basepath}/static/website/img/QRcode.png" class="qrcodeimg"/>
            <p class="kfname">WeChat</p>
        </div>
        <img src="${basepath}/static/website/img/contect-productpic.png" class="indexbotimg"/>
    </section>

    <jsp:include page="foot.jsp"/>

</div>

<a class="contracticon"><img
        src="${basepath}/static/website/img/contracticon.png"/>
    <p>Feedback</p></a>
<img src="${basepath}/static/website/img/backtotop.jpg" class="backtotop"/>
<script type="text/javascript" src="${basepath}/static/website/js/swiper.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/common.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/feed.js"></script>
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

    function toHref(url) {
        window.location.href = url
    }
</script>
</body>

</html>