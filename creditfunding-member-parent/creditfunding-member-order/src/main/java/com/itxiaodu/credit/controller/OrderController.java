package com.itxiaodu.credit.controller;

import com.itxiaodu.credit.api.MysqlService;
import com.itxiaodu.credit.entity.vo.CreditAddressVO;
import com.itxiaodu.credit.entity.vo.CreditOrderProjectVO;
import com.itxiaodu.credit.entity.vo.MemberLoginvo;
import com.itxiaodu.credit.entity.vo.Membervo;
import com.itxiaodu.credit.utils.CreditConstant;
import com.itxiaodu.credit.utils.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private MysqlService mysqlService;

    @RequestMapping("/confirm/return/info/{projectId}/{returnId}")
    public String getOrderConfirmReturnInfo(@PathVariable("projectId") Integer projectId, @PathVariable("returnId") Integer returnId, ModelMap modelMap, HttpSession session) {
        ResultType<CreditOrderProjectVO> orderProjectVOResultType = mysqlService.getCreditOrderProjectVORemote(projectId, returnId);
        if (orderProjectVOResultType.isSuccess()) {
            CreditOrderProjectVO data = orderProjectVOResultType.getData();
            if (data.getFreight() == null) data.setFreight(0);
            session.setAttribute(CreditConstant.CONST_CREDIT_ORDER_PROJECT_DATA, data);
            modelMap.addAttribute(CreditConstant.CONST_CREDIT_ORDER_PROJECT_DATA, data);
        }
        return "redirect:http://localhost:81/order/to/confirm/return";
    }

    @RequestMapping("/confirm/order/{returnCount}")
    public String getConfirmOrderInfo(@PathVariable("returnCount") Integer returnCount, HttpSession session) {
        CreditOrderProjectVO orderProjectVO = (CreditOrderProjectVO) session.getAttribute(CreditConstant.CONST_CREDIT_ORDER_PROJECT_DATA);
        orderProjectVO.setReturnCount(returnCount);
        session.setAttribute(CreditConstant.CONST_CREDIT_ORDER_PROJECT_DATA, orderProjectVO);
        MemberLoginvo membervo = (MemberLoginvo) session.getAttribute(CreditConstant.CONST_LOGIN_MEMBER);
        Integer membervoId = membervo.getId();
        ResultType<List<CreditAddressVO>> creditAddressVOResultType = mysqlService.getCreditAddressVORemote(membervoId);
        if (creditAddressVOResultType.isSuccess()) {
            List<CreditAddressVO> data = creditAddressVOResultType.getData();
            session.setAttribute("addressVOList", data);
        }
        return "redirect:http://localhost:81/order/to/confirm/order";
    }

    @RequestMapping("/save/address")
    public String saveAddress(CreditAddressVO creditAddressVO, HttpSession session) {
        ResultType<String> resultType = mysqlService.saveCreditAddressVORemote(creditAddressVO);
        CreditOrderProjectVO creditOrderProjectVO = (CreditOrderProjectVO) session.getAttribute(CreditConstant.CONST_CREDIT_ORDER_PROJECT_DATA);
        Integer returnCount = creditOrderProjectVO.getReturnCount();
        return "redirect:http://localhost:81/order/confirm/order/" + returnCount ;
    }
}
