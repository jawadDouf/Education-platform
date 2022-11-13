package com.example.simplon_clone_fb.Servlets;

import com.example.simplon_clone_fb.Models.ApprenantsModel;
import com.example.simplon_clone_fb.Services.TeacherServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "TeacherServlet", value = "/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Initialise the teacher services
        TeacherServices teacher = new TeacherServices();
         //Initialise the session
        HttpSession session = request.getSession();
        //redirect the user
        if(request.getParameter("field").equalsIgnoreCase("apprenants")){
            if(request.getParameter("op").equalsIgnoreCase("read")){
                if(request.getParameter("type").equalsIgnoreCase("withpromo")){
                    System.out.println("TeacherServlet.doPost");
                    List<ApprenantsModel> apprenats = teacher.getAllTeacherStudents("2022-2021",session.getId());
                    session.setAttribute("TeacherData",apprenats);
                    response.sendRedirect("view/subPages/TeachersLearnersTable.jsp");
                } else if (request.getParameter("type").equalsIgnoreCase("withoutpromo")) {
                    List<ApprenantsModel> apprenats = teacher.getAllStudentsWithoutPromotion();
                    session.setAttribute("TeacherData",apprenats);
                    response.sendRedirect("view/subPages/NoTeachersLearnersTable.jsp");
                }
            }else if(request.getParameter("op").equalsIgnoreCase("add")){
              //  teacher.addStudentToPromo(request.getParameter("id"),request.getParameter("promo"));
                //response.sendRedirect("TeacherServlet?field=apprenants&type=withpromo&op=read");
        } else if (request.getParameter("field").equalsIgnoreCase("briefs")) {

        }
    }
}}
