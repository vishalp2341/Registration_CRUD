package com.register.controller;


import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.RegistrationDao;
import com.register.daoimpl.RegistrationDaoImpl;
import com.register.model.Registration;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private RegistrationDao registrationDao = new RegistrationDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        try {
            // Convert Date of Birth to Date format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateOfBirth = sdf.parse(dob);

            // Create Registration object and save it to the database
            Registration registration = new Registration();
            registration.setName(name);
            registration.setEmail(email);
            registration.setDateOfBirth(dateOfBirth);
            registration.setPhoneNumber(phone);
            registration.setAddress(address);

            // Save registration and redirect to confirmation page
            if (registrationDao.save(registration) > 0) {
                response.sendRedirect("registration-success.jsp");
            } else {
                response.sendRedirect("registration-fail.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("registration-fail.jsp");
        }
    }
}
