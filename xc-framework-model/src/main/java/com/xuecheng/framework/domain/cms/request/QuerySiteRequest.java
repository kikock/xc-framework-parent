package com.xuecheng.framework.domain.cms.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @project_name: xc-framework-model
 * @description: 站点请求参数
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class QuerySiteRequest {
    //接收页面查询的查询条件
    //站点ID
    @ApiModelProperty("站点id")
    private String siteId;
    //站点名称
    @ApiModelProperty("站点名称")
    private String siteName;
    //站点域名
    @ApiModelProperty("站点域名")
    private String siteDomain;
    //站点端口
    @ApiModelProperty("站点端口")
    private String sitePort;
    //站点访问地址
    @ApiModelProperty("站点访问地址")
    private String siteWebPath;
    //创建时间
    @ApiModelProperty("创建时间")
    private Date siteCreateTime;
    //站点物理路径(发布页面路径)
    @ApiModelProperty("站点物理路径(发布页面路径)")
    private String sitePhysicalPath;

    //服务器IP
    @ApiModelProperty("服务器IP")
    private String ip;
    //端口
    @ApiModelProperty("端口")
    private String port;
    //访问地址
    @ApiModelProperty("访问地址")
    private String webPath;
    //服务器名称（代理、静态、动态、CDN）
    @ApiModelProperty("服务器名称（代理、静态、动态、CDN）")
    private String serverName;
    //资源发布地址（完整的HTTP接口）
    @ApiModelProperty("资源发布地址（完整的HTTP接口）")
    private String uploadPath;
    //使用类型（测试、生产）
    @ApiModelProperty("使用类型（测试、生产、开发）")
    private String useType;


    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteDomain() {
        return siteDomain;
    }

    public void setSiteDomain(String siteDomain) {
        this.siteDomain = siteDomain;
    }

    public String getSitePort() {
        return sitePort;
    }

    public void setSitePort(String sitePort) {
        this.sitePort = sitePort;
    }

    public String getSiteWebPath() {
        return siteWebPath;
    }

    public void setSiteWebPath(String siteWebPath) {
        this.siteWebPath = siteWebPath;
    }

    public Date getSiteCreateTime() {
        return siteCreateTime;
    }

    public void setSiteCreateTime(Date siteCreateTime) {
        this.siteCreateTime = siteCreateTime;
    }

    public String getSitePhysicalPath() {
        return sitePhysicalPath;
    }

    public void setSitePhysicalPath(String sitePhysicalPath) {
        this.sitePhysicalPath = sitePhysicalPath;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getWebPath() {
        return webPath;
    }

    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    @Override
    public String toString() {
        return "QuerySiteRequest{" +
                "siteId='" + siteId + '\'' +
                ", siteName='" + siteName + '\'' +
                ", siteDomain='" + siteDomain + '\'' +
                ", sitePort='" + sitePort + '\'' +
                ", siteWebPath='" + siteWebPath + '\'' +
                ", siteCreateTime=" + siteCreateTime +
                ", sitePhysicalPath='" + sitePhysicalPath + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", webPath='" + webPath + '\'' +
                ", serverName='" + serverName + '\'' +
                ", uploadPath='" + uploadPath + '\'' +
                ", useType='" + useType + '\'' +
                '}';
    }
}
