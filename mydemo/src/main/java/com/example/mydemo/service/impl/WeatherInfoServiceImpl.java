package com.example.mydemo.service.impl;

import com.example.mydemo.domain.WeatherInfo;
import com.example.mydemo.mapper.WeatherInfoMapper;
import com.example.mydemo.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherInfoServiceImpl implements WeatherInfoService {

    @Autowired
    private WeatherInfoMapper weatherMapper;

    @Override
    public List<WeatherInfo> getAll() {
        return weatherMapper.selectByAll();
    }



    @Override
    public WeatherInfo getWeather(Integer id) {
        return weatherMapper.selectByPrimaryKey(id);
    }
}
