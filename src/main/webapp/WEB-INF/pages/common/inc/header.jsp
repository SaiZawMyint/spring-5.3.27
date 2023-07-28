<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header
  class="w-full py-4 fixed top-0 left-0 bg-gray-300 dark:bg-gray-800 dark:text-white">
  <div
    class="flex mx-auto w-[80%] justify-between items-center dark:text-white">
    <h1>${AppTitle}</h1>
    <nav class="flex items-center">
      <a href="#" class="mx-1 block">Dashboard</a> <a
        href="${pageContext.request.contextPath }/logout" class="mx-1 block">Logout</a>
    </nav>
  </div>
</header>