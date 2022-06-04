<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp" %>
<link rel="stylesheet" href="ztree/zTreeStyle.css"/>
<script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="credit/menu.js"></script>
<script type="text/javascript" src="credit/common.js"></script>

<script type="text/javascript">
    $(function () {
       generateTree();
       var tagHead="treeDemo";
       var tagChild="addBtn";
       $("#"+tagHead).on("click","."+tagChild,function(){
           var url="menu/save.json";
           var modal="menuAddModal";
           var pid=this.id;
           var id=null;
           showModal(modal);
           $("#menuSaveBtn").click(function(){
                operateMenu(modal,url,id,pid);
                $("#menuResetBtn").click();
           });
       });
       $("#treeDemo").on("click",".removeBtn",function(){
           var url="menu/remove.json";
           var modal="menuConfirmModal";
           var id=this.id;
           var contentType="application/x-www-form-urlencoded";
           data={
               "id":id,
           }
           showModal(modal);
           var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");
           var key = "id";
           var value = id;
           var currentNode = zTreeObj.getNodeByParam(key, value);
           $("#removeNodeSpan").html("<i class='"+currentNode.icon+"'></i>"+currentNode.name);
           $("#confirmBtn").click(function(){
               updateData(url,data,contentType,successCommon,failCommon,generateTree);
               hideModal(modal);
           });
       });
       $("#treeDemo").on("click",".editBtn",function(){
            var url="menu/update.json";
            var modal="menuEditModal";
            var id=this.id;
            showModal(modal);

            var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");
            // 根据id属性查询节点对象
            // 用来搜索节点的属性名
            var key = "id";
            // 用来搜索节点的属性值
            var value = id;
            var currentNode = zTreeObj.getNodeByParam(key, value);
            // 回显表单数据
            var pid=currentNode.pid;
            $("#"+modal+" [name=name]").val(currentNode.name);
            $("#"+modal+" [name=url]").val(currentNode.url);
            // 回显 radio 可以这样理解：被选中的 radio 的 value 属性可以组成一个数组，
            // 然后再用这个数组设置回 radio，就能够把对应的值选中
            $("#"+modal+" [name=icon]").val([currentNode.icon]);

            $("#menuEditBtn").click(function(){
                operateMenu(modal,url,id,pid);
            });
       });
    });
</script>
<body>

<%@include file="/WEB-INF/include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="/WEB-INF/include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="panel panel-default">
                <div class="panel-heading"><i class="glyphicon glyphicon-th-list"></i> 权限菜单列表
                    <div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i
                            class="glyphicon glyphicon-question-sign"></i></div>
                </div>
                <div class="panel-body">
                    <ul id="treeDemo" class="ztree">
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/modal-menu-add.jsp" %>
<%@ include file="/WEB-INF/modal-menu-edit.jsp" %>
<%@ include file="/WEB-INF/modal-menu-confirm.jsp" %>
</body>
</html>

