package com.itxiaodu.credit.controller;

import com.itxiaodu.credit.entity.vo.CreditAddressVO;
import com.itxiaodu.credit.entity.vo.CreditOrderProjectVO;
import com.itxiaodu.credit.service.api.OrderService;
import com.itxiaodu.credit.utils.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderProController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/get/credit/order/project/vo/remote")
    ResultType<CreditOrderProjectVO> getCreditOrderProjectVORemote(@RequestParam("projectId") Integer projectId, @RequestParam("returnId") Integer returnId) {
        try {
            CreditOrderProjectVO creditOrderProjectVO = orderService.getCreditOrderProjectVO(projectId, returnId);
            return ResultType.successWithData(creditOrderProjectVO);
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.fail(e.getMessage());
        }
    }
    @RequestMapping("/get/credit/address/vo/remote")
    ResultType<List<CreditAddressVO>> getCreditAddressVORemote(@RequestParam("memberId") Integer memberId){
        try{
            List<CreditAddressVO> creditAddressVOList= orderService.getCreditAddressVO(memberId);
            return ResultType.successWithData(creditAddressVOList);
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.fail(e.getMessage());
        }
    }
    @RequestMapping("/save/credit/address/vo/remote")
    ResultType<String> saveCreditAddressVORemote(@RequestBody CreditAddressVO creditAddressVO){
        try {
            orderService.saveCreditAddressVO(creditAddressVO);
            return ResultType.successWithoutData();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.fail(e.getMessage());
        }
    }
}
