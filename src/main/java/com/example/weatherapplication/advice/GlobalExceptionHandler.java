package com.example.weatherapplication.advice;

import com.example.weatherapplication.util.GeneralMessageErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;

import static com.example.weatherapplication.util.ResponseUtil.createGeneralMessageErrorResponse;


@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<GeneralMessageErrorResponse> handleConstrainViolationException(ConstraintViolationException ex) {
        var message = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .findFirst().orElseThrow();
        var response = createGeneralMessageErrorResponse(message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<GeneralMessageErrorResponse> handleDateTimeParseException(){
        var message = "Wrong date format";
        var response = createGeneralMessageErrorResponse(message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
