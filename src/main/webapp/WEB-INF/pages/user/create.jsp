<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="w-[500px] mx-auto mt-[100px]">
  <form:form method="POST"
    class="bg-gray-200 shadow-md rounded px-8 pt-6 pb-8 mb-4 text-gray-700 bg-gray-200 dark:bg-gray-800 dark:text-gray-400"
    modelAttribute="userForm">
    <div class="mb-4 text-gray-700 dark:text-gray-400">Create User</div>
    <div class="mb-4">
      <form:label path="name"
        class="block text-gray-700 dark:text-gray-400 text-sm font-bold mb-2"
        for="username"> Username </form:label>
      <form:input path="name"
        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        id="username" type="text" placeholder="Username" />
      <form:errors path="name" class="text-red-500 text-xs italic" />
    </div>
    <div class="mb-4">
      <form:label path="email"
        class="block text-gray-700 dark:text-gray-400 text-sm font-bold mb-2"
        for="username"> Email </form:label>
      <form:input path="email"
        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        id="email" type="email" placeholder="Email" />
      <form:errors path="name" class="text-red-500 text-xs italic" />
    </div>
    <div class="mb-6">
      <form:label path="password"
        class="block text-gray-700 dark:text-gray-400 text-sm font-bold mb-2"
        for="password"> Password </form:label>
      <form:input path="password"
        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
        placeholder="password" />
      <form:errors path="password" class="text-red-500 text-xs italic" />
    </div>
    <div class="mb-6">
      <label
        class="block text-gray-700 dark:text-gray-400 text-sm font-bold mb-2">Role</label>
      <select name="roles"
        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline">
        <option value="" selected="selected">Select Role</option>
        <c:forEach items="${roles }" var="role">
          <option value=${role.id }>${role.name }</option>
        </c:forEach>
      </select>
      <form:errors path="roles" class="text-red-500 text-xs italic" />
    </div>
    <div class="flex items-center justify-between">
      <a href="${pageContext.request.contextPath }/user/">Back</a>
      <button
        class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
        type="submit">Create</button>
    </div>
  </form:form>
</div>