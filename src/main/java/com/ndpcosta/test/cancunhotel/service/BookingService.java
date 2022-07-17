package com.ndpcosta.test.cancunhotel.service;

import com.ndpcosta.test.cancunhotel.dto.BookingRequestDTO;
import com.ndpcosta.test.cancunhotel.dto.BookingResponseDTO;
import org.springframework.stereotype.Component;

@Component
public interface BookingService {

    void cancelBooking();
    BookingResponseDTO createBooking(BookingRequestDTO dto);
    void changeBooking();
}
