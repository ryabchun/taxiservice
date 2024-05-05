package com.example.taxiservice.controller;

import com.example.taxiservice.model.Manufacturer;
import com.example.taxiservice.service.ManufacturerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManufacturerController", urlPatterns = {"/manufacturers", "/manufacturer/register", "/manufacturer/delete"})
public class ManufacturerController extends HttpServlet {
    private final ManufacturerService manufacturerService = new ManufacturerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/manufacturers".equals(path)) {
            List<Manufacturer> manufacturers = manufacturerService.findAllManufacturers();
            request.setAttribute("manufacturers", manufacturers);
            request.getRequestDispatcher("/WEB-INF/views/manufacturers.jsp").forward(request, response);
        } else if ("/manufacturer/register".equals(path)) {
            request.getRequestDispatcher("/WEB-INF/views/register_manufacturer.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        String contextPath = request.getContextPath();
        if ("/manufacturer/register".equals(path)) {
            String name = request.getParameter("name");
            String country = request.getParameter("country");

            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setName(name);
            manufacturer.setCountry(country);

            manufacturerService.registerManufacturer(manufacturer);
            response.sendRedirect(contextPath + "/manufacturers");
        } else if ("/manufacturer/delete".equals(path)) {
            Long id = Long.parseLong(request.getParameter("id"));
            manufacturerService.deleteManufacturer(id);
            response.sendRedirect(contextPath + "/manufacturers");
        }
    }
}
