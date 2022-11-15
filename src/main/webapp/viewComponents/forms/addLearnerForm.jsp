<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 11/9/2022
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="../../cssModules/index.css">
</head>
<body>
<div id="overlay" class="bg-[#808080] w-full h-screen absolute cursor-pointer top-0"></div>
<div id="form_container" class="absolute top-1/4 left-1/3 transform -translate-x-1/3 -translate-y-1/4 mx-auto max-w-md px-6 py-12 bg-white border-0 shadow-lg sm:rounded-3xl z-20">
  <h1 class="text-2xl text-center font-bold mb-8">Create new learner</h1>
  <form id="form" action="/AdminServlet?field=apprenants&op=add" method="post" class="">
    <div class="flex flex-row space-x-4">
      <div class="relative z-0 w-full mb-5">
        <input
                type="text"
                name="nom"
                placeholder="Enter student last name"
                class="w-full text-base px-4 py-2 border-b border-gray-300 focus:outline-none rounded-2xl focus:border-indigo-500"
        />

        <span class="text-sm text-red-600 hidden">Date is required</span>
      </div>
      <div class="relative z-0 w-full">
        <input
                type="text"
                name="prenom"
                placeholder="Enter student first name"
                class="w-full text-base px-4 py-2 border-b border-gray-300 focus:outline-none rounded-2xl focus:border-indigo-500"
        />

        <span class="text-sm text-red-600 hidden" id="error">Time is required</span>
      </div>
    </div>
    <div class="relative z-0 w-full mb-5">
      <input
              type="email"
              name="email"
              placeholder="Enter student email adress"
              class="w-full text-base px-4 py-2 border-b border-gray-300 focus:outline-none rounded-2xl focus:border-indigo-500"
      />

      <span class="text-sm text-red-600 hidden" id="error"></span>
    </div>

    <div class="relative z-0 w-full mb-5">
      <input
              type="password"
              name="password"
              placeholder="Enter password"
              class="w-full text-base px-4 py-2 border-b border-gray-300 focus:outline-none rounded-2xl focus:border-indigo-500"
      />

      <span class="text-sm text-red-600 hidden" >Password is required</span>
    </div>
    <div class="relative z-0 w-full mb-5">
      <input
              type="password"
              name="confirm_password"
              placeholder="confirm password"
              class="w-full text-base px-4 py-2 border-b border-gray-300 focus:outline-none rounded-2xl focus:border-indigo-500"
      />
      <span class="text-sm text-red-600 hidden" >Password is required</span>
    </div>
    <input
            type="submit"
            class="w-full flex justify-center bg-gradient-to-r from-indigo-500 to-blue-600  hover:bg-gradient-to-l hover:from-blue-500 hover:to-indigo-600 text-gray-100 p-3  rounded-full  font-semibold  shadow-lg cursor-pointer transition ease-in duration-500"
    />


  </form>
</div>

<script src="../../jsModules/events.js"></script>
</body>
</html>

