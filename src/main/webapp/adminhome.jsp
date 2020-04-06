<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMS- Admin Home</title>
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>
<body>
<header>
<h1>Welcome ${admin }</h1>

</header>

<div class="main">

<ul>
<li><a href="listEmployee">List Employees</a></li>
<li><a href="alogout">|Logout</a></li>
</ul>
</div>


<div>
<table border="2">

<c:forEach items="${empList}" var="emp">
   
   <tr>
   <td>${emp.username}</td>
   <td> <c:out value="${emp}" /></td>
   </tr>
</c:forEach>

</table>

</div>
</body>
</html>