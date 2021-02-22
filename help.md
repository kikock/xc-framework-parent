# 黑马 学成在线 cms内容管理

文件结构

        xc-framework-parent(xcGradle)                      父工程，提供依赖管理。
                ├── xc-framework-common              通用工程，提供各层封装
                ├── xc-framework-model               模型工程，提供统一的模型类管理
                ├── xc-framework-utils               工具类工程，提供本项目所使用的工具类  
                ├── xc-service-Api                   接口工程，统一管理本项目的服务接口。
                ├── xc-service-cms                  CMS（Content Management System）即内容管理系统
                ├── xc-service-cms-client           内容管理系统客户端(接收消息发布前端页面)
                ├── xc-service-manage-course         课程管理模块
                ├── xc-service-base-filesystem      文件系统服务工程模块
                ├── build.gradle        -- 全局配置
                ├── settings.gradle     -- 全局配置
                ├── help.md             -- 说明文件      

## Api请求及响应规范

    1、get 请求时，采用key/value格式请求，SpringMVC可采用基本类型的变量接收，也可以采用对象接收。
    2、Post请求时，可以提交form表单数据（application/x-www-form-urlencoded）和Json数据（ContentType=application/json），文件等多部件类型（multipart/form-data）三种数据格式，SpringMVC接收Json数据
    使用@RequestBody注解解析请求的json数据。
    4、响应结果统一信息为：是否成功、操作代码、提示信息及自定义数据。
    5、响应结果统一格式为json

## Swagger集成

    略
    ps: swagger 地址 : http://localhost:????/swagger-ui.html

## 其他信息

@PathVariable("xxx") 注解

通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)

## RabbitMQ消息中间件

    管理地址: http://localhost:15672/   
    初始账号和密码：guest/guest

## 去除SpringBoot项目再启动时打印大量得CONDITIONS EVALUATION REPORT的问题

        yml文件： 
            logging.level.org.springframework.boot.autoconfigure: error
        properties文件：
            logging.level.org.springframework.boot.autoconfigure=ERROR
                

