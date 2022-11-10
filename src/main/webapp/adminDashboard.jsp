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

<jsp:include page="viewComponents/adminComponenets/adminNav.jsp" />

<section class="flex justify-center mt-10">
     <%
         HttpSession session1 = request.getSession();
         List list = (List) session1.getAttribute("AdminData");
         if(list.get(0).getClass().equals(PromotionsModel.class)){
     %>
    <%= list.get(0) %>
    <%
    }else{ %>

     <%};%>




</section>
<script src="../../jsModules/events.js"></script>
</body>

</html>
