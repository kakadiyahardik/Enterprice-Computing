<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
  </div>
</nav>

	<div class="container">
	
	<h4>Edit Item</h4>

	<form action="<%= application.getContextPath() %>/ItemController?action=updatecart" method="post">
    <table class="table" border="1">
    	
    	<tr><td>description</td><td><input type="text" name ="des"  value="${edititem.des }" readonly="readonly" /></td></tr>
        <tr><td>Stock</td><td><input type="text" name="qty" value="${edititem.qty }"/></td></tr>
        <tr><td>Min_Stock</td><td><input type="text" name="rate" value="${edititem.rate }" readonly="readonly"/></td></tr>
        
      	<input type="hidden" name="icode" value="${edititem.item_code }" />
        <tr><td colspan="2" align="center"><input class="btn btn-success" type="submit" name="update" value="update" /></td></tr>
        
    </table>
    </form>
</div>
</body>
</html>