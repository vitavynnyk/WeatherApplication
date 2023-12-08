package com.example.weatherapplication.repository;

import com.example.weatherapplication.model.WeatherRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherRecord, Long> {
}
