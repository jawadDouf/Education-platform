package com.example.simplon_clone_fb.Servlets;

import com.example.simplon_clone_fb.Models.ApprenantsModel;
import com.example.simplon_clone_fb.Models.FormateursModel;
import com.example.simplon_clone_fb.Models.PromotionsModel;
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
            response.sendRedirect("view/subPages/TeachersTable.jsp");
        }else if(request.getParameter("field").equals("apprenants")){
            List<ApprenantsModel> apprenants = new AdminServices().getAll("apprenants");
            session.setAttribute("AdminData",apprenants);
            response.sendRedirect("view/subPages/LearnersTable.jsp");
        }else if(request.getParameter("field").equals("promotions")){
            List<PromotionsModel> promotions = new AdminServices().getAll("promotions");
            session.setAttribute("AdminData",promotions);
            response.sendRedirect("view/subPages/PromotionsTable.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Services Classes that we going to use
        AdminServices adminServices = new AdminServices();
        //Initialise the session
        HttpSession session = request.getSession();
        //Logic
        if(request.getParameter("field").equalsIgnoreCase("formateurs")){

            if(request.getParameter("op").equalsIgnoreCase("read")){
                List<FormateursModel> formateurs = new AdminServices().getAll("formateurs");
                session.setAttribute("AdminData",formateurs);
                response.sendRedirect("view/subPages/TeachersTable.jsp");

            } else if (request.getParameter("op").equalsIgnoreCase("add")) {
                  adminServices.addUser(request.getParameter("field"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("email"),request.getParameter("password"));
                  request.getRequestDispatcher("AdminServlet?field=formateurs&op=read").forward(request,response);
            }else if (request.getParameter("op").equalsIgnoreCase("assign")) {
                String[] promotionData = request.getParameter("promotion").split(" ");
                adminServices.assignPromotion(promotionData[0],promotionData[1]+" " + promotionData[2],promotionData[3],promotionData[4]);
                request.getRequestDispatcher("AdminServlet?field=formateurs&op=read").forward(request,response);
            }

        }else if(request.getParameter("field").equalsIgnoreCase("apprenants")){
             if (request.getParameter("op").equalsIgnoreCase("add")) {
                adminServices.addUser(request.getParameter("field"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("email"),request.getParameter("password"));
                request.getRequestDispatcher("AdminServlet?field=apprenants&op=read").forward(request,response);
            }
        }else if(request.getParameter("field").equalsIgnoreCase("promotions")){
            if (request.getParameter("op").equalsIgnoreCase("add")) {
                System.out.println("AdminServlet.doPost");
                if (adminServices.addPromotion(request.getParameter("name"),request.getParameter("size"))) {
                    request.getRequestDispatcher("AdminServlet?field=promotions&op=read").forward(request,response);
                }else{
                    request.getRequestDispatcher("AdminServlet?field=promotions&op=read").forward(request,response);
                }
            }else if (request.getParameter("op").equalsIgnoreCase("assign")) {
                String[] promotionData = request.getParameter("promotion").split(" ");
                adminServices.assignPromotion(promotionData[0],promotionData[1],promotionData[2],promotionData[3]);
                request.getRequestDispatcher("AdminServlet?field=promotions&op=read").forward(request,response);
            }
        }

    }
}
