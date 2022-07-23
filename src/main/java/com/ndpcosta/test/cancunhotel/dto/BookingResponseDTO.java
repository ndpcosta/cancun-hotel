package com.ndpcosta.test.cancunhotel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDTO implements Serializable {

    @NotNull
    @JsonProperty("booking_status")
    private String bookingStatus;

    @NotNull
    @JsonProperty("reservation_number")
    private String reservationNumber;

    @NotNull
    @JsonProperty("choosed_room")
    private String roomName;

    @NotNull
    @JsonProperty("guest_name")
    private String guestName;

    @NotNull
    @JsonProperty("checkin_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate checkinDate;

    @NotNull
    @JsonProperty("checkout_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate checkoutDate;

    @NotNull
    @JsonProperty("total_days")
    private int totalDays;

}
