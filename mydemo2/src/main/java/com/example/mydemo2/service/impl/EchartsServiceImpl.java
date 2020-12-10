package com.example.mydemo2.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.mydemo2.domain.ThreeDimensionData;
import com.example.mydemo2.domain.TwelveDimensionData;
import com.example.mydemo2.domain.TwoDimensionData;
import com.example.mydemo2.domain.FiveDimensionData;
import com.example.mydemo2.mapper.EchartsMapper;
import com.example.mydemo2.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EchartsServiceImpl implements EchartsService {

    @Autowired
    EchartsMapper mapper;

    @Override
    public JSONObject getGoodsCount() {
        List<TwoDimensionData> datas = mapper.getGoodsCount();
        List xDataList = new ArrayList();
        List yDataList = new ArrayList();
        for (TwoDimensionData data : datas) {
            xDataList.add(data.getxData());
            yDataList.add(data.getyData());
        }

        JSONObject jsonObject = new JSONObject();
        JSONArray xData = new JSONArray(xDataList);
        JSONArray yData = new JSONArray(yDataList);
        jsonObject.put("xData", xData);
        jsonObject.put("yData", yData);


        return jsonObject;

    }


    /**
     * [
     * {value: 60, name: '访问'},
     * {value: 40, name: '咨询'},
     * {value: 20, name: '订单'},
     * {value: 80, name: '点击'},
     * {value: 100, name: '展现'}
     * ]
     */
    @Override
    public JSONObject getFunnelCount() {
        FiveDimensionData data = mapper.getFunnelCount();
        FiveDimensionData info = mapper.getFiveDimension(1);
        JSONObject result = new JSONObject();
        List datas = new ArrayList();
        datas.add(info.getData1());
        datas.add(info.getData2());
        datas.add(info.getData3());
        datas.add(info.getData4());
        datas.add(info.getData5());
        JSONArray sourceOne = new JSONArray();
        JSONArray sourceTwo = new JSONArray(datas);
        for (int i = 0; i < 5; i++) {
            sourceOne.add(new JSONObject());
        }
        ((JSONObject) sourceOne.get(0)).put("name", info.getData1());
        ((JSONObject) sourceOne.get(0)).put("value", data.getData1());
        ((JSONObject) sourceOne.get(1)).put("name", info.getData2());
        ((JSONObject) sourceOne.get(1)).put("value", data.getData2());
        ((JSONObject) sourceOne.get(2)).put("name", info.getData3());
        ((JSONObject) sourceOne.get(2)).put("value", data.getData3());
        ((JSONObject) sourceOne.get(3)).put("name", info.getData4());
        ((JSONObject) sourceOne.get(3)).put("value", data.getData4());
        ((JSONObject) sourceOne.get(4)).put("name", info.getData5());
        ((JSONObject) sourceOne.get(4)).put("value", data.getData5());
        result.put("resourceOne", sourceOne);
        result.put("resourceTwo", sourceTwo);
        return result;
    }

    /**
     * data: ['展现','点击','访问','咨询','订单']
     */
    @Override
    public JSONArray getFunnel() {
        FiveDimensionData info = mapper.getFiveDimension(1);
        List datas = new ArrayList();
        datas.add(info.getData1());
        datas.add(info.getData2());
        datas.add(info.getData3());
        datas.add(info.getData4());
        datas.add(info.getData5());
        return new JSONArray(datas);
    }

    @Override
    public JSONArray getMonth() {
        TwelveDimensionData info = mapper.getTwelveDimension(1);
        List datas = new ArrayList();
        datas.add(info.getData1());
        datas.add(info.getData2());
        datas.add(info.getData3());
        datas.add(info.getData4());
        datas.add(info.getData5());
        datas.add(info.getData6());
        datas.add(info.getData7());
        datas.add(info.getData8());
        datas.add(info.getData9());
        datas.add(info.getData10());
        datas.add(info.getData11());
        datas.add(info.getData12());
        return new JSONArray(datas);
    }

    @Override
    public JSONArray getTestData() {
        ThreeDimensionData data = mapper.getThreeDimensionData();
        JSONArray result = new JSONArray();
        result.add(data.getData1());
        result.add(data.getData2());
        result.add(data.getData3());
        return result;
    }

    @Override
    public String changeData() throws InterruptedException {
        Random random = new Random();
        String result = "";
        ThreeDimensionData data = mapper.getThreeDimensionData();
        result = result + "data1 = " + data.getData1() + ", data2 = " + data.getData2() + ", data3 = " + data.getData3() + "<br>";
        Integer IntegerOne = Integer.valueOf(data.getData1());
        Integer IntegerTwo = Integer.valueOf(data.getData2());
        Integer IntegerThree = Integer.valueOf(data.getData3());
        String value1 = String.valueOf(IntegerOne + random.nextInt(20));
        String value2 = String.valueOf(IntegerTwo + random.nextInt(20));
        String value3 = String.valueOf(IntegerThree + random.nextInt(20));
        mapper.changeData(value1, value2, value3);
        result = result + "data1 = " + value1 + ", data2 = " + value2 + ", data3 = " + value3;
        return result;
    }

    @Override
    public String test() {
        return mapper.test(1).toString();
    }
}
