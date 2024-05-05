package com.example.taxiservice.controller;

import com.example.taxiservice.model.Driver;
import com.example.taxiservice.service.DriverService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DriverController", urlPatterns = {"/drivers", "/driver/register", "/driver/delete"})
public class DriverController extends HttpServlet {
    private final DriverService driverService = new DriverService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/drivers".equals(path)) {
            List<Driver> drivers = driverService.findAllDrivers();
            request.setAttribute("drivers", drivers);
            request.getRequestDispatcher("/WEB-INF/views/drivers.jsp").forward(request, response);
        } else if ("/driver/register".equals(path)) {
            request.getRequestDispatcher("/WEB-INF/views/register_driver.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String path = request.getServletPath();
        if ("/driver/register".equals(path)) {
            String name = request.getParameter("name");
            String licenseNumber = request.getParameter("licenseNumber");
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            Driver driver = new Driver();
            driver.setName(name);
            driver.setLicenseNumber(licenseNumber);
            driver.setLogin(login);
            driver.setPassword(password);

            driverService.registerDriver(driver);
            response.sendRedirect(contextPath + "/drivers");
        } else if ("/driver/delete".equals(path)) {
            Long id = Long.parseLong(request.getParameter("id"));
            driverService.deleteDriver(id);
            response.sendRedirect(contextPath + "/drivers");
        }
    }
}
