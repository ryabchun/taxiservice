package com.example.taxiservice.dao;

import com.example.taxiservice.model.Car;
import com.example.taxiservice.model.Driver;
import com.example.taxiservice.model.Manufacturer;
import com.example.taxiservice.util.DatabaseUtil;

import exception.DataProcessingException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    public void save(Car car) {
        String insertQuery = "INSERT INTO cars (model, manufacturer_id) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            ps.setString(1, car.getModel());
            ps.setLong(2, car.getManufacturer().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert car: " + car, e);
        }
    }

    public List<Car> findAll() {
        String selectQuery = "SELECT c.id, c.model, c.manufacturer_id, "
                + "m.name as manufacturer_name, m.country as manufacturer_country "
                + "FROM cars c "
                + "LEFT JOIN manufacturers m on c.manufacturer_id = m.id";


        List<Car> cars = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(selectQuery)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cars.add(parseCarFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all cars", e);
        }
        return cars;
    }
    public void update(Car car) {
        String updateQuery = "UPDATE cars SET model = ?, manufacturer_id = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setString(1, car.getModel());
            ps.setLong(2, car.getManufacturer().getId());
            ps.setLong(3, car.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update car: " + car, e);
        }
    }

    public void delete(Long id) {
        String deleteQuery = "DELETE FROM cars WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete car by id " + id, e);
        }
    }

    private Car parseCarFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getLong("id"));
        car.setModel(rs.getString("model"));

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(rs.getLong("manufacturer_id"));
        manufacturer.setName(rs.getString("manufacturer_name"));
        manufacturer.setCountry(rs.getString("manufacturer_country"));

        car.setManufacturer(manufacturer);
        car.setDrivers(getDriversByCarId(car.getId()));
        return car;
    }

    public Car findById(Long id) {
        String selectQuery = "SELECT c.id, model, c.manufacturer_id, "
                + "m.name as manufacturer_name, m.country as manufacturer_country "
                + "FROM cars c "
                + "JOIN manufacturers m on c.manufacturer_id = m.id "
                + "WHERE c.id = ? AND c.is_deleted = false";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(selectQuery)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return parseCarFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get car by id " + id, e);
        }
        return null;
    }

    private List<Driver> getDriversByCarId(Long carId) {
        String selectDrivers = "SELECT d.id, d.name, d.license_number, d.login, d.password FROM drivers d "
                + "JOIN cars_drivers cd on d.id = cd.driver_id "
                + "WHERE cd.car_id = ?";
        List<Driver> drivers = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(selectDrivers)) {
            ps.setLong(1, carId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Driver driver = new Driver();
                driver.setId(rs.getLong("id"));
                driver.setName(rs.getString("name"));
                driver.setLicenseNumber(rs.getString("license_number"));
                driver.setLogin(rs.getString("login"));
                driver.setPassword(rs.getString("password"));
                drivers.add(driver);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get drivers for car " + carId, e);
        }
        return drivers;
    }

    public void addDriverToCar(Long carId, Long driverId) {
        String insertQuery = "INSERT INTO cars_drivers (car_id, driver_id) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            ps.setLong(1, carId);
            ps.setLong(2, driverId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add driver " + driverId + " to car " + carId, e);
        }
    }

    public void removeDriverFromCar(Long carId, Long driverId) {
        String deleteQuery = "DELETE FROM cars_drivers WHERE car_id = ? AND driver_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(deleteQuery)) {
            ps.setLong(1, carId);
            ps.setLong(2, driverId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't remove driver " + driverId + " from car " + carId, e);
        }
    }

    public List<Car> findAllByDriverId(Long driverId) {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT c.id, c.model, c.manufacturer_id "
                + "FROM cars c JOIN cars_drivers cd ON c.id = cd.car_id "
                + "WHERE cd.driver_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, driverId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getLong("id"));
                car.setModel(rs.getString("model"));
                // Fetch and set the manufacturer if needed
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
