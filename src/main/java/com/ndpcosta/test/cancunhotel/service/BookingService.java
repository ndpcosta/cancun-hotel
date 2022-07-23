package com.ndpcosta.test.cancunhotel.service;

import com.ndpcosta.test.cancunhotel.dto.BookingRequestDTO;
import com.ndpcosta.test.cancunhotel.dto.BookingResponseDTO;
import com.ndpcosta.test.cancunhotel.exception.HotelException;
import org.springframework.stereotype.Component;

@Component
public interface BookingService {

    void cancelBooking();
    BookingResponseDTO createBooking(BookingRequestDTO dto) throws HotelException;
    void changeBooking();
}
