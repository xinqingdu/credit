package com.itxiaodu.credit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "alibaba.pay")
public class PayConfig {
    private String appId;
    private String merchantPrivateKey;
    private String alipayPublicKey;
    private String notifyUrl;
    private String returnUrl;
    private String signType;
    private String charset;
    private String gatewayUrl;
    private String logPath;
    private String mainUrl;


    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public String getAppId() {
        return appId;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public String getSignType() {
        return signType;
    }

    public String getCharset() {
        return charset;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public String getLogPath() {
        return logPath;
    }
}
