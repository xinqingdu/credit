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
public class CreditOrderMain {
    public CreditOrderMain() {

    }

    public static void main(String[] args) {
        SpringApplication.run(CreditOrderMain.class, args);
    }
}

