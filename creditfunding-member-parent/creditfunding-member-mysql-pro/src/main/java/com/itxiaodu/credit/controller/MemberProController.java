package com.itxiaodu.credit.controller;

import com.itxiaodu.credit.utils.CreditConstant;
import com.itxiaodu.credit.utils.ResultType;
import com.itxiaodu.credit.entity.po.Memberpo;
import com.itxiaodu.credit.service.api.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberProController{
    MemberProController() {

    }

    @Autowired
    private MemberService memberService;

    @RequestMapping("/get/memberpo/by/login/account/remote")
    ResultType<Memberpo> getMemberpoByLoginAccountRemote(@RequestParam("loginAccount") String loginAccount) {
        try {
//            System.out.println("-----ok------");
            Memberpo memberpo = memberService.getMemberpoByLoginAccount(loginAccount);
            return ResultType.successWithData(memberpo);
        } catch (Exception e) {
            return ResultType.fail(e.getMessage());
        }
    }

    @RequestMapping("/save/member/remote")
    ResultType<String> saveMember(@RequestBody Memberpo memberpo) {
        if (memberService.isAccountUsed(memberpo.getLoginAccount())) {
            return ResultType.fail(CreditConstant.CONST_MESSAGE_ACCOUNT_IN_USE);
        }
        try {
            memberService.saveMember(memberpo);
            return ResultType.successWithoutData();
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                return ResultType.fail(CreditConstant.CONST_MESSAGE_ACCOUNT_IN_USE);
            }
            return ResultType.fail(e.getMessage());
        }

    }
    @RequestMapping("/account/use/remote")
    ResultType<String> isAccountUsed(@RequestParam("loginAccount") String loginAccount){
        boolean accountUsed = memberService.isAccountUsed(loginAccount);
        if (accountUsed) return ResultType.fail(CreditConstant.CONST_MESSAGE_ACCOUNT_IN_USE);
        return ResultType.successWithoutData();
    }
}
