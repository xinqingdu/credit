package com.itxiaodu.credit.mvc.config;
import com.google.gson.Gson;
import com.itxiaodu.credit.constant.CreditConstant;
import com.itxiaodu.credit.exception.AccessFobiddenException;
import com.itxiaodu.credit.exception.AccountExistException;
import com.itxiaodu.credit.exception.DeleteException;
import com.itxiaodu.credit.exception.LoginFailedException;
import com.itxiaodu.credit.util.JudgeUtil;
import com.itxiaodu.credit.util.ResultType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CreditExceptionResolver {
    CreditExceptionResolver() {

    }
    private ModelAndView commonResolveException(Exception exception, HttpServletRequest request, HttpServletResponse response, String viewName) throws IOException {
        if (JudgeUtil.judgeRequestType(request)){
            //如果是ajax请求异常，正常处理
            ResultType<Object> fail = ResultType.fail(exception.getMessage());
            //将返回信息转换为json数据
            Gson gson=new Gson();
            String s = gson.toJson(fail);
            //将json数据传回浏览器
            response.getWriter().write(s);
            return null;
        }
        //如果不是ajax请求异常，则建立新视图，返回空指针异常
        ModelAndView modelAndView = new ModelAndView();
        //将Exception存入模型
        modelAndView.addObject(CreditConstant.CONST_EXCEPTION,exception);
        //异常返回页面
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
    //空指针异常映射关联
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointException(NullPointerException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName=CreditConstant.CONST_NULL_EXCEPTION;
        return commonResolveException(exception,request,response,viewName);
    }
    //数学异常
    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView resolveMathException(ArithmeticException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName= "system-error";
        return commonResolveException(exception,request,response,viewName);
    }
    //登录状态异常
    @ExceptionHandler(value = LoginFailedException.class)
    public ModelAndView loginException(LoginFailedException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName= "admin-login";
        return commonResolveException(exception,request,response,viewName);
    }
    //账户名被使用
    @ExceptionHandler(value = AccountExistException.class)
    public ModelAndView accountExistException(AccountExistException exception,HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName= "system-error";
        return commonResolveException(exception,request,response,viewName);
    }
    //不能删除自己
    @ExceptionHandler(value = DeleteException.class)
    public ModelAndView deleteException(DeleteException exception,HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName= "admin-page";
        return commonResolveException(exception,request,response,viewName);
    }
    //没有权限
    @ExceptionHandler(value = AccessFobiddenException.class)
    public ModelAndView NoAuthException(AccessFobiddenException exception,HttpServletRequest request,HttpServletResponse response) throws IOException{
        String vieName="system-error";
        return commonResolveException(exception,request,response,vieName);
    }
}
