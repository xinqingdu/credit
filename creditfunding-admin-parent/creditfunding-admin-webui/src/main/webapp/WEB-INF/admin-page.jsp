<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp" %>


<link rel="stylesheet" href="css/pagination.css"/>
<script src="jquery/jquery-2.1.1.min.js"></script>
<script src="layer/layer.js"></script>
<script type="text/javascript" src="jquery/jquery.pagination.js"></script>
<script type="text/javascript">
    $(function () {
        //调用后面声明的函数，对页码导航条进行初始化操作
        initPagination();
        $("#summaryBox").click(function(){
        var currentStatus=this.checked;
        $(".itemBox").prop("checked",currentStatus);
    });
    });
    //生成页码导航条
    function initPagination() {
        // 获取总记录数
        var totalRecoed = ${requestScope.pageInfo.total };
        if(totalRecoed==0) return;
        // 声明一个JSON对象存储Pagination要设置的属性
        var properties = {
            num_edge_entries: 2, //边缘页数
            num_display_entries: 3, //主体页数
            callback: pageSelectCallBack,
            items_per_page:${requestScope.pageInfo.pageSize }, //每页显示1项
            current_page: ${requestScope.pageInfo.pageNum - 1 }, //当前页数pageIndex从0开始
            prev_text: "上一页",
            next_text: "下一页"
        }
        // 生成页码导航条
        $("#Pagination").pagination(totalRecoed, properties);
    }

    // 用户点击“123”这样的页码时调用这个函数实现页面跳转
    function pageSelectCallBack(pageIndex,jQuery) {
        //根据pageIndex计算得到pageNum
        var pageNum = pageIndex + 1;
        //跳转页面
        window.location.href = "admin/get/page.html?pageNum="+pageNum+"&keyword=${param.keyword}";
        //由于每一个页码按钮都是超链接，所以我们要在这里取消超链接的默认行为
        return false;
    }
</script>
<script>
    function deleteJudge(url,admin_id,id){
        layer.confirm("你确定要删除吗？",{btn: ['确定', '取消'], title: "提示"},function(){deleteDo(url,admin_id,id)},deleteUndo);
    }
    function deleteDo(url,admin_id,id){
        if(admin_id!=id){
            window.location.href = url;
            layer.msg("删除成功！");
        }
        else{
            layer.msg("你不能删除你自己！");
        }
    }
    function deleteUndo(){
        layer.msg("已取消！");
    }
</script>

<body>
<%@include file="/WEB-INF/include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="/WEB-INF/include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                            </div>
                            <div class="panel-body">
                                <form action="admin/get/page.html" method="post" class="form-inline" role="form" style="float:left;">
                                    <%-- <p>${requestScope.exception.message }</p> --%>
                                    <div class="form-group has-feedback">
                                        <div class="input-group">
                                            <div class="input-group-addon">查询条件</div>
                                            <input name="keyword" class="form-control has-success" type="text" placeholder="请输入查询条件">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询
                                    </button>
                                </form>
                                <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;">
                                   <i class=" glyphicon glyphicon-remove"></i> 删除 
                                </button>
                                <a style="float: right;" href="admin/to/add/page.html" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> 新增
                                </a>
                                <br>
                                <hr style="clear:both;">
                                <div class="table-responsive">
                                    <table class="table  table-bordered">
                                        <thead>
                                        <tr>
                                            <th width="30">#</th>
                                            <th width="30"><input id="summaryBox" type="checkbox"></th>
                                            <th>账号</th>
                                            <th>名称</th>
                                            <th>邮箱地址</th>
                                            <th width="100">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:if test="${empty requestScope.pageInfo.list }">
                                            <td colspan="6" align="center">抱歉！没有查询到您要的数据！</td>
                                        </c:if>
                                        <c:if test="${!empty requestScope.pageInfo.list }">
                                            <c:forEach items="${requestScope.pageInfo.list }" var="admin" varStatus="myStatus">
                                                <tr>
                                                    <td>${myStatus.count }</td>
                                                    <td><input class="itemBox" type="checkbox"></td>
                                                    <td>${admin.loginAccount }</td>
                                                    <td>${admin.userName }</td>
                                                    <td>${admin.email }</td>
                                                    <td>
                                                        <a href="assign/to/assign/role/page.html?adminId=${admin.id }&pageNum=${requestScope.pageInfo.pageNum }&keyword=${param.keyword }" class="btn btn-success btn-xs"><i class="glyphicon glyphicon-check"></i></a>
                                                        <a href="admin/to/edit/page.html?adminId=${admin.id }&pageNum=${requestScope.pageInfo.pageNum }&keyword=${param.keyword }" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></a>
                                                        <a href="javascript:;" onclick="deleteJudge('admin/remove/${admin.id }/${requestScope.pageInfo.pageNum}/${param.keyword }.html','${admin.id }','${sessionScope.loginAdmin.id}')"  class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></a>
                                                        <%-- <button  onclick="deleteDo('admin/remove/${admin.id }/${requestScope.pageInfo.pageNum}/${param.keyword }.html')"  class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button> --%>
                                                        <%-- <button onclick="deleteUndo()">按下</button> --%>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        </tbody>
                                        <tfoot>
                                        <tr>
                                            <td colspan="6" align="center">
                                                <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
                                            </td>
                                        </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
        </div>
    </div>
</div>
</body>
</html>