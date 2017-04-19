<%@page import="org.apache.catalina.core.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
</head>
<body>

<h4>Welcome</h4>

	<form action="<%=application.getContextPath() %>/Controller?action=convert" method="post">
		<table>
		<tr><td>Source_Currency:</td><td> <input type="text" name="source"/></td></tr>
		<tr><td>Target_Currency: </td><td><input type="text" name="target"/></td></tr>
		<tr><td>Amount: </td><td><input type="text" name="amt"/></td></tr>
		<tr><td>
		<input type="submit" name="submit" value="Convert"><td/></tr>
	</table>
	</form>
	
	
 	<a href="add.jsp"><button>Add Currency Rate</button></a>
</body>
</html>