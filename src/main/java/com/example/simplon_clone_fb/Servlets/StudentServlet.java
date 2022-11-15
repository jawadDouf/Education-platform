package com.example.simplon_clone_fb.Servlets;

import com.example.simplon_clone_fb.Models.BriefsModel;
import com.example.simplon_clone_fb.Models.FormateursModel;
import com.example.simplon_clone_fb.Services.StudentServices;
import com.example.simplon_clone_fb.Services.TeacherServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         HttpSession session = request.getSession();
        if (request.getParameter("field").equalsIgnoreCase("briefs")){
            if(request.getParameter("op").equalsIgnoreCase("readOne")){
                session.setAttribute("TeacherData", new TeacherServices().getOneAssignment(request.getParameter("id")));
                response.sendRedirect("view/subPages/briefIndex.jsp");
            } else if (request.getParameter("op").equalsIgnoreCase("read")) {
                //get the session attribute
                int id = (Integer) session.getAttribute("id");
                //get all the assignments of the student
                List<BriefsModel> briefs = new StudentServices().getAllBriefs(id);
                //get the teacher of the student
                FormateursModel formateur = new StudentServices().getTeacherOfStudent(briefs.get(0).getPromoId());
                //send the data to the student home page
                session.setAttribute("StudentData", briefs);
                session.setAttribute("StudentData2", formateur);
                //redirect the user
                response.sendRedirect("view/subPages/briefsList.jsp");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("field").equalsIgnoreCase("briefs")) {
            if (request.getParameter("op").equalsIgnoreCase("read")) {
                //get the session attribute
                int id = (Integer) session.getAttribute("id");
                //get all the assignments of the student
                List<BriefsModel> briefs = new StudentServices().getAllBriefs(id);
                //get the teacher of the student
                FormateursModel formateur = new StudentServices().getTeacherOfStudent(briefs.get(0).getPromoId());
                //send the data to the student home page
                session.setAttribute("StudentData", briefs);
                session.setAttribute("StudentData2", formateur);
                //redirect the user
                response.sendRedirect("view/subPages/briefsList.jsp");
            }
        }

    }
}
