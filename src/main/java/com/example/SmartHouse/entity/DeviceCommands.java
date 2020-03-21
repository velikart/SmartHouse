package com.example.SmartHouse.entity;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
@Table(name = "device_commands")
public class DeviceCommands {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "command_info")
    private String commandInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_type_id")
    private DeviceType deviceType;
}
