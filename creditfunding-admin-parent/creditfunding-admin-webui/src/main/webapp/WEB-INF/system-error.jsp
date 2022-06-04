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
    <script>
      function back(){
        window.history.back();
      }
      function toLogin(){
        window.location.href = "security/to/login/page.html";
      }
    </script>
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div ><a class="navbar-brand" href="index.html" style="font-size:32px;">信积-以信用筹款 以名誉积金</a></div>
        </div>
    </div>
</nav>

<div class="container">

  <h2 style="margin:50px auto 0px auto; text-align:center;" class="form-signin-heading" ><i class="glyphicon glyphicon-log-in"></i> 系统异常</h2>
  <%-- requestScope.exception.message 与request.getAttribution("exception").getMessage --%>
  <h3 style="text-align:center">${requestScope.exception.message }</h3>
  <button style="width:150px;margin:30px auto 0px auto" onclick="back()" class="btn btn-md btn-success btn-block">返回上一页</button>
  <button style="width:150px;margin:30px auto 30px auto" onclick="toLogin()" class="btn btn-md btn-success btn-block">返回登陆界面</button>
</div>

</body>
</html>
