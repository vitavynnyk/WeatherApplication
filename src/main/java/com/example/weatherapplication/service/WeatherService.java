package com.example.weatherapplication.service;

import com.example.weatherapplication.dto.WeatherRecordDto;

import java.util.List;

public interface WeatherService {
    WeatherRecordDto createWeatherDataRecord(WeatherRecordDto weatherRecordDto);
    List<WeatherRecordDto> getAllWeatherRecords();
    WeatherRecordDto getWeatherRecordById( Long id);
}
