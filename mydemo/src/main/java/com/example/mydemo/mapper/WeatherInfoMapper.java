package com.example.mydemo.mapper;

import com.example.mydemo.domain.WeatherInfo;

import java.util.List;

public interface WeatherInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeatherInfo record);

    int insertSelective(WeatherInfo record);

    WeatherInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeatherInfo record);

    int updateByPrimaryKey(WeatherInfo record);

    List<WeatherInfo> selectByAll();
}