<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
  <html>
  <!--访问地址http://localhost:8022/creditfunding-admin-webui/test/ssm.html-->
  <base
    href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />
  <%-- <script src="webjars/jquery/3.6.0/jquery.min.js"></script> --%>
   <script src="jquery/jquery-2.1.1.min.js"></script>
   <script src="layer/layer.js"></script>
  <script>
    $(function () {
      $("#button1").click(function () {
        $.ajax({
          "url": "send/string.html",      //请求地址
          "type": "post",    //请求方式
          "data": { "name": "itxiaodu" },   //请求数据
          "dataType": "text",   //请求数据类型
          "success": function (response) {
            alert(response);
          }, //成功返回
          "error": function (response) {
            alert(response);
          }//出错返回
        });
      })
    });
    $(function () {
      $("#button2").click(function () {
        var array=[1,2,3];
        console.log(array.length);
        //json数组转化为字符串
        var requestBody=JSON.stringify(array);
        console.log(requestBody.length);
        $.ajax({
          "url": "send/array.html",      //请求地址
          "type": "post",    //请求方式
          "contentType":"application/json;charset=utf-8",//表示请求体的数据为json数据
          "data": requestBody,   //请求数据
          "dataType": "text",   //请求数据类型
          "success": function (response) {
            alert(response);
          }, //成功返回
          "error": function (response) {
            alert(response);
          }//出错返回
        });
      })
      $("#button3").click(function () {
         layer.msg("OK!");
     });
    });
  </script>

  <head>
    <meta charset="UTF-8">
    <title> Test </title>
  </head>

  <body>
  <div>
    <a style="text-align:center;" href="test/ssm.html">测试SSM整合</a>
    <br />
    <br />
    <button style="margin:30px auto 0px auto" id="button1">Clip body1</button>
    <br />
    <br />
    <button style="margin:30px auto 0px auto" id="button2">Clip body2</button>
     <br />
     <br />
     <button style="width:80px;margin:30px auto 0px auto" id="button3" class="btn btn-md btn-success btn-block">Clip body3</button>
  </div>
  </body>

  </html>