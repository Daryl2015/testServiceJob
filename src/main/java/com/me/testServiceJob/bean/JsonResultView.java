package com.me.testServiceJob.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class JsonResultView<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SUCCESS = "0000";
    public static final String SUCCESS_MSG = "操作成功";
    protected String code;
    protected String msg;
    protected String data;

    public JsonResultView() {
    }

    public JsonResultView(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResultView(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = JSON.toJSONString(data);
    }

    public JsonResultView(String code, T data) {
        this.code = code;
        this.data = JSON.toJSONString(data);
    }

    public String getCode() {
        return code;
    }

    public String getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = JSON.toJSONString(data);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
