package com.ndpcosta.test.cancunhotel.utils;

import java.time.LocalDateTime;

public abstract class ReservationNumberBuilder {

    public static String buildReservationNumber() {
        return LocalDateTime.now() + "RN";
    }
}
