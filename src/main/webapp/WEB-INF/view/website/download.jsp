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
                                    <p>售后服务</p>
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
                    <div class="servfiledownloadcontainer">
                        <div class="servsearchbox">
                            <input type="text" class="searchtxt" id="name" value="${name}"/>
                            <button type="button" class="searchbtn" onclick="search()"></button>
                        </div>
                        <%--                        <hr/>--%>
                        <div class="servfiletable">
                            <%--                            <div class="servtabletitel">--%>
                            <%--                                <div class="servtypebox">--%>
                            <%--                                    <!--<p>选择产品类别</p>-->--%>
                            <%--                                    <select>--%>
                            <%--                                        <option value="0">选择产品类别</option>--%>
                            <%--                                        <option value="1">选择产品类别</option>--%>
                            <%--                                        <option value="2">选择产品类别</option>--%>
                            <%--                                        <option value="3">选择产品类别</option>--%>
                            <%--                                    </select>--%>
                            <%--                                </div>--%>
                            <%--                                <div class="servmodelbox">--%>
                            <%--                                    <!--<p>选择产品型号</p>-->--%>
                            <%--                                    <select>--%>
                            <%--                                        <option value="0">选择产品型号</option>--%>
                            <%--                                        <option value="1">选择产品型号</option>--%>
                            <%--                                        <option value="2">选择产品型号</option>--%>
                            <%--                                        <option value="3">选择产品型号</option>--%>
                            <%--                                    </select>--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>
                            <div class="servfilebox">
                                <c:forEach items="${productFileList}" varStatus="count" var="item">
                                    <div class="servfileitem ${count.index%2==0?'filebg':''}">
                                        <div class="servfilename">
                                            <p>${item.name}</p>
                                        </div>
                                        <div class="downloadicon">
                                            <a href="${item.url}" download="${item.name}" target="_blank"><img
                                                    src="${basepath}/static/website/img/downloadicon.png"/> </a>
                                        </div>
                                    </div>
                                </c:forEach>
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

    function search() {
        var name = $("#name").val()
        location.href = basepath + '/download.html?name=' + name
    }
</script>
</body>

</html>