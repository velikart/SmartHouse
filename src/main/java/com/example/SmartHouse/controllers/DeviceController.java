package com.example.SmartHouse.controllers;

import com.example.SmartHouse.entity.*;
import com.example.SmartHouse.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    private DeviceService service;

    @Autowired
    public void setNoteService(DeviceService service) {
        this.service = service;
    }

    @RequestMapping(value = "/device",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public List<Device> getDevices(Model model) {
        List<Device> list = service.findAll();
        model.addAttribute("devices",list);
        return list;
    }


    @RequestMapping(value = "/device/{id}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getDevice(@PathVariable Integer id, Model model) {
        model.addAttribute("device", service.getDeviceById(id));
        return "";
    }

    @RequestMapping(value = "/device/value/{id}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getDeviceDeviceValue(@PathVariable Integer id, Model model) {
        List<DeviceValue> list = service.findAllDeviceValue(id);
        model.addAttribute("deviceValue",list);
        return "";
    }


    @RequestMapping(value = "/device/add",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public void addDevice(@RequestBody Device device) {
        service.saveDevice(device);
    }


    @RequestMapping(value = "/device/update",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public void updateDevice(@RequestBody Device device) {
        service.updateDevice(device.getId(), device.getDeviceType(), device.getRoom(), device.getUser(), device.getName(), device.getMAC(), device.getCoordinatorMAC(), device.isEnabled(), device.getTechType());
    }

    @RequestMapping(value = "/device/delete/{id}",
            method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteDevice(@PathVariable Integer id) {
        service.deleteDevice(id);
    }

}
