package com.example.simplon_clone_fb.Servlets;


import Models.AdministrateurModel;
import Models.ApprenantsModel;
import Models.FormateursModel;
import com.example.simplon_clone_fb.Services.AuthServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name="LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void init(){
        System.out.println("Inside the login servlet");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Initialise the authService and session
        AuthServices authService = new AuthServices();
        HttpSession session = request.getSession();
        //modify in the email sended by the user
        String emailLog =  request.getParameter("email").split("@")[1];
        Object obj = authService.login(request.getParameter("email"),request.getParameter("password"),emailLog);
        //Set the conditions in the email adresse
        if(obj != null){
            if(obj instanceof AdministrateurModel){
                session.setAttribute("id", ((AdministrateurModel) obj).getId());
                session.setAttribute("role","Admin");
                request.getRequestDispatcher("AdminServlet?field=formateurs&op=read").forward(request,response);
                //response.sendRedirect("pages/adminDashboard.jsp");
            } else if (obj instanceof FormateursModel) {
                session.setAttribute("id", ((FormateursModel) obj).getId());
                session.setAttribute("role","Formateur");
                request.getRequestDispatcher("pages/formateurDashboard.jsp").forward(request,response);
                //response.sendRedirect("pages/formateurDashboard.jsp");
            }else{
                session.setAttribute("id",((ApprenantsModel) obj).getId());
                session.setAttribute("role","Apprenant");
                request.getRequestDispatcher("pages/apprenantDashboard.jsp").forward(request,response);
                //response.sendRedirect("pages/apprenantDashboard.jsp");
            }

        }else {
            // Redirect to the login page
            RequestDispatcher s = request.getRequestDispatcher("login.jsp");
            s.forward(request,response);
        };




    }
}
