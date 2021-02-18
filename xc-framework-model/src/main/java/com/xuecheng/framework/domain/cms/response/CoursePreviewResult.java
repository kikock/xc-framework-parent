package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * @project_name: xc-framework-model
 * @description: 课程预览响应信息
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class CoursePreviewResult extends ResponseResult {
    String url;

    public CoursePreviewResult(ResultCode resultCode, String url) {
        super(resultCode);
        this.url = url;
    }

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
