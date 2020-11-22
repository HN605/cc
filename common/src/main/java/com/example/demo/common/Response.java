package com.example.demo.common;

import java.io.Serializable;

public class Response implements Serializable {
    private static final long serialVersionUID = -6943502810404495815L;

    private static final String SUCCESS = "200";
    private static final String ERROR = "500";

    private String code;

    private String msg;

    public Response() {

    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Response success() {
        return new Response(SUCCESS, "success");
    }

    public static Response error(String msg) {
        return new Response(ERROR, msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
