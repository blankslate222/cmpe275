<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage | Create</title>
</head>
<body>
<form id="create" action="/homepage" method="post">
<table><tr>
<td>Id:</td><td><input name="id" type="text" size="10"/></td></tr>
<tr><td>First Name:</td><td><input name="firstName" type="text"/></td></tr>
<tr><td>Last Name:</td><td><input name="lastName" type="text"/></td></tr>
<tr><td>Email:</td><td><input name="email" type="email"/></td></tr>
<tr><td>Address:</td><td><input name="address" type="text"/></td></tr>
<tr><td>Organization:</td><td><input name="org" type="text"/></td></tr>
<tr><td>About Myself:</td><td><textarea name="about" cols="50" rows="5"></textarea></td></tr>
<tr><td><input type="submit"  id="create" value="Create"/></td></tr>
</table>
</form>
</body>
</html>