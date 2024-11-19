package com.register.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.daoimpl.RegistrationDaoImpl;

@WebServlet("/delete-user")
public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        
        RegistrationDaoImpl registrationDao = new RegistrationDaoImpl();
        
        // Delete the user
        int result = registrationDao.delete(userId);
        
        // Redirect to the view-users page after deletion
        if (result > 0) {
            response.sendRedirect("view-users");
        } else {
            response.sendRedirect("view-users");  // Handle delete failure.
        }
    }
}
