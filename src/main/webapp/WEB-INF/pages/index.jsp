<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Index page</title>
</head>
<body>
    <h1>This is index page.</h1>
    <h2>App Version -
        <c:out value="${appVersion}" />
    </h2>
    <p>The sum of 1 and 2 is :
        <c:out value="${result}" />
    </p>
</body>
</html>