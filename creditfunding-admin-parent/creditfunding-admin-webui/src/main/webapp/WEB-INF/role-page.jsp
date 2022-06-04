<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp" %>
<%-- <%@include file="/WEB-INF/modal-role-confirm.jsp" %> --%>
<%-- <%@include file="/WEB-INF/modal-role-assign-auth.jsp" %> --%>
<link rel="stylesheet" href="css/pagination.css"/>
<script type="text/javascript" src="jquery/jquery.pagination.js"></script>
<link rel="stylesheet" href="ztree/zTreeStyle.css"/>
<script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>
<%-- <script src="jquery/jquery-2.1.1.min.js"></script> --%>
<%-- <script src="layer/layer.js"></script> --%>
<%-- <link rel="stylesheet" href="css/pagination.css"/> --%>
<%-- <script type="text/javascript" src="jquery/jquery.pagination.js"></script> --%>
<%-- <script src="bootstrap/js/bootstrap.min.js"></script> --%>
<script src="credit/role.js"></script>
<script src="credit/common.js"></script>


<script type="text/javascript">
    $(function () {
        //调用后面声明的函数，对页码导航条进行初始化操作
        window.pageNum=1;
        window.pageSize=10;
        window.keyword="";
        generatePage();
        // $("#saveRoleBtn").click(save());
        // $("#showModelBtn").click(function(){
        //     $("#addModal").modal("show");
        // });
        $("#rolePageBody").on("click",".checkBtn",function(){
            // var urlGet="assign/get/assigned/roleAuth.json";
            window.roleId=this.id;
            var modal="assignModal";
            showModal(modal);
            fillAuthTree();
            $("#assignBtn").click(function(){
                var urlSave="assign/do/assigned/roleAuth.json";
                var contentType="application/json;charset=UTF-8";
                assignRoleAuth(urlSave,contentType);
                hideModal(modal);
            });
        });
        $("#rolePageBody").on("click",".pencilBtn",function(){
            var modal="editModal";
            showModal(modal);
            var roleName = $(this).parent().prev().text();
            window.roleId = this.id;
            // 使用 roleName 的值设置模态框中的文本框
            $("#"+modal+" [name=roleName]").val(roleName);
            $("#updateRoleBtn").click(function(){
                updateRole(modal);
            });
            // update();
        });
        $("#rolePageBody").on("click",".removeBtn",function(){
            var roleName = $(this).parent().prev().text();
            var roleList=[{
                id:this.id,
                name:roleName
            }];
            var modal="confirmModal";
            var url="role/remove/by/roleId/array.json";
            var roleIdArray = showRoleConfirmModal(modal,roleList);
            $("#removeRoleBtn").click(function(){
                removeRole(modal,url,roleIdArray);
            });
        });
        $("#summaryBox").click(function(){
            var currentStatus=this.checked;
            $(".itemBox").prop("checked",currentStatus);
        });
        $("#rolePageBody").on("click",".itemBox",function(){
            var checkboxedBoxCount=$(".itemBox:checked").length;
            var totalBoxCount=$(".itemBox").length;
            $("#summaryBox").prop("checked",checkboxedBoxCount==totalBoxCount);
        });
    });
</script>
<script>
    
//点击查询按钮进行查询

    // function search(){
    //     // layer.msg("点击了");
    //     window.pageNum=1;
    //     window.pageSize=10;
    //     window.keyword=$("#keyword").val();
    //     generatePage();
        
    // }
    // function update(modal){
    //     // var roleName = $(tag).parent().prev().text();
    //     var url="role/update.json";
    //     var data = ajaxData(modal);
    //     var contentType="application/x-www-form-urlencoded";
    //     updateData(modal,url,data,contentType);
    // }
    // function save(modal){
    //     // var roleName=$.trim($("#"+modal+" [name=roleName]").val());
    //     // window.console.log("roleName: "+roleName);
    //     var url="role/save.json";
    //     window.roleId=null;
    //     var data = ajaxData(modal);
    //     console.log(data);
    //     var contentType="application/x-www-form-urlencoded";
    //     updateData(modal,url,data,contentType);
    //     $("#"+modal+"[name=roleName]").val("");
    // }
    // function ajaxData(modal){
    //     var roleName=$.trim($("#"+modal+" [name=roleName]").val());
    //     var roleId=window.roleId;
    //     var data={
    //         "id":roleId,
    //         "name":roleName,
    //     };
    //     return data;
    // }
    // function updateData(modal,url,data,contentType){
    //     $.ajax(
    //         {
    //             "url":url,
    //             "type":"post",
    //             "data":data,
    //             "contentType":contentType,
    //             "dataType":"json",
    //             "success": function(response){
    //                var result = response.result;
    //                 if (result) {
    //                     layer.msg("操作成功!");
    //                 }
    //                 else {
    //                     layer.msg("操作失败！" + response.message)
    //                 }
    //                 // 重新加载分页
    //                 generatePage();
    //             },
    //             "error":function(response){
    //                 layer.confirm("出错了！状态码："+response.status+"  说明："+response.statusText+" 即将回到登录界面！",{btn: ['确定'], title: "提示"},toLogin);
    //                 // layer.msg("出错了！状态码："+response.status+"  说明："+response.statusText);
    //             }
    //         }
    //     );
    //     $("#"+modal).modal("hide");
    // }
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
                                <form  class="form-inline" role="form" style="float:left;">
                                    <div class="form-group has-feedback">
                                        <div class="input-group">
                                            <div class="input-group-addon">查询条件</div>
                                            <input id="keyword" class="form-control has-success" type="text"
                                                   placeholder="请输入查询条件">
                                        </div>
                                    </div>
                                    <button id="searchBtn" type="button" onclick="search()" class="btn btn-warning"><i
                                            class="glyphicon glyphicon-search"></i> 查询
                                    </button>
                                </form>
                                <button id="batchRemoveBtn" type="button" onclick="batchRemoveRole()" class="btn btn-danger"
                                        style="float:right;margin-left:10px;"><i
                                        class=" glyphicon glyphicon-remove"></i> 删除
                                </button>
                                <button id="showModelBtn"  type="button" onclick="showModal('addModal')" class="btn btn-primary" style="float:right;"><i
                                        class="glyphicon glyphicon-plus"></i> 新增
                                </button>
                                <br>
                                <hr style="clear:both;">
                                <div class="table-responsive">
                                    <table class="table  table-bordered">
                                        <thead>
                                        <tr>
                                            <th width="30">#</th>
                                            <th width="30"><input id="summaryBox" type="checkbox"></th>
                                            <th>id</th>
                                            <th>名称</th>
                                            <th width="100">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody id="rolePageBody">

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
<%@include file="/WEB-INF/modal-role-add.jsp" %>
<%@include file="/WEB-INF/modal-role-edit.jsp" %>
<%@include file="/WEB-INF/modal-role-confirm.jsp" %>
<%@include file="/WEB-INF/modal-assign-role-auth.jsp" %>
</html>