<%@include file="/WEB-INF/view/website/taglibs.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>${pageNode.name}</title>
		<meta name="keywords" content="${pageNode.metaName}" />
		<meta name="description" content="${pageNode.metaDescription}" />
		<link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/swiper.min.css" />
		<link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/fonts.css" />
		<link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/common.css" />
		<link rel="stylesheet" type="text/css" href="${basepath}/static/website/css/Brandstory.css" />
	</head>

	<body>
		<div class="wrapper brandstory">
			<jsp:include page="head.jsp" />

			<section class="slidebox">
				<div class="swiper-container" id="bannerswiper">
					<div class="swiper-wrapper">
						<c:forEach items="${focusList}" var="item" varStatus="xh">
							<div class="swiper-slide">
								<img src="${item.picturePath}" />
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
			<section class="brandcontainer">
				<div class="daoyanbox">
					<div class="daoyaninfobox">
						<div class="daoyantitile">
							<p>成长故事</p>
						</div>
						<hr/>
						<div class="daoyaninfo">
							<c:forEach items="${allBrandArticleList}" var="item">
								<div class="storylistitem">
									<p><a href="${basepath}/brandInfo.html?artId=${item.id}">${item.title}</a></p>
								</div>
								<hr/>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="brandstoryinfobox">
					<div class="storylistbox">
						<c:forEach items="${brandArticleList}" var="item">
							<div class="branditem">
								<img src="${item.listImage}" />
								<div class="brandtitle">
									<p>${item.title}</p>
								</div>
								<div class="branddes">
									<p>
										${item.description}
									</p>
								</div>
								<div class="brandmoreinfo">
									<a href="brandInfo.html?artId=${item.id}">了解详情 > </a>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="pagesbox">
						<button class="firstpage" type="button" onclick="pageBrand(1)">第一页</button>
						<button class="prevpage" type="button" onclick="pageBrand(${currentPage-1==0?1:currentPage-1})">上一页
                </button>
						<p class="currentPage">${currentPage}</p>
						<button class="nextpage" type="button" onclick="pageBrand(${currentPage==totalPage?currentPage:currentPage+1})">下一页
                </button>
						<button class="endpage" type="button" onclick="pageBrand(${totalPage})">最末页</button>
					</div>
				</div>
			</section>

			<jsp:include page="foot.jsp" />
		</div>

		<a class="contracticon"><img src="${basepath}/static/website/img/contracticon.png" />
			<p>联系我们</p>
		</a>
		<img src="${basepath}/static/website/img/backtotop.jpg" class="backtotop" />
		<script type="text/javascript" src="${basepath}/static/website/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="${basepath}/static/website/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${basepath}/static/website/js/swiper.min.js"></script>
		<script type="text/javascript" src="${basepath}/static/website/js/common.js"></script>
		<script>
			$('.storylistitem').each(function() {
				if($(this).children('p').text().length > 16) {
					$(this).children('p').text($(this).children('p').text().substring(0, 16) + '...');
				}
			})
			//固定左边导航栏
			$(window).scroll(function() {
				var _top = $(window).scrollTop();
				if(_top > ($('.header').height() + $('.slidebox').height())) {
					$('.daoyanbox').css({
						'position': 'fixed',
						'top': '20px'
					});
				} else {
					$('.daoyanbox').css({
						'position': 'absolute',
						'top': '0'
					});
				}

				if(_top > $('.brandstoryinfobox').height()) {
					$('.daoyanbox').css({
						'position': 'absolute',
						'top': '0'
					});
				}
				if($('.daoyanbox').height() > $('body').height()) {
					$('.daoyanbox').css({
						'height': $('body').height(),
						'overflow': 'scroll'
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
			})

			function pageBrand(s) {
				location.href = basepath + '/brand.html?s=' + s
			}

			function toHref(url) {
				location.href = url
			}
		</script>
	</body>

</html>