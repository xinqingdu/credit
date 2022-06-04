package com.itxiaodu.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableEurekaClient
//@EnableRedisHttpSession
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CreditPayMain {
    public CreditPayMain() {

    }

    public static void main(String[] args) {
        SpringApplication.run(CreditPayMain.class, args);
    }
}


