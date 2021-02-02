package com.xuecheng.framework.domain.cms.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Administrator
 * @version 1.0
 * @create kikock
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
