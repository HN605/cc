package com.example.demo.common;

import lombok.Data;

@Data
public class BizException extends RuntimeException{
    private String code;
    private String msg;
    public BizException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
