package com.sky.statistics.core.exception;

/**
 * Created by User on 2015/10/29.
 * 记录异常操作
 */
public class UserException extends RuntimeException {
    public UserException() {
    }

    public UserException(String msg) {
        super(msg);
    }
}
