<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add currency</title>
</head>
<body>
	<form action="<%=application.getContextPath() %>/Controller?action=AddCurrency" method="post">
	<table>
	<tr><td>	Source_Currency:</td><td> <input type="text" name="source"/></td></tr>
	<tr><td>	Target_Currency:</td><td> <input type="text" name="target"/></td></tr>
	<tr><td>	Rate: </td><td><input type="text" name="rate"/></td>
		
		<tr><td><input type="submit" name="submit" value="Add Currency"></td></tr>
	</table>
	</form>
</body>
</html>