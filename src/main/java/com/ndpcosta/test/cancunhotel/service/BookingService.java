package com.ndpcosta.test.cancunhotel.service;

import org.springframework.stereotype.Component;

@Component
public interface BookingService {

    void cancelBooking();
    void bookRoom();
    void changeBooking();
}
