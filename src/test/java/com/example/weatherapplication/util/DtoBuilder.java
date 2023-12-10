package com.example.weatherapplication.util;

import com.example.weatherapplication.dto.WeatherRecordDto;

import java.time.LocalDate;
import java.util.List;

public class DtoBuilder {
    public static WeatherRecordDto createWeatherDto(){
        return WeatherRecordDto.builder()
                .date(LocalDate.parse("1985-01-01"))
                .lat(36.1189)
                .lon(-86.6892)
                .city("Nashville")
                .state("Tennessee")
                .temperatures(List.of(17.3, 16.8, 16.4, 16.0, 15.6, 15.3, 15.0, 14.9, 15.8, 18.0, 20.2))
                .build();
    }
}
