package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1170116987346403686L;
    private int code;
    private String msg;

    public Result() {
        super();
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result success() {
        return new Result(200, "success");
    }

    public static Result fail() {
        return fail("fail");
    }

    public static Result fail(String msg) {
        return new Result(500, msg);
    }
}
