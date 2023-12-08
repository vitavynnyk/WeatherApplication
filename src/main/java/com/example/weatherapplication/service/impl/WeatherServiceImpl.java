package com.example.weatherapplication.service.impl;

import com.example.weatherapplication.dto.WeatherRecordDto;
import com.example.weatherapplication.repository.WeatherRepository;
import com.example.weatherapplication.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private WeatherRepository weatherRepository;
    private WeatherRecordMapper weatherRecordMapper;
    @Override
    public WeatherRecordDto createWeatherDataRecord(WeatherRecordDto weatherRecordDto) {
        weatherRepository.save()
    }

    @Override
    public List<WeatherRecordDto> getAllWeatherRecords() {
        return null;
    }

    @Override
    public WeatherRecordDto getWeatherRecordById(Long id) {
        return null;
    }
}
