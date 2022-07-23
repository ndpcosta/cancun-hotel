package com.ndpcosta.test.cancunhotel.controller;

import com.ndpcosta.test.cancunhotel.dto.BookingRequestDTO;
import com.ndpcosta.test.cancunhotel.dto.BookingResponseDTO;
import com.ndpcosta.test.cancunhotel.exception.HotelException;
import com.ndpcosta.test.cancunhotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookroom")
    ResponseEntity<BookingResponseDTO> bookRoom(@RequestBody BookingRequestDTO request) throws HotelException {
        BookingResponseDTO responseDTO = bookingService.createBooking(request);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
