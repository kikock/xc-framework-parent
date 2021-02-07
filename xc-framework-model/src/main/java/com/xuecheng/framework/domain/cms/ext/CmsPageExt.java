package com.xuecheng.framework.domain.cms.ext;

import com.xuecheng.framework.domain.cms.CmsPage;

/**
 * @project_name: xc-framework-model
 * @description: cms页面扩展参数
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class CmsPageExt extends CmsPage {
    private String htmlValue;

    public String getHtmlValue() {
        return htmlValue;
    }

    public void setHtmlValue(String htmlValue) {
        this.htmlValue = htmlValue;
    }

    @Override
    public String toString() {
        return "CmsPageExt{" +
                "htmlValue='" + htmlValue + '\'' +
                '}';
    }
}
