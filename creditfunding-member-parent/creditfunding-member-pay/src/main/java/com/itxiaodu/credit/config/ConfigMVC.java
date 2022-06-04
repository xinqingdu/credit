package com.itxiaodu.credit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigMVC implements WebMvcConfigurer {
    ConfigMVC() {

    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器访问地址
        String pathHead="";
        registry.addViewController("/generate/order").setViewName("pay-step-3");

    }
}
