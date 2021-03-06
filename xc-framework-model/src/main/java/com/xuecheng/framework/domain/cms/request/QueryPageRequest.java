package com.xuecheng.framework.domain.cms.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @project_name: xc-framework-model
 * @description: cms页面请求参数
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class QueryPageRequest {
    //接收页面查询的查询条件
    //站点id
    @ApiModelProperty("站点id")
    private String siteId;
    //页面ID
    @ApiModelProperty("页面ID")
    private String pageId;
    //页面名称
    @ApiModelProperty("页面名称")
    private String pageName;
    //别名
    @ApiModelProperty("别名")
    private String pageAliase;
    //模版id
    @ApiModelProperty("模版id")
    private String templateId;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageAliase() {
        return pageAliase;
    }

    public void setPageAliase(String pageAliase) {
        this.pageAliase = pageAliase;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "QueryPageRequest{" +
                "siteId='" + siteId + '\'' +
                ", pageId='" + pageId + '\'' +
                ", pageName='" + pageName + '\'' +
                ", pageAliase='" + pageAliase + '\'' +
                ", templateId='" + templateId + '\'' +
                '}';
    }
}
