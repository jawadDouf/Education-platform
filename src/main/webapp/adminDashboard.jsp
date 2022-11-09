<%@ page import="java.util.List" %>
<%@ page import="Models.FormateursModel" %>
<%@ page import="Models.AdministrateurModel" %>
<%@ page import="Models.ApprenantsModel" %>
<%@ page import="Models.PromotionsModel" %><%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 11/2/2022
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>administration</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/styles/tailwind.css">
    <link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/styles/tailwind.css">
    <link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
</head>
<body>

<nav class="bg-white border-gray-200 sm:px-4 shadow-xl">
    <div class="container flex flex-row items-center gap-x-10 py-4">
        <div class="logo">
            <img src="Simplon_co.png" alt="simplon_logo" width="120" height="50"/>
        </div>
        <div class="hidden justify-between items-center w-full md:flex md:w-auto md:order-1" id="navbar-cta">
            <ul class="flex flex-col bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:text-sm md:bg-white ">
                <li>
                    <a href="#" class="block py-2 pr-4 pl-3 text-gray-700 bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 text-[18px]" aria-current="page">Formateurs</a>
                </li>
                <li>
                    <a href=AdminServlet?field=apprenants" class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-white dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700 text-[18px]">Apprenants</a>
                </li>
                <li>
                    <a href="AdminServlet?field=poromotions" class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-white dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700 text-[18px]">Promotions</a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<a href="AdminServlet?field=apprenants">Access apprenants</a>
 <a href="AdminServlet?field=poromotions">Access Promotions</a>
<section class="flex justify-center mt-10">
     <%
         HttpSession session1 = request.getSession();
         List list = (List) session1.getAttribute("AdminData");
         if(list.get(0).getClass().equals(PromotionsModel.class)){
     %>
    <%= list.get(0) %>
     <%
      }else{
          for (int i = 0;i<list.size();i++) {%>
    <div class="w-[98%] rounded">
        <div class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded ">
            <div class="rounded-t mb-0 px-4 py-3 border-0">
                <div class="flex flex-wrap items-center">
                    <div class="relative w-full px-4 max-w-full flex-grow flex-1">
                        <h3 class="font-semibold text-base text-blueGray-700">Users Table</h3>
                    </div>
                    <div class="relative w-full px-4 max-w-full flex-grow flex-1 text-right">
                        <button class="bg-indigo-500 text-white active:bg-indigo-600 text-xs font-bold uppercase px-3 py-1 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button" id="addingUserButton">Add New</button>
                    </div>
                </div>
            </div>
            <div class="block w-full overflow-x-auto">
                <table class="items-center bg-transparent w-full border-collapse ">
                    <thead>
                    <tr>
                        <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                            Nom
                        </th>
                        <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                            Prenom
                        </th>
                        <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                            Email
                        </th>
                        <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                            Promotion
                        </th>
                        <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                            Modify
                        </th>
                    </tr>
                    </thead>

                    <tbody>

                    <tr>
                        <th class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left text-blueGray-700 ">
                            <%= ((FormateursModel) list.get(i)).getNom() %>
                        </th>
                        <td class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 ">
                            <%= ((FormateursModel) list.get(i)).getPrenom() %>
                        </td>
                        <td class="border-t-0 px-6 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                            <%= ((FormateursModel) list.get(i)).getEmail() %>
                        </td>
                        <td class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                            -
                        </td>
                        <td class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                            <i class="fas fa-user-pen"></i>
                            <i class="fas fa-trash"></i>

                        </td>
                    </tr>
                    </tbody>

                </table>
            </div>
        </div>
    </div>
     <%}};%>
     <jsp:include page="viewComponents/forms/addTeacherForm.jsp"/>



</section>
<script src="../../jsModules/events.js"></script>
</body>

</html>
