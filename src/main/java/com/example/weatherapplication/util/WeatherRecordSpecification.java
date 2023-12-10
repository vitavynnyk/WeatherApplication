package com.example.weatherapplication.util;

import com.example.weatherapplication.model.WeatherRecord;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Arrays;


public class WeatherRecordSpecification {
    public static Specification<WeatherRecord> hasLocalDate(LocalDate date) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("date"), date);
    }

    public static Specification<WeatherRecord> hasCities(String cities) {
        return (root, query, criteriaBuilder) -> {
            var cityList = Arrays.asList(cities.split(","));
            var predicates = cityList.stream()
                    .map(city -> criteriaBuilder.equal(criteriaBuilder.lower(root.get("city")), city.trim()))
                    .toArray(Predicate[]::new);
            return criteriaBuilder.or(predicates);
        };
    }

    public static Specification<WeatherRecord> hasSort(String sort) {
        return (root, query, criteriaBuilder) -> {
            if ("date".equals(sort)) {
                query.orderBy(criteriaBuilder.asc(root.get("date")));
            } else if ("-date".equals(sort)) {
                query.orderBy(criteriaBuilder.desc(root.get("date")));
            }
            return null;
        };
    }
}
