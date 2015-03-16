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
<td>Id:</td><td><sf:input path="id" id="id" type="text" size="10" value="${id}" readonly/></td></tr>
<tr><td>First Name:</td><td><sf:input path="firstname" id="firstname" type="text" value="${firstname}" /></td></tr>
<tr><td>Last Name:</td><td><sf:input path="lastname" id="lastname" type="text" value="${lastname}"/></td></tr>
<tr><td>Email:</td><td><sf:input path="email" id="email" type="email" value="${email}"/></td></tr>
<tr><td>Address:</td><td><sf:input path="address" id="address" type="text" value="${address}"/></td></tr>
<tr><td>Organization:</td><td><sf:input path="organization" id="organization" type="text" value="${organization}"/></td></tr>
<tr><td>About Myself:</td><td><sf:textarea path="aboutMyself" id="aboutMyself" cols="50" rows="5">
${aboutMyself}</sf:textarea></td></tr>
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