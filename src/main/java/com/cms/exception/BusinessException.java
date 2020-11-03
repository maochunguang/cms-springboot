package com.cms.exception;


import com.cms.constant.ResponseEnum;

/**
 * 自定义业务异常
 */
public class BusinessException extends Exception {
    private ResponseEnum responseEnum;

    public BusinessException(ResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.responseEnum = responseEnum;
    }

    public BusinessException(ResponseEnum responseEnum, String message) {
        super(responseEnum.getMessage() + "：" + message);
        this.responseEnum = responseEnum;
    }

    public BusinessException(String selfMessage) {
        super(selfMessage);
        this.responseEnum = ResponseEnum.UNKNOWN;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }
}
