package com.xuecheng.framework.domain.cms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 模板管理
 */

@Document(collection = "cms_config")
public class CmsConfig {

    @Id
    private String id;//主键
    private String name;//数据模型的名称
    private List<CmsConfigModel> model;//数据模型项目

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CmsConfigModel> getModel() {
        return model;
    }

    public void setModel(List<CmsConfigModel> model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "CmsConfig{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", model=" + model +
                '}';
    }
}
