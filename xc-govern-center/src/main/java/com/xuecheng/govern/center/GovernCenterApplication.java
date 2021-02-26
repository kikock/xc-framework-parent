package com.xuecheng.govern.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @project_name: xc-govern-center
 * @description: Eureka服务端
 * @create_name: kikock
 * @create_date: 2021-02-25 15:16
 **/
@EnableEurekaServer//标识这是一个Eureka服务
@SpringBootApplication
public class GovernCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(GovernCenterApplication.class, args);
        System.out.println("xc-govern-center模块启动成功.......");
    }
}
