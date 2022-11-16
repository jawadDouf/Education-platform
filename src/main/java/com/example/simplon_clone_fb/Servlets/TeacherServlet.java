package com.example.simplon_clone_fb.Servlets;

import com.example.simplon_clone_fb.Models.ApprenantsModel;
import com.example.simplon_clone_fb.Models.BriefsModel;
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

        HttpSession session = request.getSession();
        if (request.getParameter("type").equals("withoutpromo")) {
            List<ApprenantsModel> apprenats = new TeacherServices().getAllStudentsWithoutPromotion();
            session.setAttribute("TeacherData", apprenats);
            response.sendRedirect("view/subPages/NoTeachersLearnersTable.jsp");
        } else if (request.getParameter("type").equals("withpromo")) {
            int id = (Integer) session.getAttribute("id");
            List<ApprenantsModel> apprenants = new TeacherServices().getAllTeacherStudents("2022-2021", id);
            session.setAttribute("TeacherData", apprenants);
            response.sendRedirect("view/subPages/TeachersLearnersTable.jsp");
        } else if (request.getParameter("field").equalsIgnoreCase("briefs")) {
            if (request.getParameter("op").equalsIgnoreCase("read")) {
                int id = (Integer) session.getAttribute("id");
                List<BriefsModel> briefs = new TeacherServices().getAllBriefs(id);
                session.setAttribute("TeacherData", briefs);
                response.sendRedirect("view/subPages/briefsTable.jsp");
            } else if (request.getParameter("op").equalsIgnoreCase("delete")) {
                System.out.println(request.getParameter("id"));
                new TeacherServices().deleteAssignment(request.getParameter("id"));
                response.sendRedirect("TeacherServlet?field=briefs&type=s&op=read");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TeacherServlet.doPost");
        //Initialise the teacher services
        TeacherServices teacher = new TeacherServices();
         //Initialise the session
        HttpSession session = request.getSession();
        //redirect the user
        if(request.getParameter("field").equalsIgnoreCase("apprenants")){
            if(request.getParameter("op").equalsIgnoreCase("read")){
                if(request.getParameter("type").equalsIgnoreCase("withpromo")){
                    System.out.println("TeacherServlet.doPost");
                    System.out.println("id is : " + session.getAttribute("id"));
                    int id = (Integer) session.getAttribute("id");
                    List<ApprenantsModel> apprenants = teacher.getAllTeacherStudents("2022-2021",id);
                    session.setAttribute("TeacherData",apprenants);
                    response.sendRedirect("view/subPages/TeachersLearnersTable.jsp");
                }else if(request.getParameter("op").equalsIgnoreCase("add")) {
                int id = (Integer) session.getAttribute("id");
                teacher.addStudentToPromo(request.getParameter("promoid"), id);
                response.sendRedirect("TeacherServlet?field=apprenants&type=withpromo&op=read");
            }
        }
         }else if (request.getParameter("field").equalsIgnoreCase("briefs")) {
                System.out.println("TeacherServlet.doPost");
                 if(request.getParameter("op").equalsIgnoreCase("add")){
                     System.out.println("TeacherServlet.doPost");
                        int id = (Integer) session.getAttribute("id");
                        System.out.println("TeacherServlet.doPost");
                        teacher.createAssignment(request.getParameter("title"),request.getParameter("subTitle"),request.getParameter("languages"),request.getParameter("description"),request.getParameter("startDate"),request.getParameter("deadline"),id);
                        response.sendRedirect("TeacherServlet?field=briefs&type=s&op=read");
                    }else if(request.getParameter("op").equalsIgnoreCase("assign")){
                        System.out.println("TeacherServlet.doPost");
                        int id = (Integer) session.getAttribute("id");
                        teacher.assignBriefToStudent(request.getParameter("briefId"),id);
                        response.sendRedirect("TeacherServlet?field=briefs&type=s&op=read");
                    } else if (request.getParameter("op").equalsIgnoreCase("readOne")) {
                     System.out.println("TeacherServlet.doPost2");
                     session.setAttribute("TeacherData", new TeacherServices().getOneAssignment(request.getParameter("id")));
                     response.sendRedirect("view/subPages/briefIndex.jsp");
                 } else if (request.getParameter("op").equalsIgnoreCase("edit")) {
                     int id = (Integer) session.getAttribute("id");
                     System.out.println("TeacherServlet.doPost");
                     teacher.updateAssignment(request.getParameter("title"),request.getParameter("subTitle"),request.getParameter("languages"),request.getParameter("description"),request.getParameter("startDate"),request.getParameter("deadline"),id,request.getParameter("assignmentId"));
                     response.sendRedirect("TeacherServlet?field=briefs&type=s&op=read");
                 }
        }
                }
   }


