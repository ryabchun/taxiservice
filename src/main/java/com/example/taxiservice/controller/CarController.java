package com.example.taxiservice.controller;

import com.example.taxiservice.model.Car;
import com.example.taxiservice.model.Manufacturer;
import com.example.taxiservice.service.CarService;
import com.example.taxiservice.service.ManufacturerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CarController", urlPatterns = {"/cars", "/car/register", "/car/delete"})
public class CarController extends HttpServlet {
    private final CarService carService = new CarService();
    private final ManufacturerService manufacturerService = new ManufacturerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/cars".equals(path)) {
            List<Car> cars = carService.findAllCars();
            request.setAttribute("cars", cars);
            request.getRequestDispatcher("/WEB-INF/views/cars.jsp").forward(request, response);
        } else if ("/car/register".equals(path)) {
            List<Manufacturer> manufacturers = manufacturerService.findAllManufacturers();
            request.setAttribute("manufacturers", manufacturers);
            request.getRequestDispatcher("/WEB-INF/views/register_car.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        String contextPath = request.getContextPath();
        if ("/car/register".equals(path)) {
            String model = request.getParameter("model");
            Long manufacturerId = Long.parseLong(request.getParameter("manufacturerId"));
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setId(manufacturerId);

            Car car = new Car();
            car.setModel(model);
            car.setManufacturer(manufacturer);

            carService.registerCar(car);
            response.sendRedirect(contextPath + "/cars");
        } else if ("/car/delete".equals(path)) {
            Long id = Long.parseLong(request.getParameter("id"));
            carService.removeCar(id);
            response.sendRedirect(contextPath + "/cars");
        }
    }
}
