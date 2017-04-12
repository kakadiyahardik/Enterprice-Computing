
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.User"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="main.css">
        <title>Cart</title>
          <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
    </head>
<body>
<%User user=(User)request.getSession().getAttribute("user"); %>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><%=user.getName() %></a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="<%= application.getContextPath() %>/ItemController?action=home">Home</a></li>
      <li class="active"><a href="<%= application.getContextPath() %>/ItemController?action=gotocart">Cart</a></li>
      
    </ul>
  </div>
</nav>
<div class="container">
        <h3>Inventory</h3>
        
        
	<table class="table" border="1">
	<tr><th>Description</th><th>Qty</th><th>Rate</th><th>Action</th></tr>
		<c:forEach items="${cart}" var="item">
	    <tr>
	    	
			<td><c:out value="${item.des }"/> </td>
			<td><c:out value="${item.qty }"/> </td>
			<td><c:out value="${item.rate }"/> </td>
			<td><a href="<%= application.getContextPath() %>/ItemController?action=editcart&icode=${item.cartid}"><button class="btn btn-success" > Edit </button></a>
            	<a href="<%= application.getContextPath() %>/ItemController?action=deletecart&icode=${item.cartid}"><button class="btn btn-danger" > Remove </button></a>
            </td>
		</tr>
	</c:forEach>
	</table>
	
	<a href="<%= application.getContextPath() %>/ItemController?action=saveToCart"><button class="btn btn-success" > Save Cart </button></a>
	</div>
</body>
</html>