package com.itxiaodu.credit.controller;

import com.itxiaodu.credit.api.MysqlService;
import com.itxiaodu.credit.entity.vo.CreditTypeVO;
import com.itxiaodu.credit.utils.CreditConstant;
import com.itxiaodu.credit.utils.MessageUtil;
import com.itxiaodu.credit.utils.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PortalController {
    PortalController() {

    }
    @Autowired
    private MysqlService mysqlService;
    @RequestMapping(value="/")
    public String showPage(ModelMap modelMap){
        ResultType<List<CreditTypeVO>> listResultType = mysqlService.selectCreditTypeVORemote();
        if (listResultType.isSuccess()){
            List<CreditTypeVO> data = listResultType.getData();
            modelMap.addAttribute(CreditConstant.CONST_PORTAL_DATA,data);
        }
        return "portal";
    }
    @RequestMapping(value="/auth/member/to/reg/page")
    public String toRegPage(){
        return "member-reg";
    }
    @RequestMapping(value="/auth/member/to/login/page")
    public String toLoginPage(){
        return "member-login";
    }

}
