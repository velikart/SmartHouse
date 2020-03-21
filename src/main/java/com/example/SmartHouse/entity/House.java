package com.example.SmartHouse.entity;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
