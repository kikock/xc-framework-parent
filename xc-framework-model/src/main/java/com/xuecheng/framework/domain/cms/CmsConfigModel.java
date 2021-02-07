package com.xuecheng.framework.domain.cms;

import java.util.Map;

/**
 * @project_name: xc-framework-model
 * @description: 数据模板Ext扩展信息
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class CmsConfigModel {
    //主键
    private String key;
    //项目名称
    private String name;
    //项目url
    private String url;
    //项目复杂值
    private Map mapValue;
    //项目简单值
    private String value;

    @Override
    public String toString() {
        return "CmsConfigModel{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", mapValue=" + mapValue +
                ", value='" + value + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map getMapValue() {
        return mapValue;
    }

    public void setMapValue(Map mapValue) {
        this.mapValue = mapValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
