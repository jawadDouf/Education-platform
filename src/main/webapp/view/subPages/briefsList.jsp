<%@ page import="java.util.List" %>
<%@ page import="com.example.simplon_clone_fb.Models.FormateursModel" %>
<%@ page import="com.example.simplon_clone_fb.Models.BriefsModel" %><%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 11/15/2022
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students Space</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<jsp:include page="/viewComponents/StudentComponenets/studentNav.jsp" />

<%
    HttpSession session1 = request.getSession();
    List list = (List) session1.getAttribute("StudentData");
    FormateursModel formateursModel =(FormateursModel) session1.getAttribute("StudentData2");
%>



<div class="p-10 grid grid-cols-3 gap-5">
    <% for (int i = 0; i < list.size(); i++) {
    //Skip unsigned assignments
        if(((BriefsModel) list.get(i)).isStatus() == false) continue;
    %>

    <a href="/StudentServlet?field=briefs&op=readOne&id=<%=((BriefsModel) list.get(i)).getId()%>" >
    <div class="rounded overflow-hidden shadow-lg hover:bg-blue-500 cursor-pointer">
     <div class="px-6 py-4">
      <div class="font-bold text-xl mb-2"><%= ((BriefsModel) list.get(i)).getTitre() %>
      </div>
      <p class="text-gray-700 text-base">
          <%= ((BriefsModel) list.get(i)).getSubTitle() %>
      </p>
    </div>
    <div class="px-6 pt-4 pb-2">
        <% String[] languages = ((BriefsModel) list.get(i)).getLanguages().split(" "); %>
        <%for (String language : languages) { %>
        <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"><%= language %></span>
        <%};%>
    </div>
        <div class="mt-5 ml-5 mb-5">
            <p class="font-medium text-lg "><%= formateursModel.getPrenom()%> <%= formateursModel.getNom()%></p>
            <p class="text-[12px]">assigned by your teacher</p>
        </div>
  </div>
</a>
    <%};%>
</div>
</div>

</body>
</html>
