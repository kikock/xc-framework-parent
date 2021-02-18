package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @project_name: xc-framework-parent
 * @description: 站点响应状态码
 * @create_name: kikock
 * @create_date: 2021-02-08 10:50
 **/
public enum CmsSiteCode implements ResultCode {
    SITE_ADDSITE_EXISTSNAME(false, 24001, "站点名称已存在！"),
    SITE_ADDSITESERVICE_EXISTSNAME(false, 24002, "站点服务器名称已存在！");
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private CmsSiteCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return "CmsSiteCode{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
