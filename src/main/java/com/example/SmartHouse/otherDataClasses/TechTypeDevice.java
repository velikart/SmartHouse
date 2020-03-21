package com.example.SmartHouse.otherDataClasses;

/*
    Класс технического типа девайсов
*/

public class TechTypeDevice {
    private byte id;
    private String name;

    protected TechTypeDevice(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    public TechTypeDevice() {
    }

    public byte getId() {
        return id;
    }

    public TechTypeDevice getTechType(int index){
        switch (index){
            case 1: return TechTypesDevice.SENSOR;
            case 2: return TechTypesDevice.MANAGER_DEVICE;
            default: return TechTypesDevice.COUNTER;
        }
    }
}