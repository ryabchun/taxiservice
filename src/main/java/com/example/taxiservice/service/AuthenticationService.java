package com.example.taxiservice.service;

import com.example.taxiservice.dao.DriverDao;
import com.example.taxiservice.model.Driver;

import java.util.Optional;

public class AuthenticationService {
    private final DriverDao driverDao = new DriverDao();

    public Optional<Driver> authenticate(String login, String password) {
        return driverDao.authenticate(login, password);
    }

}
