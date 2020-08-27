<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<c:set var='path' value='kingjsSite'/>
<c:set var="webName" value="首页"/>
<c:set var='SERVER' value='http://${pageContext.request.serverName}:${pageContext.request.serverPort}'/>
<c:set var='basepath' value='${SERVER}${pageContext.request.contextPath}'/>
<c:set var='pasepath' value='${SERVER}${pageContext.request.contextPath}'/>
<c:set var="ctx" value="${basepath}/${path}"/>
<c:set var="baseInclude" value="${base}/${path}"/>
<script>
    var ctx = '${ctx}';
    var path = '${path}';
    var basepath = '${basepath}';
    var pasepath = '${pasepath}';
</script>
