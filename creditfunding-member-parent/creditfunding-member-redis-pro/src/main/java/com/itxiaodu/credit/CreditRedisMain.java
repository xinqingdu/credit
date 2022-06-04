package com.itxiaodu.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class CreditRedisMain {
    CreditRedisMain() {

    }

    public static void main(String[] args) {
        SpringApplication.run(CreditRedisMain.class,args);
    }
}
