package com.itxiaodu.credit.util;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JudgeUtil {
    public JudgeUtil(){

    }
    private static final String ACCEPT = "Accept";
    private static final String REQUESTEDWITH = "X-Requested-With";
    private static final String APPJSON = "application/json";
    private static final String XMLHTTPREQUEST = "XMLHttpRequest";
    private static final String ALGORITHM="md5";
    //采用MD5加密方式,16进制数字
    public static String md5Password(String source) {
        if(source==null || source.length()==0) {
            throw new RuntimeException();
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            byte[] bytes = source.getBytes();
            byte[] digest = messageDigest.digest(bytes);
            int signum=1;
            BigInteger bigInteger = new BigInteger(signum, digest);
            int radix=16;
            return bigInteger.toString(radix).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    //判断请求类型是否为ajax请求
    public static boolean judgeRequestType(HttpServletRequest request) {
        if (request==null) return false;
        String apt = request.getHeader(ACCEPT);
        String reqWith = request.getHeader(REQUESTEDWITH);
        return (reqWith != null && reqWith.equals(XMLHTTPREQUEST)) || (apt != null && apt.contains(APPJSON));
    }
}
