package com.example.taxiservice.dao;

import com.example.taxiservice.model.Car;
import com.example.taxiservice.model.Manufacturer;
import com.example.taxiservice.util.DatabaseUtil;
import exception.DataProcessingException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDao {
    public void save(Manufacturer manufacturer) {
        String insertQuery = "INSERT INTO manufacturers (name, country) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            ps.setString(1, manufacturer.getName());
            ps.setString(2, manufacturer.getCountry());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert manufacturer: " + manufacturer, e);
        }
    }

    public List<Manufacturer> findAll() {
        String selectQuery = "SELECT id, name, country FROM manufacturers";
        List<Manufacturer> manufacturers = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(selectQuery)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                manufacturers.add(parseManufacturerFromResult(rs));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all manufacturers", e);
        }
        return manufacturers;
    }

    private Manufacturer parseManufacturerFromResult(ResultSet rs) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(rs.getLong("id"));
        manufacturer.setName(rs.getString("name"));
        manufacturer.setCountry(rs.getString("country"));
        return manufacturer;
    }

    public void delete(Long id) {
        String deleteQuery = "DELETE FROM manufacturers WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete manufacturer by id " + id, e);
        }
    }

    public void update(Manufacturer manufacturer) {
        String updateQuery = "UPDATE manufacturers SET name = ?, country = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setString(1, manufacturer.getName());
            ps.setString(2, manufacturer.getCountry());
            ps.setLong(3, manufacturer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update manufacturer: " + manufacturer, e);
        }
    }
}
