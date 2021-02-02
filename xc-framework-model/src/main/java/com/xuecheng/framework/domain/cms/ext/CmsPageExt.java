package com.xuecheng.framework.domain.cms.ext;

import com.xuecheng.framework.domain.cms.CmsPage;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 10:04.
 * @Modified By:
 */

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
