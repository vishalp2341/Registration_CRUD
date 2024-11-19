package com.register.controller;

import com.register.dao.RegistrationDao;
import com.register.daoimpl.RegistrationDaoImpl;
import com.register.model.Registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view-users")
public class ViewUsersServlet extends HttpServlet {
    private RegistrationDao registrationDao = new RegistrationDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Debugging statements before fetching users
        System.out.println("ViewUsersServlet: Fetching all users from database.");

        List<Registration> users = registrationDao.getAll(); // Fetch all users
        
        // Debugging statement after fetching users
        System.out.println("ViewUsersServlet: Number of users fetched: " + users.size());
        
        if (users.isEmpty()) {
            System.out.println("ViewUsersServlet: No users found in the database.");
        } else {
            System.out.println("ViewUsersServlet: Users fetched successfully.");
        }
        
        // Set as request attribute
        request.setAttribute("users", users); 

        // Forward to JSP
        System.out.println("ViewUsersServlet: Forwarding to view-users.jsp");
        request.getRequestDispatcher("view-users.jsp").forward(request, response); // Forward to JSP
    }
}
