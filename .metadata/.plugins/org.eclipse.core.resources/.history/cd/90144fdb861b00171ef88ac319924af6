<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, model.Category,dao.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
    </head>
    <body>
    
    <%@include file="common/navigation.jspf" %>
<div class="container">

	<form action="ItemController" method="post">
    <table border="1">
    	<tr><td>description</td><td><input type="text" name ="des"  /></td></tr>
        <tr><td>Stock</td><td><input type="text" name="stock" /></td></tr>
        <tr><td>Min_Stock</td><td><input type="text" name="min_stock" /></td></tr>
        <tr><td>Cost</td><td><input type="text" name="cost" /></td></tr>
        <tr><td>Category</td><td><select value="select" name="cat">
        <%
        InventoryDAO in=new InventoryDAO();
        ArrayList<Category> items =in.getCategory();
        	if(items==null){
        		System.out.println(items);
        	}
        for(Category it : items){
        	%>
        	<option value="<%=it.getCateid()%>" name="cat"> <%=it.getCatename() %></option>
        	<%
        }
        
        %>
               
        </select></td></tr>
      
        <tr><td><input type="submit" name="add" value="add" /></td></tr>
        <input type="hidden" name="action" value="insert" />
    </table>
    </form>
    </div>
</body>
</html>