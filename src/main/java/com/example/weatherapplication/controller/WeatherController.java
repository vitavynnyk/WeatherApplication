package com.example.weatherapplication.controller;

import com.example.weatherapplication.dto.WeatherRecordDto;
import com.example.weatherapplication.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WeatherRecordDto createWeatherDataRecord(@RequestBody WeatherRecordDto weatherRecordDto) {
       return weatherService.createWeatherDataRecord(weatherRecordDto);
    }

    @GetMapping
    public List<WeatherRecordDto> getAllWeatherRecords() {
        return null;
    }

    @GetMapping("/{id}")
    public WeatherRecordDto getWeatherRecordById(@PathVariable Long id){
        return null;
    }


}
