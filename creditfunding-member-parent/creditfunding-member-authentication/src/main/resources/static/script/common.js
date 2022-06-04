function sendAjax(url,data,contentType,success,fail){
    var resultAjax= $.ajax(
        {
            "url":url,
            "type":"POST",
            "data":data,
            "contentType":contentType,
            "dataType":"json",
            "async":false,
            "success": function(response){
                success(response);
            },
            "error":function(response){
                fail(response);
            }
        }
    );
    return resultAjax;
}
function sendResult(response) {
    var result = response.success;
    if (result == "SUCCESS"){
        layer.msg("发送成功");
    }
    if (result == "FAILED"){
        layer.msg("发送失败！请再试一次！");
    }
}
function nullFuction(response){

}
function sendFailed(response) {
    layer.msg(response.status + " " + response.statusText);
}