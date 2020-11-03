package com.cms.constant;

/**
 * 返回码
 */
public enum ResponseEnum {
    /**
     * 返回码
     */
    SUCCESS(0, "success"),
    PARAM_ERR(1000, "参数错误"),
    UNKNOWN(500, "服务异常"),
    AUTH_ERROR(302, "登录权限验证失败"),
    NOT_FOUND(404, "请求错误"),
    ;
    
    private final Integer code;
    private final String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
