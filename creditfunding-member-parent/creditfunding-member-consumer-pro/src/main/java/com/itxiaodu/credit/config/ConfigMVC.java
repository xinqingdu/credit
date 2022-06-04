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
        registry.addViewController("/agree/protocol/page").setViewName("project-agree");
        registry.addViewController(pathHead+"/launch/project/page").setViewName("project-launch");
        registry.addViewController(pathHead+"/return/info/page").setViewName("project-return");
        registry.addViewController(pathHead+"/create/confirm/page").setViewName("project-confirm");
        registry.addViewController(pathHead+"/create/success").setViewName("project-success");
        registry.addViewController(pathHead+"/show/detail").setViewName("project-show-detail");
    }
}
