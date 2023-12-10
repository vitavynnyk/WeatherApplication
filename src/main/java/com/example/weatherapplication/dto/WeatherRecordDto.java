package com.example.weatherapplication.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherRecordDto {
    @NotNull
    private Long id;
    @NotNull
    private LocalDate date;
    @NotNull
    private Double lat;
    @NotNull
    private Double lon;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private List<Double> temperatures;
}
