package com.example.taxiservice.service;

import com.example.taxiservice.dao.CarDao;
import com.example.taxiservice.model.Car;

import java.util.List;

public class CarService {
    private final CarDao carDao = new CarDao();

    public void registerCar(Car car) {
        carDao.save(car);
    }

    public List<Car> findAllCars() {
        return carDao.findAll();
    }

    public void updateCar(Car car) {
        carDao.update(car);
    }

    public void deleteCar(Long id) {
        carDao.delete(id);
    }
    public void assignDriverToCar(Long carId, Long driverId) {
        carDao.addDriverToCar(carId, driverId);
    }

    public void removeDriverFromCar(Long carId, Long driverId) {
        carDao.removeDriverFromCar(carId, driverId);
    }

    public void removeCar(Long id) {
        carDao.delete(id);
    }
    public List<Car> getCarsByDriverId(Long driverId) {
        return carDao.findAllByDriverId(driverId);
    }
}
