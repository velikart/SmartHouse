package com.example.SmartHouse.otherDataClasses;

/*
    Интерфейс реализации технического типа Девайсов
*/

public interface TechTypesDevice {
    TechTypeDevice SENSOR = new TechTypeDevice((byte) 1, "Sensor");
    TechTypeDevice MANAGER_DEVICE = new TechTypeDevice((byte) 2, "ManagerDevice");
    TechTypeDevice COUNTER = new TechTypeDevice((byte) 3, "Counter");
}