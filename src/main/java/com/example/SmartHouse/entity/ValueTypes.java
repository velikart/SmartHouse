package com.example.SmartHouse.entity;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
@Table(name = "value_types")
public class ValueTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "def_seq")
//TODO    @SequenceGenerator
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit")
    private  String unit;

    @Column(name = "ratio")
    private String ratio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "characteristic_id")
    private Characteristic characteristic;
}
