package com.example.taxiservice.service;

import com.example.taxiservice.dao.CarDao;
import com.example.taxiservice.dao.DriverDao;
import com.example.taxiservice.model.Car;
import com.example.taxiservice.model.Driver;

import java.util.List;

public class DriverService {
    private final DriverDao driverDao = new DriverDao();

    public void registerDriver(Driver driver) {
        driverDao.save(driver);
    }
    public List<Driver> findAllDrivers() {
        return driverDao.findAll();
    }
    public void updateDriver(Driver driver) {
        driverDao.update(driver);
    }
    public void deleteDriver(Long id) {
        driverDao.delete(id);
    }

    public Driver authenticate(String login, String password) {
        return driverDao.authenticate(login, password).orElse(null);
    }

}
