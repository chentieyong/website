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
		<p>上海神舟汽车节能环保股份有限公司 | 上海神舟精宜汽车制造有限公司 | 上海神舟精宜汽车测控技术有限公司</p>
		<p>上海市奉贤区光泰路1858号 服务热线：400 820 9705 Email: sales@shjdsz.com</p>
		<div>
			<p>Copyright@2020交大神舟 版权所有 |
				<a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011202002378" target="_blank" style="color: #FFFFFF">沪公网安备 31011202002378号</a>
				|
				<a href="https://beian.miit.gov.cn" target="_blank" style="color: #FFFFFF">沪ICP备13019320号-1</a></p>
		</div>
	</div>
</div>
