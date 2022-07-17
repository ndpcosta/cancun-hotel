package com.ndpcosta.test.cancunhotel.entity;

import com.ndpcosta.test.cancunhotel.enums.BookingStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_booking")
public class Booking {

    @Id
    @SequenceGenerator(name = "tb_room_seq", allocationSize = 1, sequenceName = "tb_room_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_room_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", referencedColumnName = "id", nullable = false)
    private Guest guest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    private Room room;

    @Column(name = "checkin_date", nullable = false)
    private LocalDateTime checkinDate;

    @Column(name = "checkout_date", nullable = false)
    private LocalDateTime checkoutDate;

    @Column(name = "status", nullable = false)
    private String bookingStatus;

}





