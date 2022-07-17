package com.ndpcosta.test.cancunhotel.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
}
