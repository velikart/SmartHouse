package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;



@Entity @Data
@Table(name = "value_history")
public class ValueHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_value_history")
    @SequenceGenerator(name="seq_value_history", sequenceName="SEQ_VALUE_HISTORY", allocationSize=1)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_stamp")
    private Date timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_value_id")
    private DeviceValue deviceValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;
}
