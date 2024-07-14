package com.qst.medical.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一结果返回类 Msg
 *
 * @author liulindong
 * @since 2021年8月17日13:53:43
 */

public class Msg {

    /*状态码*/
    private Integer code;
    /*响应消息*/
    private String message;
    /*响应是否成功标志*/
    private boolean success;
    /*响应的数据*/
    private Map<String,Object> data = new HashMap<>();

    /**
     * 响应成功函数
     * @return
     */
    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(20000);
        msg.setMessage("响应成功");
        msg.setSuccess(true);
        return msg;
    }

    /**
     * 响应失败函数
     * @return
     */
    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(10000);
        msg.setMessage("响应失败");
        msg.setSuccess(false);
        return msg;
    }

    /**
     * 添加响应数据
     * @return
     */
    public Msg data(String key, Object value) {
        this.data.put(key,value);
        return this;
    }

    /**
     * 修改状态码
     * @return
     */
    public Msg code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 修改消息
     * @return
     */
    public Msg mess(String str) {
        this.setMessage(str);
        return this;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}