<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>


<header>
<h1>Employee Management System</h1>
</header>
<div class="main">
<h1 style="color:white">Employee Register</h1>
<div align="center">
<form:form action="addEmployee" method="post" modelAttribute="emp">

 <table>
  <tr>
  <td>User Name</td>
  
  <td><form:input path="username"/>
  <br>
  <form:errors path="username"></form:errors>
  
  </td>
  </tr>
  <tr>
  <td>First Name</td>
  
  <td><form:input path="firstname"/></td>
  </tr>
  <tr>
  <td>Last Name</td>
  
  <td><form:input path="lastname"/></td>
  </tr>
  
  <tr>
  <td>Password</td>
  
  <td><form:password path="password"/></td>
  </tr>
  <tr>
  <td>Email</td>
  
  <td><form:input path="email"/>
  <br>
  <form:errors path="email"></form:errors>
  </td>
  </tr>
  
  <tr>
  <td>Mobile</td>
  
  <td><form:input path="mobile"/>
    <br>
    <form:errors path="mobile"></form:errors>
  
  </td>
  </tr>
 
 
 
 <tr>
 <td colspan="2" align="center"><input type="submit" value="Register"></td>
 </tr>
 </table>


</form:form>


<span>Existing Employee? </span><a href="employeelogin">Login</a>

</div>
</div>

</body>
</html>