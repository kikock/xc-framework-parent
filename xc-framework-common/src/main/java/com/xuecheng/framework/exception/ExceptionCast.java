package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project_name: xc-framework-common
 * @description: 异常抛出方法
 * @create_name: kikock
 * @create_date: 2021-01-13 16:30
 **/
public class ExceptionCast {
    private static final Logger log = LoggerFactory.getLogger(ExceptionCast.class);

    //使用此静态方法抛出自定义异常
    public static void cast(ResultCode resultCode) {
        log.error("抛出自定义异常: {}", resultCode.toString());
        throw new CustomException(resultCode);
    }
}
