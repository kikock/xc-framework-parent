package com.xuecheng.framework.domain.cms;

import java.util.Map;

/**
 * Created by admin on 2018/2/6.
 */
public class CmsConfigModel {
    private String key;//主键
    private String name;//项目名称
    private String url;//项目url
    private Map mapValue;//项目复杂值
    private String value;//项目简单值

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
