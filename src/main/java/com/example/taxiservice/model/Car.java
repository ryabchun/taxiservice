package com.example.taxiservice.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private Long id;
    private String model;
    private Manufacturer manufacturer;
    private List<Driver> drivers;

    public Car(String model, Manufacturer manufacturer) {
        this.model = model;
        this.manufacturer = manufacturer;
        drivers = new ArrayList<>();
    }

    public Car() {}
    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer (Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


    public Long getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    public List<Driver> getDrivers() {
        return drivers;
    }


    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
