package com.ndpcosta.test.cancunhotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HotelException.class)
    public ResponseEntity<Object> handleHotelException(
            HotelException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("id", ex.getExceptionId());
        body.put("code", ex.getExceptionCode());
        body.put("message", ex.getMessage());
        body.put("time", LocalDateTime.now());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
