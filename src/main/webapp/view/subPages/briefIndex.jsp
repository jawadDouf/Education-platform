<%@ page import="com.example.simplon_clone_fb.Models.BriefsModel" %>
<%@ page import="static java.util.concurrent.TimeUnit.DAYS" %><%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 11/15/2022
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<jsp:include page="/viewComponents/TeacherComponenets/teacherNav.jsp" />
<div
        class="divide-y divide-gray-200 rounded-xl border border-gray-200 bg-white w-[90%] mx-auto mt-12 mb-4 shadow-lg">
    <%
        HttpSession session1 = request.getSession();
        BriefsModel brief = (BriefsModel) session1.getAttribute("TeacherData");
    %>
    <div
            class="divide-y divide-gray-500 rounded-xl border border-gray-200  bg-white p-6"
    >
        <img src="https://thumbnails.production.thenounproject.com/gA9eZOvsBYSHrMumgrslmRGoBto=/fit-in/1000x1000/photos.production.thenounproject.com/photos/BCBA88B6-5B41-4B50-A786-E60CAA0ECDA3.jpg" class="h-[500px] mx-auto w-auto"/>
    </div>
    <details class="group p-6" open>
        <summary class="flex cursor-pointer items-center justify-between">
            <h2 class="text-lg font-medium text-gray-900">
                <%= brief.getTitre() %>
            </h2>

            <span class="relative ml-1.5 h-5 w-5 flex-shrink-0">
        <svg
                xmlns="http://www.w3.org/2000/svg"
                class="absolute inset-0 h-5 w-5 opacity-100 group-open:opacity-0"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                stroke-width="2"
        >
          <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
          />
        </svg>

        <svg
                xmlns="http://www.w3.org/2000/svg"
                class="absolute inset-0 h-5 w-5 opacity-0 group-open:opacity-100"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                stroke-width="2"
        >
          <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M15 12H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
          />
        </svg>
      </span>
        </summary>

        <p class="mt-4 leading-relaxed text-gray-700">
            <%= brief.getSubTitle() %>
        </p>
    </details>

    <details class="group p-6">
        <summary class="flex cursor-pointer items-center justify-between">
            <h2 class="text-lg font-medium text-gray-900">
                Languages That you should use in this assignment
            </h2>

            <span class="relative ml-1.5 h-5 w-5 flex-shrink-0">
        <svg
                xmlns="http://www.w3.org/2000/svg"
                class="absolute inset-0 h-5 w-5 opacity-100 group-open:opacity-0"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                stroke-width="2"
        >
          <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
          />
        </svg>

        <svg
                xmlns="http://www.w3.org/2000/svg"
                class="absolute inset-0 h-5 w-5 opacity-0 group-open:opacity-100"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                stroke-width="2"
        >
          <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M15 12H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
          />
        </svg>
      </span>
        </summary>
        <p class="mt-4 leading-relaxed text-black">
            <% String[] languages = brief.getLanguages().split(" "); %>
            <%for (String language : languages) { %>
            <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2"><%= language %></span>
             <%} ;%>
        </p>
    </details>
    <details class="group p-6" open>
        <summary class="flex cursor-pointer items-center justify-between">
            <h2 class="text-lg font-medium text-gray-900">
                Assignment description
            </h2>

            <span class="relative ml-1.5 h-5 w-5 flex-shrink-0">
        <svg
                xmlns="http://www.w3.org/2000/svg"
                class="absolute inset-0 h-5 w-5 opacity-100 group-open:opacity-0"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                stroke-width="2"
        >
          <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
          />
        </svg>

        <svg
                xmlns="http://www.w3.org/2000/svg"
                class="absolute inset-0 h-5 w-5 opacity-0 group-open:opacity-100"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                stroke-width="2"
        >
          <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M15 12H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
          />
        </svg>
      </span>
        </summary>

        <p class="mt-4 leading-relaxed text-gray-700">
            <%= brief.getDescription() %>
        </p>
    </details>
    <details class="group p-6" open>
        <summary class="flex cursor-pointer items-center justify-between">
            <h2 class="text-lg font-medium text-gray-900">
                Start_Date And Deadline
            </h2>

            <span class="relative ml-1.5 h-5 w-5 flex-shrink-0">
        <svg
                xmlns="http://www.w3.org/2000/svg"
                class="absolute inset-0 h-5 w-5 opacity-100 group-open:opacity-0"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                stroke-width="2"
        >
          <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
          />
        </svg>

        <svg
                xmlns="http://www.w3.org/2000/svg"
                class="absolute inset-0 h-5 w-5 opacity-0 group-open:opacity-100"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                stroke-width="2"
        >
          <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M15 12H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
          />
        </svg>
      </span>
        </summary>
        <p class="mt-4 leading-relaxed text-gray-700">
         <p class="text-xl">Start Date : </p> <p class="text-lg text-[18px]"><%= brief.getDateDebut().toString() %></p>
           <p class="text-xl">Deadline : </p><p class="text-lg text-[18px]"><%= brief.getDateFin().toString() %></p>
        </p>
    </details>

</div>

</body>
</html>
