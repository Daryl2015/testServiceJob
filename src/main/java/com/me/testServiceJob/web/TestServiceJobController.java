package com.me.testServiceJob.web;

import java.util.Date;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import com.alibaba.fastjson.JSONObject;
import com.me.testServiceJob.bean.JsonResultView;
import com.me.testServiceJob.bean.TestBean;
import com.me.testServiceJob.service.TestFeignService;
import com.me.testServiceJob.util.DataUtils;

@RestController
@RequestMapping("/test")
@SuppressWarnings("all")
public class TestServiceJobController {

    @Autowired
    private TestFeignService testFeignService;

    /**
     * getTestBean
     */
    @RequestMapping("/getTestBean")
    @ResponseBody
    public JSONObject getTestBean(String id, String testJson) {
        JSONObject obj = new JSONObject();
        obj.put("name", "serverJob");
        obj.put("value", "getTestBean".concat("-").concat(id).concat("-").concat(testJson));
        obj.put("updateTime", DataUtils.formatDateTime(new Date()));
        return obj;
    }

    /**
     * testhystrix
     */
    @RequestMapping("/testhystrix")
    @ResponseBody
    public JSONObject testhystrix(String id, String testJson) {
        return testFeignService.testhystrix(id, testJson);

    }

    /**
     * testJson
     */
    @RequestMapping("/getTestJson")
    @ResponseBody
    public JSONObject getTestJson(String id, String testJson) {
        return testFeignService.getTestJson(id, testJson);
    }

    /**
     * 测试服务开启
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public String testIndex(HttpServletRequest request, HttpServletResponse response) {
        return "server is startup." + DataUtils.formatDateTime(new Date());
    }

    /**
     * 返回json格式数据
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/json")
    @ResponseBody
    public String testJson(HttpServletRequest request, HttpServletResponse response) {
        TestBean bean = new TestBean();
        bean.setName("名称");
        bean.setValue("值");
        bean.setUpdateTime(new Date());
        return JSONObject.toJSONString(bean);
    }

    /**
     * 返回对象-spring自动转成json
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/commJson")
    @ResponseBody
    public JsonResultView testJsonObject(HttpServletRequest request, HttpServletResponse response) {
        TestBean bean = new TestBean();
        bean.setName("名称");
        bean.setValue("123456789");
        bean.setUpdateTime(new Date());
        return new JsonResultView(JsonResultView.SUCCESS, JsonResultView.SUCCESS_MSG, bean);
    }

    /**
     * 异步请求
     * 返回对象-spring自动转成json
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/ayncJson")
    @ResponseBody
    public WebAsyncTask<JsonResultView> testCommonResponse(HttpServletRequest request, HttpServletResponse response) {
        Callable<JsonResultView> callable = new Callable<JsonResultView>() {
            @Override
            public JsonResultView call() throws Exception {
                TestBean bean = new TestBean();
                bean.setName("异步");
                bean.setValue("123456789");
                bean.setUpdateTime(new Date());
                return new JsonResultView(JsonResultView.SUCCESS, JsonResultView.SUCCESS_MSG, bean);
            }
        };

        return new WebAsyncTask<JsonResultView>(callable);
    }
}
