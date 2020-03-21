package com.example.SmartHouse.entity;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
@Table(name = "device_commands")
public class DeviceCommands {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_device_commands")
    @SequenceGenerator(name="seq_device_commands", sequenceName="SEQ_DEVICE_COMMANDS", allocationSize=1)
    private int id;

    @Column(name = "command_info")
    private String commandInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_type_id")
    private DeviceType deviceType;
}
