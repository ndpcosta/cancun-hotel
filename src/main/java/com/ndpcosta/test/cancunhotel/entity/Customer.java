package com.ndpcosta.test.cancunhotel.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_room")
public class Customer {

    @Id
    @SequenceGenerator(name = "tb_room_seq", allocationSize = 1, sequenceName = "tb_room_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_room_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
}
