package com.itxiaodu.credit.mvc.controller;
import com.itxiaodu.credit.entity.Admin;
import com.itxiaodu.credit.service.inf.AdminService;
import com.itxiaodu.credit.util.JudgeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControllerTest {
    public ControllerTest() {

    }

    private static Logger logger = LoggerFactory.getLogger(ControllerTest.class);
    @Autowired
    private AdminService adminService;
    //spring, spring mvc and mybatis consist test

    @RequestMapping(value="/test/ssm.html")
    public String ssmTest(ModelMap modelMap, HttpServletRequest request) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        boolean judge = JudgeUtil.judgeRequestType(request);
        logger.info(" judge: "+judge);
        System.out.println(2/0);
        List<Admin> all = adminService.getAll();
        modelMap.addAttribute("all", all);
//        System.out.println(1/0);
        return "target";
    }

    //Ajax,jquery,request and response test
    @RequestMapping(value="/send/string.html")
    public String rrAjaxJqueryTest1(@RequestParam("name") String s) {
        System.out.println(" Ajax字符串测试结果 " + s);
        return "target";
    }

    @ResponseBody
    //requestBody测试
    /*
     a. 前端JS生成数据对象（与java对象一一对应），转换为json字符串，requestBody
        var data;
        var requestBody=JSON.stringify(data);
     b. 通过Ajax发送请求到服务器
        $Ajax{
            "url": "xxx.html",      //请求地址
            "type": "get / post",    //请求方式
            "data": requestBody,   //请求数据
            "success": function (response); 请求成功
            "error": function (response); 请求失败
             }
     c. 服务器通过@requestBody获取json字符串，返回responsBody转换后的json数据
        function(@RequestBody Data data)
     */
    @RequestMapping(value="/send/array.html")
    public String rrAjaxJqueryTest2(@RequestBody List<Integer> list, HttpServletRequest request) {
        boolean judge= JudgeUtil.judgeRequestType(request);
        logger.info(" judge: "+judge);
        for (Integer integer : list) {
            System.out.println(" 数: " + integer);
        }
        return "success";
    }
}
