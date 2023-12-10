package com.example.weatherapplication.repository;

import com.example.weatherapplication.model.WeatherRecord;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherRecord, Long> {
    List<WeatherRecord> findAll(Specification<WeatherRecord> spec);
}

