<%--itxiaodu--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <%-- <script src="webjars/jquery/3.6.0/jquery.min.js"></script> --%>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;text-align:center;">信积-以信用筹款 以名誉积金</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form action="security/do/login.html" method="post" class="form-signin" role="form">
        <%-- <p>${SPRING_SECURITY_LAST_EXCEPTION.message }</p> --%>
        <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
        <p>${requestScope.exception.message }</p>
        <h2 style="margin:50px auto 0px auto" class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 管理员登录</h2>
        <div style="margin:30px auto 0px auto" class="form-group has-success has-feedback">
            <input type="text" name="loginAcct" class="form-control" id="inputSuccess3" value="root" placeholder="请输入用户名" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div style="margin:10px auto 10px auto" class="form-group has-success has-feedback">
            <input type="password" name="userPswd" class="form-control" id="inputSuccess4" value="12345678" placeholder="请输入密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <button type="submit" class="btn btn-lg btn-success btn-block">登录</button>
    </form>
</div>

</body>
</html>
