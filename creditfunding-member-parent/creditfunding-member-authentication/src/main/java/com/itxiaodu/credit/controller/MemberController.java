package com.itxiaodu.credit.controller;

import com.itxiaodu.credit.api.MysqlService;
import com.itxiaodu.credit.api.RedisService;
import com.itxiaodu.credit.config.CodeMessageConfig;
import com.itxiaodu.credit.entity.po.Memberpo;
import com.itxiaodu.credit.entity.vo.Membervo;
import com.itxiaodu.credit.entity.vo.MemberLoginvo;
import com.itxiaodu.credit.utils.CreditConstant;
import com.itxiaodu.credit.utils.MessageUtil;
import com.itxiaodu.credit.utils.ResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Controller
public class MemberController {
    MemberController() {

    }

    @Autowired
    private CodeMessageConfig codeMessageConfig;
    @Autowired
    private MysqlService mysqlService;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/auth/member/do/register")
    public String register(Membervo membervo, ModelMap modelMap) {
        if (!Objects.equals(membervo.getUserPasswordTemp(), membervo.getUserPassword())) {
            modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, CreditConstant.CONST_PSWD_UNEQUAL);
            return "member-reg";
        }

        String key = membervo.getTelephone();
        ResultType<String> redisValueByKeyRemote = redisService.getRedisValueByKeyRemote(key);
        if (redisValueByKeyRemote.isSuccess()) {
            String redisCode = redisValueByKeyRemote.getData();
            if (redisCode != null && redisCode.equals(membervo.getCode())) {
                redisService.removeRedisKeyRemote(key);
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String userPassword = membervo.getUserPassword();
                String encode = bCryptPasswordEncoder.encode(userPassword);
                membervo.setUserPassword(encode);
                Memberpo memberpo = new Memberpo();
                BeanUtils.copyProperties(membervo, memberpo);
                memberpo.setCreateTime(new Date());
                ResultType<String> resultType = mysqlService.saveMember(memberpo);
                if (resultType.isSuccess()) {
                    return "redirect:http://localhost:81/auth/member/to/login/page";
                } else modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, CreditConstant.CONST_ACCOUNT_EXIST);
            } else modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, CreditConstant.CONST_CODE_ERROR);
        } else modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, redisValueByKeyRemote.getMessage());
        return "member-reg";
    }

    @ResponseBody
    @RequestMapping(value = "/auth/member/send/code/message.json", method = RequestMethod.POST)
    public ResultType<String> sendCodeMessage(@RequestParam("telephone") String phoneNum, @RequestParam("length") Integer length) {
        try {
            String code = MessageUtil.getVerificationCode(length);
            ResultType<String> resultType = MessageUtil.sentCodeMessage(codeMessageConfig.getHost(), codeMessageConfig.getPath(), codeMessageConfig.getMethod(),
                    code, codeMessageConfig.getTime(), phoneNum, codeMessageConfig.getAppCode(), codeMessageConfig.getSign(), codeMessageConfig.getSkin());
            if (resultType.isSuccess()) {
                String data = resultType.getData();
                long time = Long.parseLong(codeMessageConfig.getTime());
                redisService.setRedisKeyValueRemoteWithTimeout(phoneNum, data, time, TimeUnit.MINUTES);
            }
            return ResultType.successWithoutData();
        } catch (Exception e) {
            return ResultType.fail(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/auth/member/account/use.json", method = RequestMethod.POST)
    ResultType<String> isAccountUsed(@RequestParam(value = "loginAccount", required = false) String loginAccount) {
        if (loginAccount == null || loginAccount.equals("")) {
            return ResultType.fail(CreditConstant.CONST_ACCOUNT_NOTNULL);
        }
        return mysqlService.isAccountUsed(loginAccount);
    }

    @RequestMapping("/auth/member/do/login")
    String login(@RequestParam("loginAccount") String loginAccount, @RequestParam("userPassword") String password,
                 ModelMap modelMap, HttpSession httpSession) {
        if (loginAccount == null || password == null) {
            modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, CreditConstant.CONST_ACCOUNT_OR_PSWD_NULL);
            return "member-login";
        }
        ResultType<Memberpo> resultType = mysqlService.getMemberpoByLoginAccountRemote(loginAccount);

//        System.out.println(resultType.getData().toString());

        if (resultType.isSuccess()) {
            Memberpo memberpo = resultType.getData();
            if (memberpo == null) {
                modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, CreditConstant.CONST_MESSAGE_ACCOUNT_NOT_EXSIT);
            } else {
                String userpswdDataBase = memberpo.getUserPassword();
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                boolean matchesResult = bCryptPasswordEncoder.matches(password, userpswdDataBase);
                if (!matchesResult) {
                    modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, CreditConstant.CONST_MESSAGE_LOGIN_FAILED);
                } else {
                    MemberLoginvo memberLoginvo = new MemberLoginvo(memberpo.getId(), memberpo.getUserName(), memberpo.getEmail());
                    httpSession.setAttribute(CreditConstant.CONST_LOGIN_MEMBER, memberLoginvo);
//                    return "member-center";
//                    System.out.println(memberLoginvo.toString());
//                    System.out.println(httpSession.getId());
                    return "redirect:http://localhost:81/auth/member/to/center/page";
                }
            }
        } else {
            modelMap.addAttribute(CreditConstant.CONST_NAME_MESSAGE, resultType.getMessage());
        }
        return "member-login";
    }

    @RequestMapping("/auth/member/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "portal";
    }


}
