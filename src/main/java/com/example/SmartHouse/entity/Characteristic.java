package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "CHARACTERISTIC")
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_characteristic")
    @SequenceGenerator(name="seq_characteristic", sequenceName="SEQ_CHARACTERISTIC", allocationSize=1)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "device_type_id")
    private DeviceType deviceType;

    @OneToMany(mappedBy = "characteristic")
    List<ValueTypes> valueTypes = new ArrayList<ValueTypes>();
}

