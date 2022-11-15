<%@ page import="java.util.List" %>
<%@ page import="com.example.simplon_clone_fb.Models.PromotionsModel" %>
<%@ page import="com.example.simplon_clone_fb.Models.FormateursModel" %>
<%@ page import="com.example.simplon_clone_fb.Models.ApprenantsModel" %><%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 11/9/2022
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Teacher Space</title>
  <link rel="stylesheet" href="../../cssModules/index.css">
</head>
<body>

<jsp:include page="/viewComponents/TeacherComponenets/teacherNav.jsp" />

<section class="flex justify-center mt-10">
  <%
    HttpSession session1 = request.getSession();
    List list = (List) session1.getAttribute("TeacherData");
  %>
  <div class="w-[98%] rounded">
    <div class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded ">
      <div class="rounded-t mb-0 px-4 py-3 border-0">
        <div class="flex flex-wrap items-center">
          <div class="relative w-full px-4 max-w-full flex-grow flex-1">
            <h3 class="font-semibold text-base text-blueGray-700">Available Students Table</h3>
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
              Add to your promo
            </th>

          </tr>
          </thead>

          <tbody>

          <% for(int i = 0;i<list.size();i++) {%>
          <tr>
            <th class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left text-blueGray-700 ">
              <%= ((ApprenantsModel) list.get(i)).getNom() %>
            </th>
            <td class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 ">
              <%= ((ApprenantsModel) list.get(i)).getPrenom() %>
            </td>
            <td class="border-t-0 px-6 align-center border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
              <%= ((ApprenantsModel) list.get(i)).getEmail() %>
            </td>
            <td class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
              <form action="/TeacherServlet?field=apprenants&op=add" method="post">
                <input type="text" hidden name="promoid" value="<%=((ApprenantsModel) list.get(i)).getId()%>">
                <input type="submit" class="bg-gray-800 text-white active:bg-indigo-600 text-xs font-bold uppercase px-3 py-1 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" value="assign" id="assign_form_button" />
              </form>

            </td>
          </tr>
          <% }%>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</section>
</body>
</html>

