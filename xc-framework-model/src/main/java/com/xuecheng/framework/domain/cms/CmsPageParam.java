package com.xuecheng.framework.domain.cms;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 10:04.
 * @Modified By:
 */
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
