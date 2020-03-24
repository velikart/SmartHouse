package com.example.SmartHouse.controllers;

import com.example.SmartHouse.entity.Characteristic;
import com.example.SmartHouse.entity.DeviceType;
import com.example.SmartHouse.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceTypeController {

    private DeviceTypeService service;

    @Autowired
    public void setDeviceTypeService(DeviceTypeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/deviceType",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public String getDeviceTypes(Model model) {
        List<DeviceType> list = service.findAll();
        model.addAttribute("deviceTypes", list);
        return "success";
    }


    @RequestMapping(value = "/deviceType/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public String getDeviceType(@PathVariable Integer id, Model model) {
        model.addAttribute("deviceType", service.getDeviceTypeById(id));
        return "success";
    }

    @RequestMapping(value = "/deviceType/characteristic/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public String getDeviceTypeCharacteristics(@PathVariable Integer id, Model model) {
        List<Characteristic> characteristics = service.findAllCharacteristic(id);
        model.addAttribute("characteristics", characteristics);
        return "success";
    }


    @RequestMapping(value = "/deviceType/add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public void addDeviceType(@RequestBody DeviceType deviceType) {
        service.saveDeviceType(deviceType);
    }


    @RequestMapping(value = "/deviceType/update",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public void updateDeviceType(@RequestBody DeviceType deviceType) {
        service.updateDeviceType(deviceType.getId(), deviceType.getName());
    }

    @RequestMapping(value = "/deviceType/delete/{id}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteDeviceType(@PathVariable Integer id) {
        service.deleteDeviceType(id);
    }


}
