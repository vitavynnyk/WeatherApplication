package com.example.weatherapplication.service.mapper;

import com.example.weatherapplication.dto.WeatherRecordDto;
import com.example.weatherapplication.model.WeatherRecord;
import org.springframework.stereotype.Component;

@Component
public class WeatherRecordMapper {
    public WeatherRecordDto toDto(WeatherRecord weatherRecord) {
        return WeatherRecordDto.builder()
                .id(weatherRecord.getId())
                .date(weatherRecord.getDate())
                .lat(weatherRecord.getLat())
                .lon(weatherRecord.getLon())
                .city(weatherRecord.getCity())
                .state(weatherRecord.getState())
                .temperatures(weatherRecord.getTemperatures())
                .build();
    }

    public WeatherRecord toModel(WeatherRecordDto weatherRecordDto) {
        return WeatherRecord.builder()
                .date(weatherRecordDto.getDate())
                .lat(weatherRecordDto.getLat())
                .lon(weatherRecordDto.getLon())
                .city(weatherRecordDto.getCity())
                .state(weatherRecordDto.getState())
                .temperatures(weatherRecordDto.getTemperatures())
                .version(1)
                .build();
    }

}
