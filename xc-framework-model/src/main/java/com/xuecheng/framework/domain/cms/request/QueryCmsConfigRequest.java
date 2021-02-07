package com.xuecheng.framework.domain.cms.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @project_name: xc-framework-model
 * @description: cms配置请求参数
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class QueryCmsConfigRequest {

    //模板名称
    @ApiModelProperty("模板名称")
    private String name;

    @Override
    public String toString() {
        return "QueryCmsConfigRequest{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
