package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;



@Entity @Data
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_room")
    @SequenceGenerator(name="seq_room", sequenceName="SEQ_ROOM", allocationSize=1)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id")
    private House house;

}
