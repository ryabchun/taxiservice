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
import java.util.Optional;

public class DriverDao {

    public void save(Driver driver) {
        String insertQuery = "INSERT INTO drivers (name, license_number, login, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            ps.setString(1, driver.getName());
            ps.setString(2, driver.getLicenseNumber());
            ps.setString(3, driver.getLogin());
            ps.setString(4, driver.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver: " + driver, e);
        }
    }

    public List<Driver> findAll() {
        String selectQuery = "SELECT id, name, license_number, login, password FROM drivers";
        List<Driver> drivers = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(selectQuery)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                drivers.add(parseDriverFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers", e);
        }
        return drivers;
    }


    public void update(Driver driver) {
        String updateQuery = "UPDATE drivers SET name = ?, license_number = ?, login = ?, password = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setString(1, driver.getName());
            ps.setString(2, driver.getLicenseNumber());
            ps.setString(3, driver.getLogin());
            ps.setString(4, driver.getPassword());
            ps.setLong(5, driver.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver: " + driver, e);
        }
    }

    public void delete(Long id) {
        String deleteQuery = "DELETE FROM drivers WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver by id " + id, e);
        }
    }

    private Driver parseDriverFromResultSet(ResultSet rs) throws SQLException {
        Driver driver = new Driver();
        driver.setId(rs.getLong("id"));
        driver.setName(rs.getString("name"));
        driver.setLicenseNumber(rs.getString("license_number"));
        driver.setLogin(rs.getString("login"));
        driver.setPassword(rs.getString("password"));
        return driver;
    }

    public Driver findById(Long id) {
        String selectQuery = "SELECT id, name, license_number, login, password FROM drivers WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(selectQuery)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return parseDriverFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver by id " + id, e);
        }
        return null;
    }

    public Optional<Driver> authenticate(String login, String password) {
        String sql = "SELECT id, name, license_number, login, password FROM drivers WHERE login = ? AND password = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(parseDriverFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't authenticate driver with login " + login, e);
        }
        return Optional.empty();
    }
}
