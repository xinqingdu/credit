package com.itxiaodu.credit.mvc.config;

import com.itxiaodu.credit.constant.CreditConstant;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ADHandler implements AccessDeniedHandler {
    ADHandler() {

    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletRequest.setAttribute("exception",new Exception(CreditConstant.CONST_AUTH_EXCEPTION));
    }
}
