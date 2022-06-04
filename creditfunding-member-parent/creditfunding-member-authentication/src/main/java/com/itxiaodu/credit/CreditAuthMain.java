package com.itxiaodu.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
//@EnableRedisHttpSession
public class CreditAuthMain {
    CreditAuthMain() {

    }

    public static void main(String[] args) {
        SpringApplication.run(CreditAuthMain.class,args);
    }
}
