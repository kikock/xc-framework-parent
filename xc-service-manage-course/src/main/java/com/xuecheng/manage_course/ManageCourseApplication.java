package com.xuecheng.manage_course;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @project_name: xc-service-manage-course
 * @description: 课程管理模块
 * @create_name: kikock
 * @create_date: 2021/2/2 16:05
 **/
@SpringBootApplication
@EnableDiscoveryClient //表示它是一个Eureka的客户端
@EntityScan("com.xuecheng.framework.domain.course")//扫描实体类
@ComponentScan(basePackages = {"com.xuecheng.api"})//扫描接口
@ComponentScan(basePackages = {"com.xuecheng.manage_course"})
@ComponentScan(basePackages = {"com.xuecheng.framework"})//扫描common下的所有类
public class ManageCourseApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ManageCourseApplication.class, args);
        System.out.println("xc-service-manage-course模块启动成功.......");
    }
}
