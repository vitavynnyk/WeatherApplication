package com.example.weatherapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class WeatherRecordNotFoundException extends ResponseStatusException {
    public WeatherRecordNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}
