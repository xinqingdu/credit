function toLogin(){
    window.location.href="security/to/login/page.html";
}

function showModal(modal){
    $("#"+modal).modal("show");
} 
function hideModal(modal){
    $("#"+modal).modal("hide");
}
function updateData(url,data,contentType,success,fail,successFuc){
    var resultAjax= $.ajax(
        {
            "url":url,
            "type":"post",
            "data":data,
            "contentType":contentType,
            "dataType":"json",
            "async":false,
            "success": function(response){
                success(response,successFuc);
                console.log(data);
            },
            "error":function(response){
                fail(response);
            }
        }
    );
    return resultAjax;
}
 function failCommon(response){
    layer.confirm("出错了！状态码："+response.status+"  说明："+response.statusText+" 即将回到登录界面！",{btn: ['确定','取消'], title: "提示"},toLogin,null);
}
function successCommon(response,successFuc){
    var result = response.result;
     if (result) {
        successFuc();
        // layer.msg("操作成功!");
     }
     else {
         layer.msg("操作失败！" + response.message);
     }
 }

function successWithResponse(response,fuc){
    var result= response.result;
    if(result){
        // layer.msg("操作成功!");
        fuc(response);
    }else{
        layer.msg("出错了！错误信息："+response.message);
    }
}
