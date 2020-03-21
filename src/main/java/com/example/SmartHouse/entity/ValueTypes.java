package com.example.SmartHouse.entity;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
@Table(name = "value_types")
public class ValueTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_value_types")
    @SequenceGenerator(name="seq_value_types", sequenceName="SEQ_VALUE_TYPES", allocationSize=1)
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
