package com.xuecheng.framework.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @project_name: xc-framework-parent
 * @description: 初始配置类
 * @create_name: kikock
 * @create_date: 2021-01-19 13:51
 **/
@Configuration
public class ApplicationConfig {


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
