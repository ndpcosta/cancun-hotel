package com.ndpcosta.test.cancunhotel.enums;

import java.util.Arrays;
import java.util.Optional;

public enum BookingStatus {

    CONFIRMED("Booking confirmed"),
    CANCELED("Booking canceled"),
    UPDATED("Booking updated");

    private String bookingStatus;

    private BookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    public String getBookingStatus() {
        return this.bookingStatus;
    }
}
