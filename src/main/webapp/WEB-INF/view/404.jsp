<%--
  Created by IntelliJ IDEA.
  User: Ma-Company
  Date: 2016/5/20
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>404</title>
</head>
<style>
    * {
        padding: 0;
        margin: 0;

    }

    body, html {
        width: 100%;
        height: 100%;
        font-family: "微软雅黑"
    }

    body {
        background: #2B9DD1;
        color: #FFFFFF;
        text-align: center;
        padding-top: 150px;
        box-sizing: border-box;

    }

    .error_code {

        font-size: 180px;

    }

    .back {
        font-size: 20px;
        border: 2px solid #fff;
        border-radius: 50px;
        display: inline-block;
        padding: 7px 33px;
    }

    a, a:hover {
        text-decoration: none;
        color: #fff;

    }

    .error_content {
        margin-top: 40px;
        margin-bottom: 116px;
        font-size: 25px;
    }

</style>
<body>
<div>
    <span class="error_code">404</span>
</div>
<p class="error_content">很抱歉！网页出了些问题！</p>
<div>
    <a href="javascript:history.go(-1)" class="back">回到上一页</a>
</div>
</body>
</html>