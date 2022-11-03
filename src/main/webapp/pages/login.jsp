<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 11/2/2022
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="bg-gradient-to-r from-blue-700 via-blue-800 to-gray-900 h-screen w-screen">
    <div class="flex flex-col items-center flex-1 h-full justify-center px-4 sm:px-0">
        <div class="flex rounded-lg shadow-lg  sm:w-3/4 lg:w-1/3 bg-white sm:mx-0" style="height: 500px">
            <form class="flex flex-col items-center flex-1 h-full justify-center" action="LoginServlet" method="post">
                <div class="text-center">
                    <h2 class="mt-6 text-3xl font-bold text-gray-900">
                        Welcome Back!
                    </h2>
                    <p class="mt-2 text-sm text-gray-500">Please sign in to your account</p>
                </div>
                <input type="hidden" name="remember" value="true">
                <div class="relative w-[80%]">
                    <div class="absolute right-3 mt-4"><svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 text-green-500" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                    </svg>
                    </div>
                    <label class="ml-3 text-sm font-bold text-gray-700 tracking-wide">Email</label>
                    <input class="w-full text-base px-4 py-2 border-b border-gray-300 focus:outline-none rounded-2xl focus:border-indigo-500" type="" name="email">
                </div>
                <div class="mt-8 content-center w-[80%]">
                    <label class="ml-3 text-sm font-bold text-gray-700 tracking-wide">
                        Password
                    </label>
                    <input class="w-full content-center text-base px-4 py-2 border-b rounded-2xl border-gray-300 focus:outline-none focus:border-indigo-500" type="" placeholder="Enter your password" name="password">
                </div>
                <div class="flex items-center justify-between w-[75%] mt-5">
                    <div class="flex items-center">
                        <input id="remember_me" name="remember_me" type="checkbox" class="h-4 w-4 bg-blue-500 focus:ring-blue-400 border-gray-300 rounded">
                        <label for="remember_me" class="ml-2 block text-sm text-gray-900">
                            Remember me
                        </label>
                    </div>
                    <div class="text-sm">
                        <a href="#" class="text-indigo-400 hover:text-blue-500">
                            Forgot your password?
                        </a>
                    </div>
                </div>
                <div class="w-[80%] mt-5">
                    <input type="submit" class="w-full flex justify-center bg-gradient-to-r from-indigo-500 to-blue-600  hover:bg-gradient-to-l hover:from-blue-500 hover:to-indigo-600 text-gray-100 p-3  rounded-full  font-semibold  shadow-lg cursor-pointer transition ease-in duration-500">


                </div>
                <p class="flex flex-col items-center justify-center mt-10 text-center text-md text-gray-500">
                    <span> Before entering to your account !!</span>
                <p  class="text-indigo-400 hover:text-blue-500 no-underline hover:underline cursor-pointer transition ease-in duration-300">Some Quote
                </p>
                </p>

            </form>

        </div>
    </div>
</div>
</body>
</html>
