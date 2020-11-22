package com.example.demo.common;

public class BizException extends RuntimeException{
    private String msg;

    public BizException() {

    }

    public BizException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
