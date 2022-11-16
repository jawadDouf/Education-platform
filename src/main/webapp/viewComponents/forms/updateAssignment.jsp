<%@ page import="com.example.simplon_clone_fb.Models.BriefsModel" %>
<%@ page import="com.example.simplon_clone_fb.Services.TeacherServices" %><%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 11/14/2022
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher Space</title>
</head>
<body>
<jsp:include page="/viewComponents/TeacherComponenets/teacherNav.jsp" />
<%
    BriefsModel briefModel = new TeacherServices().getOneAssignment(request.getParameter("id"));
%>
<div class="container w-full mx-auto mt-6">
    <div class="bg-white rounded shadow-lg md:p-8 mb-6">
        <div class="grid gap-4 gap-y-2 text-sm grid-cols-3">
            <div class="text-gray-600">
                <p class="font-bold text-xl">Create a new assignment</p>
            </div>
            <div class="lg:col-span-2">
                <form action="/TeacherServlet?field=briefs&type=updationg&op=edit" method="post" >


                    <h1 class="font-bold text-xl">Enter the informations</h1>
                    <div class="grid gap-4 gap-y-2 text-sm grid-cols-1 md:grid-cols-5">
                        <div class="md:col-span-5">
                            <label for="title">Assignment Title</label>
                            <input class="w-full bg-gray-100 text-gray-900 mt-2 p-2 rounded-lg focus:outline-none focus:shadow-outline"
                                   type="text" placeholder="Assignment Title"
                                   name="title"
                                   value="<%=briefModel.getTitre()%>">
                            />
                        </div>

                        <div class="md:col-span-5">
                            <label for="subTitle">Assignment Sub Title</label>
                            <input class="w-full bg-gray-100 text-gray-900 mt-2 p-2 rounded-lg focus:outline-none focus:shadow-outline"
                                   type="text" placeholder="Sub title"
                                   name="subTitle"
                                   value="<%=briefModel.getSubTitle()%>"/>
                        </div>


                        <div class="md:col-span-3">
                            <label for="startDate">Start Date</label>
                            <input class="w-full bg-gray-100 text-gray-900 mt-2 p-2 rounded-lg focus:outline-none focus:shadow-outline"
                                   type="date" placeholder="Start Date" name="startDate"
                                    value="<%=briefModel.getDateDebut()%>"/>
                            />
                        </div>

                        <div class="md:col-span-2">
                            <label for="deadline">End Date(Deadline)</label>
                            <input class="w-full bg-gray-100 text-gray-900 mt-2 p-2 rounded-lg focus:outline-none focus:shadow-outline"
                                   type="date" placeholder="End Date"
                                   name="deadline"
                                   value="<%=briefModel.getDateFin()%>"/>
                        </div>

                        <div class="md:col-span-5" id="languages_container">
                            <label for="languages">Languages of the assignment</label>
                            <input class="w-full bg-gray-100 text-gray-900 mt-2 p-2 rounded-lg"
                                   type="text" placeholder="Languages" id="languages"/>
                            <input type="text" hidden id="invisible_language_input" name="languages" value="<%= briefModel.getLanguages() %>"/>
                            <input type="text" hidden  name="assignmentId" value="<%= briefModel.getId() %>"/>
                        </div>
                        <div class="md:col-span-5">
                            <label for="description">Description of the assignment</label>
                            <div class="md:col-span-5">
                                           <textarea placeholder="Description of the Assignment" class="w-full h-32 bg-gray-100 text-gray-900 mt-2 p-3 rounded-lg focus:outline-none focus:shadow-outline"
                                                     name="description"
                                                     value="<%=briefModel.getDescription()%>"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="md:col-span-4 text-right">
                        <div class="inline-flex items-end">
                            <input type="submit" value="Update assignment" class="w-full mt-5 flex justify-center bg-gradient-to-r from-indigo-500 to-blue-600  hover:bg-gradient-to-l hover:from-blue-500 hover:to-indigo-600 text-gray-100 p-3  rounded-full  font-semibold  shadow-lg cursor-pointer transition ease-in duration-500">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>





<script src="../../jsModules/createAssignment.js"></script>
</body>
</html>
