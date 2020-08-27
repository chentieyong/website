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
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/Service.css"/>
</head>

<body>
<div class="wrapper service">
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
                                    <p>金融支持l</p>
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

    <section class="servicecontainer">
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
                    <div class="financesupportcontainer">
                        <div class="content">
                            ${supportArticle.content}
                        </div>
                        <div class="finasupcontract">
                            <div class="Intcontract">
                                <div class="Intfrmbox">
                                    <div class="lxtxt">联系我们</div>
                                    <form class="lxfrm" id="feed_form">
                                        <div class="lxfrmitem">
                                            <input type="text" class="username" name="contact" placeholder="姓名"/>
                                            <input type="text" class="usersex" name="sex" placeholder="性别"/>
                                        </div>
                                        <div class="lxfrmitem">
                                            <input type="text" class="usercompname" name="companyName" placeholder="公司名称"/>
                                            <input type="text" class="userhy" name="industryName" placeholder="所属行业"/>
                                        </div>
                                        <div class="lxfrmitem">
                                            <input type="text" class="userdept" name="departmentName" placeholder="所属部门"/>
                                            <input type="text" class="userpost" name="jobName" placeholder="职务"/>
                                        </div>
                                        <div class="lxfrmitem">
                                            <input type="text" class="useremail" name="email" placeholder="电子邮件"/>
                                            <input type="text" class="usertel" name="contacts" placeholder="电话号码"/>
                                        </div>
                                        <textarea class="usermessage" name="contant" placeholder="如果你想添加任何说明，请在此处留言"></textarea>
                                        <input type="button" class="contract_submit" value="提交" onclick="submitOneFeed()"/>
                                    </form>
                                </div>
                                <div class="fgline"></div>
                                <div class="Intothbox">
                                    <div class="QQ">
                                        <img src="${basepath}/static/website/img/qq.png"/>
                                        <p class="qqnum">2975 463 389</p>
                                    </div>
                                    <div class="phone">
                                        <img src="${basepath}/static/website/img/contect-phone.png"/>
                                        <p class="telnum">4006-081-080</p>
                                    </div>
                                    <div class="wxqrcode">
                                        <img src="${basepath}/static/website/img/QRcode.png"/>
                                        <p>添加微信客服：小舟</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
    });
</script>
</body>

</html>