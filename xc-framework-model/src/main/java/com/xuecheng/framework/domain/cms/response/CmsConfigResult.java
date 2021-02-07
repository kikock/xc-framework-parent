package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;


/**
 * @project_name: xc-framework-model
 * @description: cms模板管理响应信息
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class CmsConfigResult extends ResponseResult {
    CmsConfig cmsConfig;

    public CmsConfigResult(ResultCode resultCode, CmsConfig cmsConfig) {
        super(resultCode);
        this.cmsConfig = cmsConfig;
    }

    @Override
    public String toString() {
        return "CmsConfigResult{" +
                "cmsConfig=" + cmsConfig +
                '}';
    }

    public CmsConfig getCmsConfig() {
        return cmsConfig;
    }

    public void setCmsConfig(CmsConfig cmsConfig) {
        this.cmsConfig = cmsConfig;
    }
}
