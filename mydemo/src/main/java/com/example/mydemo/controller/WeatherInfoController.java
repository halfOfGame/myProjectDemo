package com.example.mydemo.controller;


import com.example.mydemo.domain.WeatherInfo;
import com.example.mydemo.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherInfoController {

    @Autowired
    private WeatherInfoService service;

    @RequestMapping("/getList")
    public List<WeatherInfo> getAll() {

        return service.getAll();
    }

    @RequestMapping("/getWeather")
    public WeatherInfo getWeatherInfo() {

        return service.getWeather(1);
    }

    @RequestMapping("/getStr")
    @ResponseBody
    public String getStrInfo(){
        return "{\"xData\":[\"衬衫\",\"羊毛衫\",\"雪纺衫\",\"裤子\",\"高跟鞋\",\"袜子\"],\"yData\":[5,20,36,10,10,20]}";
    }
}
