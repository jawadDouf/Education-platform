package com.example.simplon_clone_fb.Servlets;

import Models.AdministrateurModel;
import Models.ApprenantsModel;
import Models.FormateursModel;
import Models.PromotionsModel;
import com.example.simplon_clone_fb.Services.AdminServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("in admin servlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(request.getParameter("field").equals("formateurs")){
            List<FormateursModel> formateurs = new AdminServices().getAll("formateurs");
            session.setAttribute("AdminData",formateurs);
            response.sendRedirect("adminDashboard.jsp");
        }else if(request.getParameter("field").equals("apprenants")){
            List<ApprenantsModel> apprenants = new AdminServices().getAll("apprenants");
            session.setAttribute("AdminData",apprenants);
            response.sendRedirect("adminDashboard.jsp");
        }else{
            List< PromotionsModel> promotions = new AdminServices().getAll("promotions");
            session.setAttribute("AdminData",promotions);
            response.sendRedirect("adminDashboard.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<FormateursModel> formateurs = new AdminServices().getAll("formateurs");
        session.setAttribute("AdminData",formateurs);
        response.sendRedirect("adminDashboard.jsp");
    }
}
