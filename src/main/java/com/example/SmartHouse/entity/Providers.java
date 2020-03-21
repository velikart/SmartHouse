package com.example.SmartHouse.entity;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
@Table(name = "providers")
public class Providers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_providers")
    @SequenceGenerator(name="seq_providers", sequenceName="SEQ_PROVIDERS", allocationSize=1)
    private int id;

    @Column(name = "provider_token")
    private String providerToken;

    @Column(name = "name")
    private  String name;
}
