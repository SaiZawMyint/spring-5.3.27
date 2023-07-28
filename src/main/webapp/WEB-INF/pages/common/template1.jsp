<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${AppTitle }| <tiles:getAsString name="title" /></title>
<script src="https://cdn.tailwindcss.com"></script>
<style>
.clearfix::after {
  content: "";
  display: block;
  clear: both;
}
</style>
</head>
<body class="bg-gray-200 dark:bg-gray-700 dark:text-gray-400">
  <tiles:insertAttribute name="header" />

  <section class="body max-w-[80%] mx-auto">
    <tiles:insertAttribute name="body" />
  </section>

  <c:if test="${sessionMessage != null }">
    <div
      class="fixed bottom-[20px] right-[20px] p-2 rounded-lg shadow text-gray-700 bg-gray-200 dark:bg-gray-800 dark:text-gray-400 flex items-center justify-between">
      <span class="pl-2">${sessionMessage }</span>
      <button
        class="ml-2 close-noti w-8 h-8 flex items-center justify-center bg-gray-400/50 rounded-full">
        <img alt="logout" class="w-4 h-4"
          src="${pageContext.request.contextPath }/resources/images/close-icon.svg">
      </button>
    </div>
    <c:remove var="sessionMessage" />
  </c:if>
  <script>
    var closeBtns = document.getElementsByClassName('close-noti');
    for(let btn of closeBtns){
      btn.addEventListener('click', function(){
        this.parentElement.remove()
      });
    }
  </script>
</body>
</html>