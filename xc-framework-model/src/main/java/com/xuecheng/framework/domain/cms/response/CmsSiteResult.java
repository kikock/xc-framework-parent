package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.CmsSiteServer;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * @project_name: xc-framework-parent
 * @description: 站点返回响应信息
 * @create_name: kikock
 * @create_date: 2021-02-08 10:33
 **/
public class CmsSiteResult extends ResponseResult {
    CmsSite cmsSite;
    CmsSiteServer cmsSiteServer;

    public CmsSiteResult(ResultCode resultCode, CmsSite cmsSite, CmsSiteServer cmsSiteServer) {
        super(resultCode);
        this.cmsSite = cmsSite;
        this.cmsSiteServer = cmsSiteServer;
    }

    public CmsSite getCmsSite() {
        return cmsSite;
    }

    public void setCmsSite(CmsSite cmsSite) {
        this.cmsSite = cmsSite;
    }

    public CmsSiteServer getCmsSiteServer() {
        return cmsSiteServer;
    }

    public void setCmsSiteServer(CmsSiteServer cmsSiteServer) {
        this.cmsSiteServer = cmsSiteServer;
    }

    @Override
    public String toString() {
        return "CmsSiteResult{" +
                "cmsSite=" + cmsSite +
                ", cmsSiteServer=" + cmsSiteServer +
                '}';
    }
}
