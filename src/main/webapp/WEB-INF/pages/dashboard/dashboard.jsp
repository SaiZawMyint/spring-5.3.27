<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="my-[100px]">
  <h1 class="text-center text-xl my-10 font-bold">User List</h1>
  <div class="w-[80%] mx-auto grid grid-cols-2 md:grid-cols-3 gap-4">
    <c:forEach items="${usersList }" var="user">
      <div class="mr-1">
      <div
        class="w-full max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
        <div class="flex flex-col items-center pb-10 px-4 pt-8">
          <img class="w-24 h-24 mb-3 rounded-full shadow-lg"
            src="${pageContext.request.contextPath}/resources/images/user.png"
            alt="Bonnie image" />
          <h5
            class="mb-1 text-xl font-medium text-gray-900 dark:text-white">${user.name}</h5>
          <span class="text-sm text-gray-500 dark:text-gray-400">${user.email }</span>
          <div class="flex mt-4 space-x-3 md:mt-6">
            <a href="#"
              class="inline-flex items-center px-4 py-2 text-sm font-medium text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Edit</a> <a href="#"
              class="inline-flex items-center px-4 py-2 text-sm font-medium text-center text-gray-900 bg-white border border-gray-300 rounded-lg hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 dark:bg-gray-800 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-700 dark:focus:ring-gray-700">Delete</a>
          </div>
        </div>
      </div>
    </div>
</c:forEach>
  </div>
</div>