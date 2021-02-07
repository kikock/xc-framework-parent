package com.xuecheng.framework.domain.cms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * @project_name: xc-framework-model
 * @description: 模板管理实体
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
@Document(collection = "cms_config")
public class CmsConfig {
    //主键
    @Id
    private String id;
    //数据模板的名称
    private String name;
    //数据模板Ext扩展信息
    private List<CmsConfigModel> model;

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
