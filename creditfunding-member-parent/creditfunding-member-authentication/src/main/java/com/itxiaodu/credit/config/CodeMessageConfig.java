package com.itxiaodu.credit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "code.message")
public class CodeMessageConfig {
    public CodeMessageConfig() {

    }

    private String host;
    private String path;
    private String method;
    private String time;
    private String appCode;
    private String sign;
    private String skin;

    public CodeMessageConfig(String host, String path, String method, String time, String appCode, String sign, String skin) {
        this.host = host;
        this.path = path;
        this.method = method;
        this.time = time;
        this.appCode = appCode;
        this.sign = sign;
        this.skin = skin;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public String getTime() {
        return time;
    }

    public String getAppCode() {
        return appCode;
    }

    public String getSign() {
        return sign;
    }

    public String getSkin() {
        return skin;
    }

    @Override
    public String toString() {
        return "CodeMessageConfig{" +
            "host='" + host + '\'' +
            ", path='" + path + '\'' +
            ", method='" + method + '\'' +
            ", time='" + time + '\'' +
            ", appCode='" + appCode + '\'' +
            ", sign='" + sign + '\'' +
            ", skin='" + skin + '\'' +
            '}';
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }
}
