package com.example.mydemo.service;

import com.example.mydemo.domain.WeatherInfo;

import java.util.List;

public interface WeatherInfoService {
    WeatherInfo getWeather(Integer id);

    List<WeatherInfo> getAll();
}
