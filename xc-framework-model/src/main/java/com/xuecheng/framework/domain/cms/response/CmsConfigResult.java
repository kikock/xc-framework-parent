package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * 返回CmsPage数据
 * Created by mrt on 2018/3/31.
 */

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
