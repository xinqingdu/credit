
function generatePage(){
    //分页数据
    var pageInfo=getPageInfoRemote();
    // 填充表格
    fillTableBody(pageInfo);
}

function getPageInfoRemote(){
    var data={
        "pageNum":window.pageNum,
        "pageSize":window.pageSize,
        "keyword":window.keyword
    };
    var url="role/get/page/info.json";
    var contentType="application/x-www-form-urlencoded";
    // var resultAjax = updateData(url,data,contentType,successCommon,failCommon,nullFuc);
    var resultAjax=$.ajax(
        {
            "url":"role/get/page/info.json",
            "type":"post",
            "data":{
                "pageNum":window.pageNum,
                "pageSize":window.pageSize,
                "keyword":window.keyword
            },
            "async":false,
            "dataType":"json",
        }
    );
    // console.log(resultAjax);

    var status=resultAjax.status;
    //响应状态码是否异常
    if(status != 200){
        layer.msg("请求失败！"+status+" 说明："+resultAjax.statusText);
        return null;
    }
    // if(resultAjax.responseJSON!=null){
    //     window.console.log(resultAjax.responseJSON);
    // }else{
    //     console.log("responseJSON=null!!");
    // }
    var resultEntity=resultAjax.responseJSON;
    try{
        var result=resultEntity.result;
    }catch(e){
        // layer.msg("出错了！请重新登陆！");
        // console.log(e.stack);
        // window.location.href="security/to/login/page.html"
        // return null;
        layer.confirm("出错了！即将回到登录界面！",{btn: ['确定'], title: "提示"},toLogin);
        return null;
    }
    // if(result){
    //     window.console.log("result=true");
    //     window.console.log(resultEntity.data)
    // }
    if(!result){
        layer.msg(resultEntity.message);
        return null;
    }
    var pageInfo = resultEntity.data;
    // console.log(pageInfo)
    return pageInfo;
    // fillTableBody(pageInfo);
}
//显示数据
function fillTableBody(pageInfo){
    // 清除tbody中的旧的数据
    $("#rolePageBody").empty();
    // 为了搜索没有结果时不显示页码
    $("#Pagination").empty();
    // console.log(pageInfo)
    // if(pageInfo==null){
    //     window.console.log("pageInfo==null");
    // }
    //pageInfo是否有值
    if(pageInfo==null || pageInfo==undefined || pageInfo.list.length==0){
        $("#rolePageBody").append("<tr><td colspan='6' align='center'>抱歉！没有查询到您要的数据！</td></tr>");
        return;
    } 
    //表显示
    for(var i=0;i<pageInfo.list.length;i++){
        var role=pageInfo.list[i];
        var id=role.id;
        var name=role.name;
        var numberTd="<td>"+(i+1)+"</td>";
        var checkboxTd="<td><input id='"+id+"' class='itemBox' type='checkbox'></td>";
        var roleIdTd="<td>"+id+"</td>";
        var roleNameTd="<td>"+name+"</td>";

        var checkBtn = "<button id='" + id + "' type='button' class='btn btn-success btn-xs checkBtn'><i class=' glyphicon glyphicon-check'></i></button>";
        var pencilBtn = "<button id='" + id + "' type='button' class='btn btn-primary btn-xs pencilBtn'><i class='glyphicon glyphicon-pencil'></i></button>";
        var removeBtn = "<button id='" + id + "' type='button' class='btn btn-danger btn-xs removeBtn'><i class='glyphicon glyphicon-remove'></i></button>";
        var buttonTd = "<td>" + checkBtn + " " + pencilBtn + " " + removeBtn + "</td>";
        var tr = "<tr>" + numberTd + checkboxTd + roleIdTd + roleNameTd + buttonTd + "</tr>";
        $("#rolePageBody").append(tr);
    }
    generateNavigator(pageInfo);
}
// 分页导航条
function generateNavigator(pageInfo){

    var total=pageInfo.total;
    var properties={
        "num_edge_entries": 2,
        "num_display_entries": 3,
        "callback": paginationCallBack,
        "items_per_page":pageInfo.pageSize, //每页显示1项
        "current_page": pageInfo.pageNum - 1 , //当前页数pageIndex从0开始
        "prev_text": "上一页",
        "next_text": "下一页"
    };
    $("#Pagination").pagination(total,properties);

}
function paginationCallBack(pageIndex,jquery){
    window.pageNum=pageIndex+1;
    generatePage();
    return false;
}

function showRoleConfirmModal(modal,roleList){
    showModal(modal);
    // 清除旧数据
    $("#roleNameDiv").empty();
    // 在全局变量范围内创建数组来存放角色id
    // console.log(roleList);
    roleIdArray = [];
    // 遍历roleArray数组
    for (var i = 0; i < roleList.length; i++) {
        var role = roleList[i];
        var name = role.name;
        $("#roleNameDiv").append(name + "<br />");
        var roleId = role.id;
        roleIdArray.push(roleId);
    }
    // console.log(roleIdArray);
    return roleIdArray;
}

function removeRole(modal,url,roleIdArray){
    var data= JSON.stringify(roleIdArray);
    
    var contentType="application/json;charset=UTF-8";
    updateData(url,data,contentType,successCommon,failCommon,generatePage);
    // generatePage();
    hideModal(modal);
}
function search(){
    // layer.msg("点击了");
    window.pageNum=1;
    window.pageSize=10;
    window.keyword=$("#keyword").val();
    generatePage();
}
function updateRole(modal){
    // var roleName = $(tag).parent().prev().text();
    var url="role/update.json";
    var data = ajaxData(modal);
    var contentType="application/x-www-form-urlencoded";
    updateData(url,data,contentType,successCommon,failCommon,generatePage);
    // generatePage();
    hideModal(modal);
}
function saveRole(modal){
    // var roleName=$.trim($("#"+modal+" [name=roleName]").val());
    // window.console.log("roleName: "+roleName);
    var url="role/save.json";
    window.roleId=null;
    var data = ajaxData(modal);
    // console.log(data);
    var contentType="application/x-www-form-urlencoded";
    updateData(url,data,contentType,successCommon,failCommon,generatePage);
    // generatePage();
    hideModal(modal);
    $("#"+modal+" [name=roleName]").val("");
}
function ajaxData(modal){
    var roleName=$.trim($("#"+modal+" [name=roleName]").val());
    var roleId=window.roleId;
    var data={
        "id":roleId,
        "name":roleName,
    };
    return data;
}

function batchRemoveRole(){
    var roleList=[];
    $(".itemBox:checked").each(function(){
        var roleId=this.id;
        // console.log(id);
        var roleName = $(this).parent().next().next().text();
        // console.log(roleName);
        roleList.push({
            id:roleId,
            name:roleName
        });
    });
    if(roleList.length==0) {
        layer.msg("没有删除的选项！");
        return;
    }
    var modal="confirmModal";
    var url="role/remove/by/roleId/array.json";
    var roleIdArray = showRoleConfirmModal(modal,roleList);
    $("#removeRoleBtn").click(function(){
        removeRole(modal,url,roleIdArray);
    });
    // layer.msg("没有删除的选项！");
}
// function successRole(response){
//     var result = response.result;
//     if (result) {
//         layer.msg("操作成功!");
//         generatePage();
//     }
//      else {
//          layer.msg("操作失败！" + response.message)
//      }
//  }

function nullFuc(){

}
function nullWithResponse(response){

}

//权限树形结构
function fillAuthTree(){
    var url="assign/get/all/auth.json";
    var contentType="application/x-www-form-urlencoded";
    // var contentType="application/json;charset=UTF-8";

    // var resultAjax=updateData(url,null,contentType,successWithResponse,failCommon,nullWithResponse);
    var resultAjax=$.ajax({
        "url":url,
        "type":"post",
        "dataType":"json",
        "async":false
    });
    if(resultAjax.status!=200){
        layer.msg("请求失败！"+status+" 说明："+resultAjax.statusText);
        return null;
    }
    // console.log(resultAjax);
    var response=resultAjax.responseJSON;
    // console.log(response);
    showAuthList(response,url);
}

function showAuthList(response){
    //从服务器响应获取数据
    var url="assign/get/assigned/roleAuth.json";
    var authList=response.data;
    // console.log(authList);
    var setting={
        "treeId":"id",
        "data":{
            "simpleData":{
                enable:true,
                idKey:"id",
                pIdKey:"pid",
                rootPid:null
            },
            "key":{
                name:"title"
            }
        },
        //显示勾选框
        "check": {
            enable: true
            
        }
    };
    //显示树形结构
    // $.fn.zTree.init($("#authTreeDemo"), setting, authList);
    $.fn.zTree.init($("#authTreeDemo"), setting, authList);
    //默认展开
    var zTreeObj = $.fn.zTree.getZTreeObj("authTreeDemo");
    zTreeObj.expandAll(true);
    var data={
        "roleId":window.roleId
    };
    // var resultAjax=updateData(url,data,contentType,successWithResponse,failCommon,nullWithResponse);
    var resAjax = $.ajax({
        "url":url,
        "type":"post",
        "data":data,
        "dataType":"json",
        "async":false
    });
    if(resAjax.status!=200){
        layer.msg("请求失败！"+status+" 说明："+resAjax.statusText);
        return null;
    }
    var authIdList=resAjax.responseJSON.data;
    console.log(authIdList);
    //根据数据，勾选节点
    for(var i=0;i<authIdList.length;i++){
        var authId=authIdList[i];
        var treeNode=zTreeObj.getNodeByParam("id",authId);
        var checked=true;
        var checkTypeFlag=false;
        zTreeObj.checkNode(treeNode,checked,checkTypeFlag);
    }
}

function assignRoleAuth(url,contentType){
    var authIdList=[];
    var zTreeObj = $.fn.zTree.getZTreeObj("authTreeDemo");
    var checkedNodes = zTreeObj.getCheckedNodes();
    for(var i=0;i<checkedNodes.length;i++){
        var checkedNode =checkedNodes[i];
        var id = checkedNode.id;
        authIdList.push(id);
    }
    var requestBody={
        "authIdList":authIdList,
        "roleId":[window.roleId]
    };
    var data=JSON.stringify(requestBody);
    updateData(url,data,contentType,successCommon,failCommon,nullFuc);
}