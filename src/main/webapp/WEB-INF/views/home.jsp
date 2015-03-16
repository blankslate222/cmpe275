<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<sf:form id="updDel" modelAttribute="homePage" action="/">
<table><tr>
<td>Id:</td><td><input name="id" type="text" size="10" value="${home.id}" readonly/></td></tr>
<tr><td>First Name:</td><td><input name="firstName" type="text" value="${home.firstname}" /></td></tr>
<tr><td>Last Name:</td><td><input name="lastName" type="text" value="${home.lastname}"/></td></tr>
<tr><td>Email:</td><td><input name="email" type="email" value="${home.email}"/></td></tr>
<tr><td>Address:</td><td><input name="address" type="text" value="${home.address}"/></td></tr>
<tr><td>Organization:</td><td><input name="org" type="text" value="${home.organization}"/></td></tr>
<tr><td>About Myself:</td><td><textarea name="about" cols="50" rows="5">
${home.aboutMyself}</textarea></td></tr>
<tr><td><input type="submit" id="delete" value="Delete" onclick="return submitform(this.id)"/></td> 
	<td><input type="submit" id="update" value="Update" onclick="return submitform(this.id)"/></td></tr>
</table>
</sf:form>

<script type="text/javascript">
function submitform(operation) {

	if(operation == 'delete')
	{ 
	
		var action = "";
		action+="/homepage/"+"${home.id}";
				
				document.getElementById('updDel').action= action;
				document.getElementById('updDel').method= "delete";
		
   	}
   	
   if(operation == 'update'){
		var action = "";
		action+="/homepage/"+"${home.id}";
		var method = "post";
		
		document.getElementById('updDel').action= action;
		document.getElementById('updDel').method= method;
		
   }
}
</script>
</body>
</html>