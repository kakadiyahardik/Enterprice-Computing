<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, model.Inventory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Under Stock</title>
<meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
    </head>
    <body>
    <%@include file="common/navigation.jspf" %>
    <div class="container">
<h3>Items Under Stock</h3>
        
        <table class="gridtable" border="1">
            <tr><th>Code</th><th>Description</th><th>Stock</th><th>Min_Stock</th><th>Cost</th><th>Category</th></tr>
        <%
            ArrayList<Inventory> stock = (ArrayList<Inventory>) request.getAttribute("understock");
            if (stock == null )
            { 
                out.println("<tr><td colspan=\"4\">Items not found</td></tr>");
            }
            else
            {
                for(Inventory b : stock)
                { 
                    int icode = b.getCode();
      %>
            <tr>
                <td><a href="#"><%= icode %></a></td>
                <td><%= b.getDescription() %></td>
                <td><%= b.getStock() %></td>
                <td><%= b.getMinStock() %></td>
                <td><%= b.getCost() %></td>
                <td><%= b.getCat_name() %></td>
            </tr>                
        <%		}
          	}
        %>
        </table>
        </div>
</body>
</html>