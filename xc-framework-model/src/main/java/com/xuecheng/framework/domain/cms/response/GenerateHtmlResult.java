package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

/**
 * Created by mrt on 2018/3/31.
 */

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
