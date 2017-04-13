
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.User"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="main.css">
        <title>Home</title>
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
      <li class="active"><a href="<%= application.getContextPath() %>/ItemController?action=home">Home</a></li>
      <li ><a href="<%= application.getContextPath() %>/ItemController?action=gotocart">Cart</a></li>
      <li ><a href="<%= application.getContextPath() %>/ItemController?action=movetoorder">Order</a></li>
      
    </ul>
  </div>
</nav>
<div class="container">
        <h3>Inventory</h3>
        
	<table class="table" border="1">
	<tr><th>Description</th><th>Stock</th><th>Cost</th><th>Category</th><th>Qty</th><th>Action</th></tr>
		<c:forEach items="${stock}" var="item">
	    <tr>
	    	<td><c:out value="${item.description }"/> </td>
			<td><c:out value="${item.stock }"/> </td>
			<td><c:out value="${item.cost }"/> </td>
			<td><c:out value="${item.cat_name }"/> </td>
			
			<form action="<%= application.getContextPath() %>/ItemController" method="get">
	        	<input type="hidden" name="action" value="addtocart"/>
				<input type="hidden" name="icode" value="${item.code}"/>
				<td><input type="text" name="qty"/></td>
				
				<td>
				<input type="submit" class="btn btn-success" value="Add to Cart "/>
				</td>
			</form>
		</tr>
	</c:forEach>
	</table>
	
	</div>
</body>
</html>