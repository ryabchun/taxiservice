package com.example.taxiservice.service;

import com.example.taxiservice.dao.ManufacturerDao;
import com.example.taxiservice.model.Manufacturer;

import java.util.List;

public class ManufacturerService {
    private final ManufacturerDao manufacturerDao = new ManufacturerDao();

    public void registerManufacturer(Manufacturer manufacturer) {
        manufacturerDao.save(manufacturer);
    }

    public List<Manufacturer> findAllManufacturers() {
        return manufacturerDao.findAll();
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturerDao.update(manufacturer);
    }

    public void deleteManufacturer(Long id) {
        manufacturerDao.delete(id);
    }
}
