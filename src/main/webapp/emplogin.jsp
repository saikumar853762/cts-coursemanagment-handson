<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>
<body>
<header>
<h1>Employee Management System</h1>
</header>
<div class="main">

<h1 style="color:white">Employee Login</h1>
<div align="center">
<form:form action="elogin" method="post" modelAttribute="emplogin">

 <table>
  <tr>
  <td>User Name</td>
  
  <td><form:input path="username"/></td>
  </tr>
 <tr>
  <td>Password</td>
  
  <td><form:password path="password"/></td>
  </tr>
 
 
 <tr>
 <td colspan="2" align="center"><input type="submit" value="Login"></td>
 </tr>
 </table>


</form:form>


<span>New Employee? </span><a href="employeeregister">Register</a>

</div>
</div>
</body>
</html>