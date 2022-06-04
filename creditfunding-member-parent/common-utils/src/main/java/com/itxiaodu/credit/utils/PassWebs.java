package com.itxiaodu.credit.utils;

import java.util.HashSet;
import java.util.Set;

public class PassWebs {
    PassWebs() {

    }
    public static final Set<String> PASS_SET=new HashSet<>();
    static {
        PASS_SET.add("/");
        PASS_SET.add("/auth/member/to/login/page");
        PASS_SET.add("/auth/member/logout");
        PASS_SET.add("/auth/member/to/reg/page");
        PASS_SET.add("/auth/member/do/login");
        PASS_SET.add("/auth/member/do/register");
        PASS_SET.add("/auth/member/send/code/message.json");

    }
    public static final Set<String> STATIC_SET=new HashSet<>();
    static {
        STATIC_SET.add("css");
        STATIC_SET.add("bootstrap");
        STATIC_SET.add("fonts");
        STATIC_SET.add("img");
        STATIC_SET.add("jquery");
        STATIC_SET.add("layer");
        STATIC_SET.add("script");
        STATIC_SET.add("ztree");
//        STATIC_SET.add("");
    }
    public static boolean isStaticResource(String servletPath){
        if (servletPath==null || servletPath.length()==0){
            throw new RuntimeException(CreditConstant.CONST_INVALIDATE);
        }
        String[] split = servletPath.split("/");
        return STATIC_SET.contains(split[1]);
    }
}
