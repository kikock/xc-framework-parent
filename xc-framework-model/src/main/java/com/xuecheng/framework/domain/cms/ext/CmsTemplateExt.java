package com.xuecheng.framework.domain.cms.ext;

import com.xuecheng.framework.domain.cms.CmsTemplate;

/**
 * @project_name: xc-framework-model
 * @description: cms模板扩展参数
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class CmsTemplateExt extends CmsTemplate {

    //模版内容
    private String templateValue;

    public String getTemplateValue() {
        return templateValue;
    }

    public void setTemplateValue(String templateValue) {
        this.templateValue = templateValue;
    }

    @Override
    public String toString() {
        return "CmsTemplateExt{" +
                "templateValue='" + templateValue + '\'' +
                '}';
    }
}
