package com.uuorb.interview_demo.entity.vo;

import com.uuorb.interview_demo.constant.ResultEnum;

import java.io.Serializable;

public class Result<T> implements Serializable {
    Integer code;

    String msg;
    T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static <T> Result ok(T data) {
        return new Result(ResultEnum.SUCCESS_STATUS.getCode(), "成功", data);
    }

    public static <T> Result ok(T data,String msg) {
        return new Result(ResultEnum.SUCCESS_STATUS.getCode(), msg, data);
    }

    // 处理参数校验规则的错误
    public static <T> Result paramValidError(String errmsg) {
        return new Result(ResultEnum.PARAM_VALID.getCode(), errmsg, null);
    }

    public static Result error(ResultEnum resultStatusEnum) {
        return new Result(resultStatusEnum.getCode(), resultStatusEnum.getMsg(), null);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
