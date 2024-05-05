package com.example.taxiservice.controller;

import com.example.taxiservice.model.Car;
import com.example.taxiservice.model.Driver;
import com.example.taxiservice.service.CarService;
import com.example.taxiservice.service.DriverService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddDriverToCarServlet", urlPatterns = {"/add-driver-to-car"})
public class AddDriverToCarServlet extends HttpServlet {
    private final CarService carService = new CarService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Driver> drivers = new DriverService().findAllDrivers();
        List<Car> cars = new CarService().findAllCars();

        request.setAttribute("drivers", drivers);
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/WEB-INF/views/add_driver_to_car.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long driverId = Long.parseLong(request.getParameter("driverId"));
        Long carId = Long.parseLong(request.getParameter("carId"));

        carService.assignDriverToCar(carId, driverId);
        response.sendRedirect(request.getContextPath() + "/");

    }
}
