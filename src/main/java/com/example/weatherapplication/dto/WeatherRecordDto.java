package com.example.weatherapplication.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherRecordDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Instant date;
    @NotNull
    private Double lat;
    @NotNull
    private Double lon;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private List<Integer> temperatures;
}
