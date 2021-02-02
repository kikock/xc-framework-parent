package com.xuecheng.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @project_name: xcEduService
 * @description: 捕获异常方法
 * @create_name: kikock
 * @create_date: 2021-01-13 16:31
 **/
@ControllerAdvice
public class ExceptionCatch {

    private static final Logger log = LoggerFactory.getLogger(ExceptionCatch.class);

    //使用EXCEPTIONS存放异常类型和错误代码的映射，ImmutableMap的特点的一旦创建不可改变，并且线程安全
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    //使用builder来构建一个异常类型和错误代码的异常
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder =
            ImmutableMap.builder();

    static {
//在这里加入一些基础的异常类型判断
//         builder.put(HttpMessageNotReadableException.class,CommonCode.INVALIDPARAM);
    }

    //捕获 CustomException异常(自定义异常)
    @ExceptionHandler(CustomException.class)
    @ResponseBody //转为json返回到页面
    public ResponseResult customException(CustomException e) {
        log.error("捕获自定义异常 : {}\r\n 异常信息: ", e.getMessage(), e);
        ResultCode resultCode = e.getResultCode();
        ResponseResult responseResult = new ResponseResult(resultCode);
        return responseResult;
    }

    //捕获 所有Exception异常
    @ExceptionHandler(Exception.class)
    @ResponseBody //转为json返回到页面
    public ResponseResult Exception(Exception e) {
        log.error("捕获Exception异常 : {}\r\n 异常信息: ", e.getMessage(), e);

        if (EXCEPTIONS == null)
            EXCEPTIONS = builder.build();
        final ResultCode resultCode = EXCEPTIONS.get(e.getClass());
        final ResponseResult responseResult;
        if (resultCode != null) {
            responseResult = new ResponseResult(resultCode);
        } else {
            responseResult = new ResponseResult(CommonCode.SERVER_ERROR);
        }
        return responseResult;
    }
}
