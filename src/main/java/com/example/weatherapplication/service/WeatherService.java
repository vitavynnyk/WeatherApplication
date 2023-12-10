package com.example.weatherapplication.service;

import com.example.weatherapplication.dto.WeatherRecordDto;

import java.util.List;

public interface WeatherService {
    WeatherRecordDto createWeatherDataRecord(WeatherRecordDto weatherRecordDto);

    List<WeatherRecordDto> getAllWeatherRecords(String date, String cities, String sort);


    WeatherRecordDto getWeatherRecordById(Long id);
}
