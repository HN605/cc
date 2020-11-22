package com.example.demo.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorHandler {


    @ExceptionHandler(value = Exception.class)
    public Response exceptionHandler(Exception e, HttpServletRequest request){
        //log.error("发生异常：{}", e);
        if (e instanceof BizException) {
            return Response.error(((BizException) e).getMsg());
        } else {
            return Response.error("服务异常");
        }
    }

}
