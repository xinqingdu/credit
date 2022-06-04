<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp" %>
<script src="jquery/jquery-2.1.1.min.js"></script>
<script src="layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
        $("#toRightBtn").click(function(){
            layer.msg("添加");
            // select 是标签选择器
            // :eq(0)表示选择页面上的第一个
            // :eq(1)表示选择页面上的第二个
            // “>”表示选择子元素
            // :selected 表示选择“被选中的”option
            // appendTo()能够将 jQuery 对象追加到指定的位置
             $("select:eq(0)>option:selected").appendTo("select:eq(1)");
        });
        $("#toLeftBtn").click(function(){
            $("select:eq(1)>option:selected").appendTo("select:eq(0)");
            layer.msg("移除");
        });
        $("#submitBtn").click(function(){
            $("select:eq(1)>option").prop("selected","selected");
        });
    });
</script>
<script>
</script>
<body>

<%@include file="/WEB-INF/include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="/WEB-INF/include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <ol class="breadcrumb">
                <li><a href="security/to/login/page.html">首页</a></li>
                <li><a href="admin/get/page.html">数据列表</a></li>
                <li class="active">分配角色</li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form action="assign/do/role/assign.html" type="post" role="form" class="form-inline">
                        <input type="hidden" name="adminId" value="${param.adminId }">
                        <input type="hidden" name="pageNum" value="${param.pageNum }">
                        <input type="hidden" name="keyword" value="${param.keyword }">

                        <div class="form-group">
                            <%--@declare id="exampleinputpassword1"--%><label for="exampleInputPassword1">未分配角色列表</label><br>
                            <select class="form-control" multiple="multiple" size="10" style="width:100px;overflow-y:auto;">
                                <c:forEach items="${requestScope.unassignedRoleList }" var="role">
                                    <option value="${role.id }">${role.name }</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <ul>
                                <li id="toRightBtn" class="btn btn-default glyphicon glyphicon-chevron-right"></li>
                                <br>
                                <li id="toLeftBtn" class="btn btn-default glyphicon glyphicon-chevron-left" style="margin-top:20px;"></li>
                            </ul>
                        </div>
                        <div class="form-group" style="margin-left:40px;">
                            <label for="exampleInputPassword1">已分配角色列表</label><br>
                            <select name="roleIdList" class="form-control" multiple="multiple" size="10" style="width:100px;overflow-y:auto;">
                                <c:forEach items="${requestScope.assignedRoleList }" var="role">
                                    <option value="${role.id }">${role.name }</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <button id="submitBtn" type="submit" style="width: 80px;float:left;margin-left:50px;margin-top:10px" class="btn btn-sm btn-success btn-block">保存</button>
                            <button type="button" onclick="back()" style="width: 80px;float:left;margin-left:70px;margin-top:10px" class="btn btn-sm btn-success btn-block">返回</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

