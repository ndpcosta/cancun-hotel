package com.ndpcosta.test.cancunhotel.entity;

import com.ndpcosta.test.cancunhotel.enums.RoomEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "reservation_number", nullable = false, unique = true)
    private String reservationNumber;

    @Column(name = "status", nullable = false)
    private String bookingStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", referencedColumnName = "id", nullable = false)
    private Guest guest;

    @Column(name = "room_id", nullable = false)
    private String room;

    @Column(name = "checkin_date", nullable = false)
    private LocalDate checkinDate;

    @Column(name = "checkout_date", nullable = false)
    private LocalDate checkoutDate;

}





