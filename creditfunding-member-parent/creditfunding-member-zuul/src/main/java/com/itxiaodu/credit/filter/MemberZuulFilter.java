package com.itxiaodu.credit.filter;

//import com.itxiaodu.credit.entity.vo.MemberLoginvo;
import com.itxiaodu.credit.utils.CreditConstant;
import com.itxiaodu.credit.utils.PassWebs;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class MemberZuulFilter extends ZuulFilter {
    MemberZuulFilter() {

    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String servletPath = request.getServletPath();
        if (PassWebs.PASS_SET.contains(servletPath)){
            return false;
        }
        return !PassWebs.isStaticResource(servletPath);
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(CreditConstant.CONST_LOGIN_MEMBER);
//        System.out.println(session.getId());
//        System.out.println(attribute);
        if (attribute==null){
            HttpServletResponse response = currentContext.getResponse();
            session.setAttribute(CreditConstant.CONST_NAME_MESSAGE,CreditConstant.CONST_AUTH_EXCEPTION);
            try {
                response.sendRedirect("/auth/member/to/login/page");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
