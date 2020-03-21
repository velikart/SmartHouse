package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "characteristic")
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "device_type_id")
    private DeviceType deviceType;

    @OneToMany(mappedBy = "characteristic")
    List<ValueTypes> valueTypes = new ArrayList<ValueTypes>();
}

