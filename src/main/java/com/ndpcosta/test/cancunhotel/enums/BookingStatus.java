package com.ndpcosta.test.cancunhotel.enums;

import lombok.Getter;

@Getter
public enum BookingStatus {

    CONFIRMED("Booking confirmed"),
    CANCELED("Booking canceled"),
    UPDATED("Booking updated");

    private String bookingStatus;

    BookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
