package com.example.weatherapplication.util;

import lombok.Builder;
import lombok.With;

import java.time.Instant;

@With
@Builder
public record GeneralMessageErrorResponse
        (
                Instant dateTime,
                String message
        ) {
}