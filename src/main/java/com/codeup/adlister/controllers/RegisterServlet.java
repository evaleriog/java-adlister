package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.codeup.adlister.dao.MySQLUserDao;
import com.codeup.adlister.models.User;
import config.Config;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //boolean allComplete = false;

        if(username != null && email != null && password != null){
            if(!username.equals("") && !email.equals("") && !password.equals("")){
                User user = new User(username, email, password);
                Config config = new Config();
                long id = new MySQLUserDao(config).insert(user);
                user.setId(id);
                request.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }

        }else {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}
