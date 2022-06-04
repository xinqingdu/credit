package com.itxiaodu.credit;

import com.itxiaodu.credit.utils.HttpUtils;
import com.itxiaodu.credit.utils.MessageUtil;
import com.itxiaodu.credit.utils.ResultType;
import org.apache.http.HttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageTest {
    public MessageTest() {

    }
    @Test
    public void sentMessage(){
        String host = "xxxx";
        String path = "/data/send_sms";
        String method = "POST";
        String appcode = "xxxx";
        String time="3";
        String phoneNumber="xxxx";
        String code=MessageUtil.getVerificationCode(6);
//        System.out.println(code);
        ResultType<String> resultType=MessageUtil.sentCodeMessage(host,path,method,code,time,phoneNumber,appcode,null,null);
        System.out.println(resultType.getMessage());
    }
}
