package com.example.SmartHouse.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity @Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "user_token")
    private String userToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private Providers providers;

    @OneToMany (mappedBy = "user")
    List<Device> devices = new ArrayList<Device>();

}


