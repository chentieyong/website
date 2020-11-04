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
    <link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/carlist.css"/>
</head>

<body>
<div class="wrapper carlist">
    <
    <jsp:include page="head.jsp"/>

    <div class="proimgbox">
        <img src="${product.largerImage}"/>
    </div>

    <div class="container-fluid carlistcontainer">
        <div class="cartypebox">
            <div class="typelistbox open">
                <c:forEach items="${categoryList}" var="item">
                    <c:if test="${item.name!='智能化系统'}">
                        <ul class="ul">
                            <li>
                                <a>${item.name}</a>
                            </li>
                            <c:forEach items="${item.nodes}" var="nodeItem">
                                <li class="dropdown">
                                    <a href="javascript:void(0)"><img
                                            src="${basepath}/static/website/img/carlist/right.png"
                                        ${nodeItem.id==ccid?"class='rotate90deg'":''}>${nodeItem.name}
                                    </a>
                                    <div class="dropdown_menu" ${nodeItem.id==ccid?"style='display: block'":""}>
                                        <c:forEach items="${nodeItem.goodsList}" var="product">
                                            <a href="productInfo.html?pid=${product.id}&ccid=${nodeItem.id}">${product.name}</a>
                                        </c:forEach>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </c:forEach>
            </div>
            <div class="containbox">
                <div class="proinfobox">
                    <div class="proinfo">
                        <div class="sharebox"><a><img src="${basepath}/static/website/img/shareicon.png"/>
                            <p>一键分享</p></a></div>
                        <div class="proname">
                            <p>${product.name}</p>
                        </div>
                        <div class="pronametype">
                            <p>${product.showName}</p>
                        </div>
                        <hr/>
                        <div class="prodes">
                            <p>${product.description}</p>
                        </div>
                        <c:if test="${!empty product.videoURL}">
                            <div class="provideo">
                                <video src="${product.videoURL}" controls poster="${product.videoImage}"
                                       webkit-playsinline="true" x-webkit-airplay="true"
                                       playsinline="true" x5-video-player-type="h5" x5-video-player-fullscreen="true"
                                       preload="auto" style="object-fit: cover"></video>
                            </div>
                        </c:if>
                    </div>
                    <c:if test="${!empty productItemList}">
                        <div class="profeaturesbox">
                            <div class="profettitle">
                                <p>+ 产品特色</p>
                            </div>
                            <div class="profetinfobox">
                                <c:forEach items="${productItemList}" var="item">
                                    <div class="profetitem">
                                        <div class="profetimg"><img
                                                src="${item.url}"/></div>
                                        <div class="profetdes">
                                            <div class="profetinfotitle">
                                                <p>${item.name}</p>
                                            </div>
                                            <div class="profetinfodes">
                                                <p>${item.description}</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                        </div>
                    </c:if>

                    <c:if test="${!empty productParameterList1}">
                        <div class="profeaturesbox">
                            <div class="profettitle">
                                <p>+ 产品参数</p>
                            </div>
                            <div class="outsideparameterbox">
                                <c:forEach items="${productParameterList1}" var="item" varStatus="count">


                                    <div class="outsideparamitem ${count.index%2==0?'actbg':''}">
                                        <div class="paramnamebox">
                                            <p>${item.name}</p>
                                        </div>
                                        <div class="paramnumbox">
                                            <p>${item.value}</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${!empty productParameterList2}">
                        <div class="profeaturesbox">
                            <div class="profettitle">
                                <p>+ 底盘参数</p>
                            </div>
                            <div class="outsideparameterbox">
                                <c:forEach items="${productParameterList2}" var="item" varStatus="count">
                                    <div class="outsideparamitem ${count.index%2==0?'actbg':''}">
                                        <div class="paramnamebox">
                                            <p>${item.name}</p>
                                        </div>
                                        <div class="paramnumbox">
                                            <p>${item.value}</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>

                        </div>
                    </c:if>

                    <c:if test="${!empty productFileList}">
                        <div class="profiledownloadbox">
                            <div class="profettitle">
                                <p>+ 文档下载</p>
                            </div>
                            <div class="filetablebox">
                                <c:forEach items="${productFileList}" var="item" varStatus="count">
                                    <div class="profileitem ${count.index%2==0?'actbg':''}">
                                        <p>${item.name}</p>
                                        <a href="${item.url}" download="${item.name}" target="_blank"><img
                                                src="${basepath}/static/website/img/downloadicon.png"/> </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty productCaseList}">
                        <div class="usercasebox">
                            <div class="profettitle">
                                <p>+ 客户案例</p>
                            </div>
                            <div class="caseswiperbox">
                                <c:forEach items="${productCaseList}" var="item">
                                    <a><img src="${item.faceImage}"/></a>
                                </c:forEach>
                            </div>
                        </div>
                    </c:if>

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
                                <p class="telnum">4006 081 080</p>
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

    <jsp:include page="foot.jsp"/>

</div>

<a class="contracticon"><img
        src="${basepath}/static/website/img/contracticon.png"/>
    <p>联系我们</p></a>
<img src="${basepath}/static/website/img/backtotop.jpg" class="backtotop"/>
<script type="text/javascript" src="${basepath}/static/website/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/swiper.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/common.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/feed.js"></script>
<script>
    $(function () {
        //二级菜单
        $(".typelistbox .ul li").click(function () {
            $(".typelistbox .ul li").removeClass('in');
            $(this).addClass('in');
            if ($(this).attr('class') == 'dropdown in') {
                $(".typelistbox .ul li a img").addClass('rotate0deg').removeClass('rotate90deg');
                if ($(this).children("div.dropdown_menu").css('display') != 'block') {
                    $(this).children('a').children('img').removeClass('rotate0deg').addClass('rotate90deg');
                }
                $(this).children("div.dropdown_menu").slideToggle();
                $(this).siblings('li').children('.dropdown_menu').slideUp();
            }

        });

        new Swiper('#caseswiper', {
            slidesPerView: 3,
            spaceBetween: 35,
            loop: true,
            centeredSlides: true,
            navigation: {
                nextEl: '.swipertoright',
                prevEl: '.swipertoleft',
            },
        });
    });
</script>
</body>

</html>