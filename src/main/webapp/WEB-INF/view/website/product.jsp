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
    <jsp:include page="head.jsp"/>

    <div class="container-fluid carlistcontainer">
        <div class="cartypebox">
            <div class="typelistbox open">

                <c:forEach items="${categoryList}" var="item">
                    <ul class="ul">
                        <li>
                            <a>${item.name}</a>
                        </li>
                        <c:forEach items="${item.nodes}" var="nodeItem">
                            <li class="dropdown">
                                <a href="javascript:void(0)"><img
                                        src="${basepath}/static/website/img/carlist/right.png"/>${nodeItem.name}</a>
                                <div class="dropdown_menu">
                                    <c:forEach items="${nodeItem.goodsList}" var="product">
                                        <a href="productInfo.html?pid=${product.id}">${product.name}</a>
                                    </c:forEach>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </c:forEach>
            </div>
            <div class="containbox">
                <div class="containinfobox">
                    <c:forEach items="${categoryList}" var="item">
                        <div class="shizhengbox">
                            <div class="cartitle">
                                <p>${item.name}</p>
                            </div>
                            <div class="carinfobox">
                                <c:forEach items="${item.nodes}" var="nodeItem">
                                    <div class="caritem">
                                        <div class="caritemtile">
                                            <p>${nodeItem.name}</p>
                                        </div>
                                        <div class="caritembox">
                                            <c:forEach items="${nodeItem.goodsList}" var="product">
                                                <a href="productInfo.html?pid=${product.id}" class="carinfop">
                                                    <div class="carinfoitem">
                                                        <img src="${product.littleImage}"/>
                                                        <div class="carnamebox">
                                                            <p>${product.name}</p>
                                                        </div>
                                                    </div>
                                                </a>
                                            </c:forEach>

                                        </div>
                                        <div class="carfgline"></div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="foot.jsp"/>
</div>
<a href="tencent://message/?uin=2975463389&Site=&Menu=yes" class="contracticon"><img
        src="${basepath}/static/website/img/contracticon.png"/>
    <p>联系我们</p></a>
<img src="${basepath}/static/website/img/backtotop.png" class="backtotop"/>
<script type="text/javascript" src="${basepath}/static/website/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/swiper.min.js"></script>
<script type="text/javascript" src="${basepath}/static/website/js/common.js"></script>
<script>
    $(function () {
        //二级菜单
        $(".typelistbox .ul li").click(function () {
            $(".typelistbox .ul li a img").addClass('rotate0deg').removeClass('rotate90deg');
            $(".typelistbox .ul li").children('.dropdown_menu').slideUp();
            $(".typelistbox .ul li").removeClass('in');
            $(this).addClass('in');
            if ($(this).attr('class') == 'dropdown in') {
                $(".typelistbox .ul li a img").addClass('rotate0deg').removeClass('rotate90deg');
                if ($(this).children("div.dropdown_menu").css('display') != 'block') {
                    $(this).children('a').children('img').removeClass('rotate0deg').addClass('rotate90deg');
                    $(this).children("div.dropdown_menu").slideDown();
                }
                $(this).siblings('li').children("div.dropdown_menu").slideUp();
            }
        });
    });
</script>
</body>

</html>