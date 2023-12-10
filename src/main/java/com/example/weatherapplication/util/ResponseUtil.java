package com.example.weatherapplication.util;

import java.time.Instant;

public class ResponseUtil {
    public static GeneralMessageErrorResponse createGeneralMessageErrorResponse(String message) {
        return GeneralMessageErrorResponse.builder()
                .dateTime(Instant.now())
                .message(message)
                .build();
    }
}
