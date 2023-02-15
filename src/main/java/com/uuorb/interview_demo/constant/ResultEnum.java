package com.uuorb.interview_demo.constant;

/**
 * 错误码
 */
public enum ResultEnum {
    SUCCESS_STATUS(200, "SUCCESS"),

    // 4xx 代表客户端错误
    // 参数校验规则
    PARAM_VALID(400, "参数出错");

    // 5xx 代表服务端错误

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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



}
