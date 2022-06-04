//ajax获取json数据,通过ztee显示
function generateTree(){
    var url="menu/get/whole/tree.json";
    var contentType="application/x-www-form-urlencoded";
    updateData(url,null,contentType,successWithResponse,failCommon,treeSetting);
}
// function successWithResponse(response,fuc){
//     var result= response.result;
//     if(result){
//         // layer.msg("操作成功!");
//         fuc(response);
//     }else{
//         layer.msg("出错了！错误信息："+response.message);
//     }
// }

function treeSetting(response){
    var setting={
        "view":{
            "addDiyDom": addDiyDom,
            "addHoverDom":addHoverDom,
            "removeHoverDom":removeHoverDom
        },
        "data":{
            "key":{
                "url":"xiaodo"
            }
        }
    };
    var zNodes=response.data;
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
}
//显示图标
function addDiyDom(treeId,treeNode){
    // console.log("treeid:"+treeId);
    // console.log("treeNode:"+treeNode);
    var spanId=treeNode.tId+"_ico";
    $("#"+spanId).removeClass();
    $("#"+spanId).addClass(treeNode.icon);
}
//鼠标移入加入按钮组
function addHoverDom(treeId,treeNode){
    var btnGroudId=treeNode.tId+"_btnGrp";
    var anchorId=treeNode.tId+"_a";
    //附加<span>
    if($("#"+btnGroudId).length>0){
        return;
    }
    var addBtn = "<a id='" + treeNode.id + "' class='addBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px;padding-top:0px;' title='添加子节点'>&nbsp;&nbsp;<i class='fa fa-fw fa-plus rbg '></i></a>";
    var removeBtn = "<a id='" + treeNode.id + "' class='removeBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px;padding-top:0px;' title=' 删 除 节 点 '>&nbsp;&nbsp;<i class='fa fa-fw fa-times rbg '></i></a>";
    var editBtn = "<a id='" + treeNode.id + "' class='editBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px;padding-top:0px;' title=' 修 改 节 点 '>&nbsp;&nbsp;<i class='fa fa-fw fa-edit rbg '></i></a>";
    var level=treeNode.level;
    var btnHtml="";
    //级别分别为0,1,2的权限按钮
    if(level==0){
        btnHtml= addBtn;
    }
    else if(level==1){
        btnHtml= addBtn+" "+editBtn;
        var treeNodeLength=treeNode.children.length;
        if(treeNodeLength==0){
            btnHtml=btnHtml+" "+removeBtn;
        }
    }else{
        btnHtml=editBtn+" "+removeBtn;
    }
    $("#"+anchorId).after("<span id='"+btnGroudId+"'>"+btnHtml+"</span>");
}

//鼠标离开移除按钮组
function removeHoverDom(treeId,treeNode){
    var btnGroudId=treeNode.tId+"_btnGrp";
    // var anchorId=treeNode.tId+"_a";
    //附加<span>
    $("#"+btnGroudId).remove();
}
function operateMenu(modal,url,id,pid){
    // var pid=this.id;
    var nodeName=$.trim($("#"+modal+" [name=name]").val());
    var nodeUrl=$.trim($("#"+modal+" [name=url]").val());
    var nodeIcon=$.trim($("#"+modal+" [name=icon]:checked").val());
    var data={
        "id":id,
        "pid":pid,
        "name":nodeName,
        "icon":nodeIcon,
        "url":nodeUrl
    };
    var contentType="application/x-www-form-urlencoded";
    updateData(url,data,contentType,successCommon,failCommon,generateTree);
    hideModal(modal);
}