package com.example.simplon_clone_fb.Servlets;

import com.example.simplon_clone_fb.Models.AdministrateurModel;
import com.example.simplon_clone_fb.Services.AuthService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Inside the login servlet");
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthService authService = new AuthService();
        HttpSession session = request.getSession();
        if(authService.login("email","password") != null){
            session.setAttribute("id",authService.login("email","password").getId());
            session.setAttribute("role","Admin");
        }else{
            //forward him to the login page
        }

    }
}
