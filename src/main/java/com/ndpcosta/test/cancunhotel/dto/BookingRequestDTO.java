package com.ndpcosta.test.cancunhotel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ndpcosta.test.cancunhotel.enums.BookingStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDTO implements Serializable {

    @NotNull
    @JsonProperty("room_id")
    private String roomId;

    @NotNull
    @JsonProperty("guest_id")
    private String guestId;

    @NotNull
    @JsonProperty("checkin_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime checkinDate;

    @NotNull
    @JsonProperty("checkout_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime checkoutDate;

}
