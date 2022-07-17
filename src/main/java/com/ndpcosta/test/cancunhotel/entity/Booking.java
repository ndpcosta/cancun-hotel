package com.ndpcosta.test.cancunhotel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @Column(name = "checkin_date")
    private LocalDateTime checkinDate;

}





