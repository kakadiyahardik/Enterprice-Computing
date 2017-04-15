
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.User"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="main.css">
        <title>Order</title>
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
      <li ><a href="<%= application.getContextPath() %>/ItemController?action=gotocart">Cart</a></li>
      <li class="active"><a href="<%= application.getContextPath() %>/ItemController?action=movetoorder">Order</a></li>
      
    </ul>
    <div align="right">
    <ul ><li><a href="<%= application.getContextPath() %>/ItemController?action=viewitem">Admin</a></li></ul>
    </div>
  </div>
</nav>
<div class="container">
        <h3>Order</h3>
        
	<table class="table" border="1">
	<tr><th>ID#<th>Description</th><th>Qty</th><th>Rate</th><th>Amount</th><th>Date</th></tr>
		<c:forEach items="${order}" var="item">
	    <tr>
	    	<td><c:out value="${item.order_id }"/> </td>
	    	<td><c:out value="${item.pName }"/> </td>
			<td><c:out value="${item.qty }"/> </td>
			<td><c:out value="${item.rate }"/> </td>
			<td><c:out value="${item.amount }"/> </td>
			<td><c:out value="${item.date }"/> </td>
			
		</tr>
	</c:forEach>
	</table>
	
	</div>
</body>
</html>