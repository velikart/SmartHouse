package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity @Data
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "tech_type")
    private byte techType;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "MAC")
    private String MAC;

    @Column(name = "coordinator_MAC")
    private String coordinatorMAC;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_type_id")
    private DeviceType deviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "device")
    List<DeviceValue> deviceValues = new ArrayList<DeviceValue>();

}
