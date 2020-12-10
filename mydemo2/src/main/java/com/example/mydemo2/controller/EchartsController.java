package com.example.mydemo2.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.mydemo2.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echarts")
public class EchartsController {


    @Autowired
    EchartsService service;

    @RequestMapping(value = "/getGoodsDatas")
    public JSONObject getGoodsData() {
        return service.getGoodsCount();
    }


    // --漏斗图数据源2
    // https://echarts.apache.org/examples/zh/editor.html?c=funnel&theme=dark
    @RequestMapping(value = "/getFunnelCount")
    public JSONObject getFunnelCount() {
        return service.getFunnelCount();
    }

    // --漏斗图数据源1
    @RequestMapping(value = "/getFunnel")
    public JSONArray getFunnel() {
        return service.getFunnel();
    }


    // --月份维度数据
    @RequestMapping(value = "/getMonth")
    public JSONArray getMonth() {
        return service.getMonth();
    }

    // --测试读取修改数据
    @RequestMapping(value = "/getTest")
    public JSONArray getTest(){
        return service.getTestData();
    }
    // --测试修改数据
    @RequestMapping(value = "/changeData")
    public String changeData() throws InterruptedException {
        return service.changeData();
    }


    @RequestMapping(value = "/test")
    public String test() {
        return service.test();
    }
}
