package com.example.taxiservice.controller;

import com.example.taxiservice.model.Car;
import com.example.taxiservice.model.Driver;
import com.example.taxiservice.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DriverCarsServlet", urlPatterns = {"/driver-cars"})
public class DriverCarsServlet extends HttpServlet {
    private final CarService carService = new CarService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Driver loggedDriver = (Driver) request.getSession().getAttribute("loggedDriver");
        if (loggedDriver != null) {
            List<Car> cars = carService.getCarsByDriverId(loggedDriver.getId());
            request.setAttribute("cars", cars);
        }
        request.getRequestDispatcher("/WEB-INF/views/driver_cars.jsp").forward(request, response);
    }
}
