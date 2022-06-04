package com.itxiaodu.credit;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaClient
//@EnableAutoConfiguration
//@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.itxiaodu.credit.mapper")
@SpringBootApplication
public class CreditMysqlMain {
    CreditMysqlMain() {

    }

    public static void main(String[] args) {
        SpringApplication.run(CreditMysqlMain.class,args);

    }
}
