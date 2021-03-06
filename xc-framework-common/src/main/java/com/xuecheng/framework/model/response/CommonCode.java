package com.xuecheng.framework.model.response;

/**
 * @project_name: xc-framework-common
 * @description: 响应数据通用返回代码
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
public enum CommonCode implements ResultCode {

    SUCCESS(true, 10000, "操作成功！"),
    FAIL(false, 11111, "操作失败！"),
    INVALID_PARAM(false, 10003, "参数错误"),
    JSONCHECK_ERROR(false, 10004, "json数据校验失败"),
    UNAUTHENTICATED(false, 10001, "此操作需要登陆系统！"),
    UNAUTHORISE(false, 10002, "权限不足，无权操作！"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！");


    // private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private CommonCode(boolean success, int code, String message) {
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
        return "CommonCode{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
