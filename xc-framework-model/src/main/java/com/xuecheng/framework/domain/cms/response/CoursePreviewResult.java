package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * Created by admin on 2018/3/5.
 */

public class CoursePreviewResult extends ResponseResult {
    public CoursePreviewResult(ResultCode resultCode, String url) {
        super(resultCode);
        this.url = url;
    }

    String url;

    public CoursePreviewResult(ResultCode resultCode) {
        super(resultCode);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CoursePreviewResult{" +
                "url='" + url + '\'' +
                '}';
    }
}
