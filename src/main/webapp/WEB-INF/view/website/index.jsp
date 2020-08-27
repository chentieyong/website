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
                    <c:if test="${xh.index==0}">
                        <div class="swiper-slide">
                            <img src="${item.picturePath}"/>
                            <div class="bannerslidebox">
                                <div class="slidecont">
                                    <p>交大神舟</p>
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
    <section class="searchbox">
        <div class="searchtitlebox">
            <p>探索我们的产品</p>
        </div>
        <div class="searchprobox">
            <div class="searchprocont">
                <c:forEach items="${productNavGoodsList}" var="item">
                    <div class="searchproitem" onclick="toHref('${basepath}/productInfo.html?pid=${item.objectID}')">
                        <img src="${item.listImage}"/>
                        <div class="searchpronamebox">
                            <p>${item.objectName}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
    <section class="casetotalbox">
        <div class="casetotalvideobox">
            <video class="casetotalvideo" src="${workArticle.videoURL}" controls
                   x-webkit-airplay="true" webkit-playsinline="true" playsinline="true"
                   x5-video-player-type="h5"></video>
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
                    <a>了解更多</a>
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
                    <button type="button" onclick="toHref('${basepath}/brandInfo.html?artId=${innovateArticle.id}')">查看详情 >></button>
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
                    <button type="button" onclick="toHref('${basepath}/brandInfo.html?artId=${brandStoryArticle.id}')">查看详情 >></button>
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
                    <button type="button" onclick="toHref('${basepath}/service.html')">查看详情 >></button>
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
                        <a>了解详情 ></a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
    <section class="contractbox">
        <div class="contractfrmbox">
            <p class="contracttitle">联系我们</p>
            <form class="contractfrm" id="feed_form">
                <div class="contract_item">
                    <input type="text" class="ctipt username" name="contact" placeholder="姓名"/>
                    <input type="text" class="ctipt usersex" name="sex" placeholder="性别"/>
                </div>
                <div class="contract_item">
                    <input type="text" class="ctipt usercompname" name="companyName" placeholder="公司名称"/>
                    <input type="text" class="ctipt userhy" name="industryName" placeholder="所属行业"/>
                </div>
                <div class="contract_item">
                    <input type="text" class="ctipt userdept" name="departmentName" placeholder="所属部门"/>
                    <input type="text" class="ctipt userpost" name="jobName" placeholder="职务"/>
                </div>
                <div class="contract_item">
                    <input type="email" class="ctipt useremail" name="email" placeholder="电子邮箱"/>
                    <input type="tel" class="ctipt usertel" name="contacts" placeholder="电话号码"/>
                </div>
                <textarea class="usermessage" name="contant" placeholder="如果你想添加任何说明，请在此处留言"></textarea>
                <input type="button" class="contract_submit" value="提交" onclick="submitOneFeed()"/>
            </form>
        </div>
        <div class="contractotherbox">
            <div class="servicetelbox">
                <img src="${basepath}/static/website/img/contect-phone.png" class="phoneicon"/>
                <p>服务热线 <br/>4006-081-080</p>
            </div>
            <img src="${basepath}/static/website/img/QRcode.png" class="qrcodeimg"/>
            <p class="kfname">添加微信客服：小舟</p>
        </div>
        <img src="${basepath}/static/website/img/contect-productpic.png" class="indexbotimg"/>
    </section>

    <jsp:include page="foot.jsp"/>

</div>

<a href="tencent://message/?uin=2975463389&Site=&Menu=yes" class="contracticon"><img
        src="${basepath}/static/website/img/contracticon.png"/>
    <p>联系我们</p></a>
<img src="${basepath}/static/website/img/backtotop.png" class="backtotop"/>
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