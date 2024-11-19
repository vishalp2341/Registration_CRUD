package com.register.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.daoimpl.RegistrationDaoImpl;
import com.register.model.Registration;

@WebServlet("/update-user")
public class UpdateUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        RegistrationDaoImpl registrationDao = new RegistrationDaoImpl();
        
        // Fetch user details by ID
        Registration user = registrationDao.getById(userId);
        
        // Format the Date of Birth for the input field
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDob = sdf.format(user.getDateOfBirth());

        // Set user details and formatted DOB as attributes to be used in the JSP
        request.setAttribute("user", user);
        request.setAttribute("formattedDob", formattedDob);

        // Forward to update-user.jsp
        request.getRequestDispatcher("update-user.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob"); // Date as string from the form
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // Convert the date from string to java.sql.Date
        Date dateOfBirth = Date.valueOf(dob);

        // Create Registration object with updated data
        Registration user = new Registration(userId, name, email, dateOfBirth, phone, address);
        
        // Update user data
        RegistrationDaoImpl registrationDao = new RegistrationDaoImpl();
        int result = registrationDao.update(user);
        
        // Redirect to the view-users page after updating
        if (result > 0) {
            response.sendRedirect("view-users");
        } else {
            response.sendRedirect("update-user?id=" + userId);  // Handle update failure
        }
    }
}
