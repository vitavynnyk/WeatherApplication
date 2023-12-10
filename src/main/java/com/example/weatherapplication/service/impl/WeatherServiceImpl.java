package com.example.weatherapplication.service.impl;

import com.example.weatherapplication.dto.WeatherRecordDto;
import com.example.weatherapplication.exception.WeatherRecordNotFoundException;
import com.example.weatherapplication.model.WeatherRecord;
import com.example.weatherapplication.repository.WeatherRepository;
import com.example.weatherapplication.service.WeatherService;
import com.example.weatherapplication.service.mapper.WeatherRecordMapper;
import com.example.weatherapplication.util.WeatherRecordSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;


@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    private final WeatherRecordMapper weatherRecordMapper;
    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository, WeatherRecordMapper weatherRecordMapper) {
        this.weatherRepository = weatherRepository;
        this.weatherRecordMapper = weatherRecordMapper;
    }

    @Override
    @Transactional
    public WeatherRecordDto createWeatherDataRecord(WeatherRecordDto weatherRecordDto) {
        var weatherRecord = weatherRecordMapper.toModel(weatherRecordDto);
        var savedWeatherRecord = weatherRepository.save(weatherRecord);
        return weatherRecordMapper.toDto(savedWeatherRecord);

    }

    @Override
    public List<WeatherRecordDto> getAllWeatherRecords(String date, String cities, String sort) {
        Specification<WeatherRecord> spec = Specification.where(null);
        if (date != null && !date.isEmpty()) {
            spec = spec.and(WeatherRecordSpecification.hasLocalDate(LocalDate.parse(date)));
        }
        if (cities != null && !cities.isEmpty()) {
            spec = spec.and(WeatherRecordSpecification.hasCities(cities));
        }
        if (sort != null && !sort.isEmpty()) {
            spec = spec.and(WeatherRecordSpecification.hasSort(sort));
        }
        return weatherRepository.findAll(spec).stream()
                .map(weatherRecordMapper::toDto)
                .toList();
    }

    @Override
    public WeatherRecordDto getWeatherRecordById(Long id) {
        var weatherRecord = weatherRepository.findById(id)
                .orElseThrow(WeatherRecordNotFoundException::new);
        return weatherRecordMapper.toDto(weatherRecord);
    }

}