package com.qst.medical.exception;

/**
 * 自定义异常类
 *
 * @author liulindon
 * @since 2021年8月18日15:27:16
 */

public class CustomException extends Exception{

    public CustomException() {};
    public CustomException(String str) {
        super(str);
    }
}