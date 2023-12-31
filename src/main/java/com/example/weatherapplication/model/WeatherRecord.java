package com.example.weatherapplication.model;


import com.example.weatherapplication.util.DoubleListConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "weather_records")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Convert(converter = DoubleListConverter.class)
    private List<Double> temperatures;
    @NotNull
    private Integer version;

}
