package com.itxiaodu.credit.mvc.interceptor;

import com.itxiaodu.credit.constant.CreditConstant;
import com.itxiaodu.credit.entity.Admin;
import com.itxiaodu.credit.exception.AccessFobiddenException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    LoginInterceptor() {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取Session,判断是否有admin对象
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(CreditConstant.CONST_ADMIN_LOGIN);
        if (admin == null) throw new AccessFobiddenException(CreditConstant.CONST_MESSAGE_NO_LOGIN);
        return true;
    }
}
