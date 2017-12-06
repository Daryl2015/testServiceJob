package com.me.testServiceJob.bean;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TestBean {
    @JSONField(name = "customer")
    private String name;
    @JSONField(name = "phone")
    private String value;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
