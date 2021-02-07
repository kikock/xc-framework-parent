package com.xuecheng.framework.domain.cms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @project_name: xc-framework-model
 * @description: 站点模板实体类
 * @create_name: kikock
 * @create_date: 2021/1/1 11:09
 */
@Document(collection = "cms_template")
public class CmsTemplate {

    //站点ID
    private String siteId;
    //模版ID
    @Id
    private String templateId;
    //模版名称
    private String templateName;
    //模版参数
    private String templateParameter;
    //模版文件Id
    private String templateFileId;

    @Override
    public String toString() {
        return "CmsTemplate{" +
                "siteId='" + siteId + '\'' +
                ", templateId='" + templateId + '\'' +
                ", templateName='" + templateName + '\'' +
                ", templateParameter='" + templateParameter + '\'' +
                ", templateFileId='" + templateFileId + '\'' +
                '}';
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateParameter() {
        return templateParameter;
    }

    public void setTemplateParameter(String templateParameter) {
        this.templateParameter = templateParameter;
    }

    public String getTemplateFileId() {
        return templateFileId;
    }

    public void setTemplateFileId(String templateFileId) {
        this.templateFileId = templateFileId;
    }
}
