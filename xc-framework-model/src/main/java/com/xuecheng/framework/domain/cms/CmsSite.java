package com.xuecheng.framework.domain.cms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 *
 * @project_name: xc-service-manage-cms-client
 * @description: 站点实体类
 * @create_name: kikock
 * @create_date: 2021/1/1 11:09
 *
 */
@Document(collection = "cms_site")
public class CmsSite {

    //站点ID
    @Id
    private String siteId;
    //站点名称
    private String siteName;
    //站点名称
    private String siteDomain;
    //站点端口
    private String sitePort;
    //站点访问地址
    private String siteWebPath;
    //创建时间
    private Date siteCreateTime;
    //站点物理路径(发布页面路径)
    private String sitePhysicalPath;

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

    @Override
    public String toString() {
        return "CmsSite{" +
                "siteId='" + siteId + '\'' +
                ", siteName='" + siteName + '\'' +
                ", siteDomain='" + siteDomain + '\'' +
                ", sitePort='" + sitePort + '\'' +
                ", siteWebPath='" + siteWebPath + '\'' +
                ", siteCreateTime=" + siteCreateTime +
                ", sitePhysicalPath='" + sitePhysicalPath + '\'' +
                '}';
    }
}
