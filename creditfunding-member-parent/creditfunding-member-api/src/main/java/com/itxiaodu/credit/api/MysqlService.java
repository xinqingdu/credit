package com.itxiaodu.credit.api;

import com.itxiaodu.credit.entity.vo.*;
import com.itxiaodu.credit.utils.ResultType;
import com.itxiaodu.credit.entity.po.Memberpo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "itxiaodu-credit-mysql")
public interface MysqlService {
    @RequestMapping("/get/memberpo/by/login/account/remote")
    ResultType<Memberpo> getMemberpoByLoginAccountRemote(@RequestParam("loginAccount") String loginAccount);

    @RequestMapping("save/member/remote")
    ResultType<String> saveMember(@RequestBody Memberpo memberpo);

    @RequestMapping("/account/use/remote")
    ResultType<String> isAccountUsed(@RequestParam("loginAccount") String loginAccount);

    @RequestMapping("/save/project/vo/remote")
    ResultType<String> saveProjectVORemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId);

    @RequestMapping("/select/credit/type/vo/remote")
    ResultType<List<CreditTypeVO>> selectCreditTypeVORemote();

    @RequestMapping("/select/detail/project/vo/remote")
    ResultType<DetailProjectVO> selectDetailProjectVORemote(@RequestParam("id") Integer projectId);

    @RequestMapping("/get/credit/order/project/vo/remote")
    ResultType<CreditOrderProjectVO> getCreditOrderProjectVORemote(@RequestParam("projectId") Integer projectId, @RequestParam("returnId") Integer returnId);

    @RequestMapping("/get/credit/address/vo/remote")
    ResultType<List<CreditAddressVO>> getCreditAddressVORemote(@RequestParam("memberId") Integer memberId);
    @RequestMapping("/save/credit/address/vo/remote")
    ResultType<String> saveCreditAddressVORemote(@RequestBody CreditAddressVO creditAddressVO);
    @RequestMapping("/save/credit/vo/remote")
    ResultType<String> saveCreditOrderVORemote(@RequestBody CreditOrderVO creditOrderVO);
}
