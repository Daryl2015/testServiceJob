package com.me.testServiceJob.service.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.me.testServiceJob.service.TestFeignService;
import com.me.testServiceJob.util.DataUtils;

@Component
public class TestFeignServiceImpl implements TestFeignService {

    @Override
    public JSONObject getTestJson(String id, String testJson) {
        JSONObject obj = new JSONObject();
        obj.put("name", "熔断-job");
        obj.put("value", "熔断返回值-job");
        obj.put("updateTime", DataUtils.formatDateTime(new Date()));
        return obj;
    }

    @Override
    public JSONObject testhystrix(String id, String testJson) {
        JSONObject obj = new JSONObject();
        obj.put("name", "熔断-job");
        obj.put("value", "熔断返回值-job");
        obj.put("updateTime", DataUtils.formatDateTime(new Date()));
        return obj;
    }

}
