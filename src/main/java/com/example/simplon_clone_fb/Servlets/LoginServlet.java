package com.example.simplon_clone_fb.Servlets;

import com.example.simplon_clone_fb.Models.AdministrateurModel;
import com.example.simplon_clone_fb.Models.ApprenantsModel;
import com.example.simplon_clone_fb.Models.FormateursModel;
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
        //Initialise the authService and session
        AuthService authService = new AuthService();
        HttpSession session = request.getSession();
        //modify in the email sended by the user
        String emailLog = request.getParameter("email").split("@")[1];
        //Set the conditions in the email adresse
        if(authService.login("email","password",emailLog) != null){
            Object obj = authService.login("email","password",emailLog);
            if(obj instanceof AdministrateurModel){
                session.setAttribute("id", ((AdministrateurModel) obj).getId());
                session.setAttribute("role","Admin");
            } else if (obj instanceof FormateursModel) {
                session.setAttribute("id", ((FormateursModel) obj).getId());
                session.setAttribute("role","Formateur");
            }else{
                session.setAttribute("id",((ApprenantsModel) obj).getId());
                session.setAttribute("role","Apprenant");
            }

        }else {
            // Redirect to the login page

        };



    }
}
