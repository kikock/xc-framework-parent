package com.xuecheng.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @project_name: xc-service-manage-cms
 * @description: cms配置启动项
 * @create_name: kikock
 * @create_date: 2021-01-19 11:25
 **/
@SpringBootApplication
@EnableDiscoveryClient //表示它是一个Eureka的客户端
@EntityScan("com.xuecheng.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages = {"com.xuecheng.api"})//扫描接口
@ComponentScan(basePackages = {"com.xuecheng.framework"})//扫描common包下的类
@ComponentScan(basePackages = {"com.xuecheng.manage_cms"})//扫描本项目下的所有类
public class ManageCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class, args);
        System.out.println("xc-service-manage-cms模块启动成功.......");
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
