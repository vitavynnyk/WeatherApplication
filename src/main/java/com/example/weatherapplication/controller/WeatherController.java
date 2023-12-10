package com.example.weatherapplication.controller;

import com.example.weatherapplication.dto.WeatherRecordDto;
import com.example.weatherapplication.service.WeatherService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")

public class WeatherController {
    private final WeatherService weatherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_EDITOR')")
    public WeatherRecordDto createWeatherDataRecord(@RequestBody WeatherRecordDto weatherRecordDto) {
        return weatherService.createWeatherDataRecord(weatherRecordDto);
    }

    @GetMapping
    public List<WeatherRecordDto> getAllWeatherRecords(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                       @RequestParam(required = false) String date,
                                                       @Pattern(regexp = "^([a-zA-Z]+,)*[a-zA-Z]+$", message = "Invalid cities format")
                                                       @RequestParam(required = false) String cities,
                                                       @Pattern(regexp = "^(date|-date)$", message = "Sort must be 'date' or '-date'")
                                                       @RequestParam(required = false) String sort) {
        return weatherService.getAllWeatherRecords(date, cities, sort);
    }

    @GetMapping("/{id}")
    public WeatherRecordDto getWeatherRecordById(@PathVariable Long id) {
        return weatherService.getWeatherRecordById(id);
    }


}
