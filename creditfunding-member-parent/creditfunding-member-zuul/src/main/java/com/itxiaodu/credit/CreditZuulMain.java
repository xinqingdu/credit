package com.itxiaodu.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
//@EnableRedisHttpSession
public class CreditZuulMain {
    CreditZuulMain() {

    }

    public static void main(String[] args) {
        SpringApplication.run(CreditZuulMain.class,args);
    }
}
