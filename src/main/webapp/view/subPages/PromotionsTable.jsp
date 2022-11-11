<%@ page import="java.util.List" %>
<%@ page import="com.example.simplon_clone_fb.Models.PromotionsModel" %>
<%@ page import="com.example.simplon_clone_fb.Models.FormateursModel" %><%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 11/9/2022
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration</title>
    <link rel="stylesheet" href="../../cssModules/index.css">
</head>
<body>

<jsp:include page="/viewComponents/adminComponenets/adminNav.jsp" />

<section class="flex justify-center mt-10">
    <%
        HttpSession session1 = request.getSession();
        List list = (List) session1.getAttribute("AdminData");
    %>
    <div class="w-[98%] rounded">
        <div class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded ">
            <div class="rounded-t mb-0 px-4 py-3 border-0">
                <div class="flex flex-wrap items-center">
                    <div class="relative w-full px-4 max-w-full flex-grow flex-1">
                        <h3 class="font-semibold text-base text-blueGray-700">Promotions Table</h3>
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
                            Name
                        </th>
                        <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                            Size
                        </th>

                        <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                            Modify
                        </th>
                        <th class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                        </th>
                    </tr>
                    </thead>

                    <tbody>

                    <% for (int i = 0;i<list.size();i++) {%>
                    <tr>
                        <th class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left text-blueGray-700 ">
                            <%= ((PromotionsModel) list.get(i)).getNom() %>
                        </th>
                        <td class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 ">
                            <%= ((PromotionsModel) list.get(i)).getSize() %>
                        </td>

                        <td class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                            <i class="fas fa-user-pen"></i>
                            <i class="fas fa-trash"></i>

                        </td>
                        <td id="<%=((PromotionsModel) list.get(i)).getId() %>" class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                            <button class="bg-gray-800 text-white active:bg-indigo-600 text-xs font-bold uppercase px-3 py-1 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button" id="assign_form_button">Assign</button>
                        </td>
                    </tr>
                    <% }%>
                    </tbody>

                </table>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../../viewComponents/forms/addPromotionForm.jsp"/>
<jsp:include page="../../viewComponents/forms/assignTeacherPromoForm.jsp" />
<script src="../../jsModules/events.js"></script>
</body>
</html>
