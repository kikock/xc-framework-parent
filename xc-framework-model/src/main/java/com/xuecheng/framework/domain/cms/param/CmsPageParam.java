package com.xuecheng.framework.domain.cms.param;

/**
 * @project_name: xc-framework-model
 * @description: cms页面查询参数实体
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class CmsPageParam {
    //参数名称
    private String pageParamName;
    //参数值
    private String pageParamValue;

    @Override
    public String toString() {
        return "CmsPageParam{" +
                "pageParamName='" + pageParamName + '\'' +
                ", pageParamValue='" + pageParamValue + '\'' +
                '}';
    }

    public String getPageParamName() {
        return pageParamName;
    }

    public void setPageParamName(String pageParamName) {
        this.pageParamName = pageParamName;
    }

    public String getPageParamValue() {
        return pageParamValue;
    }

    public void setPageParamValue(String pageParamValue) {
        this.pageParamValue = pageParamValue;
    }
}
