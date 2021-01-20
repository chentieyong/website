<%@include file="/WEB-INF/view/website/taglibs.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="footer">
	<div class="footcontainer">
		<img src="${basepath}/static/website/img/logo-white.png" class="indexfootlogo" />
		<div class="footitembox">

			<c:forEach items="${footNavigatorList}" var="item">
				<div class="footitem">
					<ul>
						<li>
							<a>${item.name}</a>
						</li>
						<c:if test="${item.nodes!=null}">
							<ul>
								<c:forEach items="${item.nodes}" var="nodeItem">
									<li>
										<a>${nodeItem.name}</a>
									</li>
								</c:forEach>
							</ul>
						</c:if>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="copyrightbox">
		<p>Shanghai ShenZhou Vehicle Energy & Environmental Protection Co., Ltd No. 1858 GuangTai Road, Shanghai (201405) 服务热线：4006-081-080 Email: sales@shjdsz.com</p>
		<div>
			<p>Copyright@2020交大神舟 版权所有 | 沪公网安备 31011202002378号 | 沪ICP备13019320号-1</p>
		</div>
	</div>
</div>