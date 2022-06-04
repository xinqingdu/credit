package com.itxiaodu.credit.controller;

import com.itxiaodu.credit.entity.vo.CreditOrderVO;
import com.itxiaodu.credit.service.api.PayService;
import com.itxiaodu.credit.utils.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayProController {
    @Autowired
    private PayService payService;

    @RequestMapping("/save/credit/vo/remote")
    ResultType<String> saveCreditOrderVORemote(@RequestBody CreditOrderVO creditOrderVO) {
        try {
            payService.saveCreditVO(creditOrderVO);
            return ResultType.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultType.fail(e.getMessage());
        }
    }

}
