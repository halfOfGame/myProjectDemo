package com.example.mydemo2.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface EchartsService {

    JSONObject getGoodsCount();

    JSONObject getFunnelCount();
    JSONArray getFunnel();

    JSONArray getMonth();

    JSONArray getTestData();
    String changeData() throws InterruptedException;

    String test();
}
