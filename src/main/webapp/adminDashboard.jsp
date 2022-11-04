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
</head>
<body>
 <a href="AdminServlet?field=apprenants">Access apprenants</a>
 <a href="AdminServlet?field=poromotions">Access Promotions</a>

     <%
         HttpSession session1 = request.getSession();
         List list = (List) session1.getAttribute("AdminData");
         if(list.get(0).getClass().equals(PromotionsModel.class)){
     %>
    <%= list.get(0) %>
     <%
      }else if(list.get(0).getClass().equals(FormateursModel.class)){
          for (int i = 0;i<list.size();i++) {%>
      <%= ((FormateursModel) list.get(i)).getEmail() %>
     <%};%>
     <%}else if(list.get(0).getClass().equals(ApprenantsModel.class)){
         for (int i = 0;i<list.size();i++) {%>
     <%= ((ApprenantsModel) list.get(i)).getEmail() %>
     <%}};%>

</body>
</html>
