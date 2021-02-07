package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * @project_name: xc-framework-model
 * @description: 静态化html页面响应信息
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public class GenerateHtmlResult extends ResponseResult {
    String html;

    public GenerateHtmlResult(ResultCode resultCode, String html) {
        super(resultCode);
        this.html = html;
    }

    public GenerateHtmlResult() {
    }

    @Override
    public String toString() {
        return "GenerateHtmlResult{" +
                "html='" + html + '\'' +
                '}';
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
