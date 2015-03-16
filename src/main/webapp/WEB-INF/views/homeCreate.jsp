<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage | Create</title>
</head>
<body>
<sf:form id="create" modelAttribute="homePage" action="${pageContext.request.contextPath}/homepage" method="post">
<table><tr>
<td>Id:</td><td><sf:input path="id" id="id" type="text" size="10"/></td></tr>
<tr><td>First Name:</td><td><sf:input path="firstname" id="firstname" type="text"/></td></tr>
<tr><td>Last Name:</td><td><sf:input path="lastname" id="lastname" type="text"/></td></tr>
<tr><td>Email:</td><td><sf:input path="email" id="email" type="email" /></td></tr>
<tr><td>Address:</td><td><sf:input path="address" id="address" type="text"/></td></tr>
<tr><td>Organization:</td><td><sf:input path="organization" id="organization" type="text"/></td></tr>
<tr><td>About Myself:</td><td><sf:textarea path="aboutMyself" id="aboutMyself" cols="50" rows="5"></sf:textarea></td></tr>
<tr><td><input type="submit" id="create" value="Create"/></td></tr>
</table>
</sf:form>
</body>
</html>