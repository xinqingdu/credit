package com.itxiaodu.credit.utils;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

import java.util.HashMap;
import java.util.Map;

public class MessageUtil {
    MessageUtil() {

    }

    public static ResultType<String> sentCodeMessage(String host, String path, String method,
                                                     String code, String time, String phoneNumber,
                                                     String appCode, String sign, String skin) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appCode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("content", "code:" + code + ",expire_at:" + time);
        bodys.put("phone_number", phoneNumber);
        bodys.put("template_id", "TPL_0000");
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            String reasonPhrase = statusLine.getReasonPhrase();
            if (statusCode == 200) {
                return ResultType.successWithData(code);
            }
            return ResultType.fail(reasonPhrase);
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            return ResultType.fail(e.getMessage());
        }
    }
//    默认6位
    public static String getVerificationCode(int length) {
        StringBuilder builder = new StringBuilder();
        if (length == 0) length = 6;
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * 10);
            builder.append(random);
        }
        return builder.toString();
    }
}
