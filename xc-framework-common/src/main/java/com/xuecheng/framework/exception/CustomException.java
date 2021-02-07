package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;


/**
 * @project_name: xc-framework-common
 * @description: 自定义异常(继承自定义异常)
 * @create_name: kikock
 * @create_date: 2021-01-13 16:28
 **/
public class CustomException extends RuntimeException {
    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        //异常信息为错误代码+异常信息
        super("错误代码：" + resultCode.code() + "错误信息：" + resultCode.message());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }
}
