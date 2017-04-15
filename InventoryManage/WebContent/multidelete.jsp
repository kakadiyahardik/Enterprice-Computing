<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList, model.Inventory" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="main.css">
        <title>Items</title>
    <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
    </head>
    <body>
    <%@include file="common/navigation.jspf" %>
    <div class="container">
        <h3>Multi Delete</h3>
        
        <form action="ItemController" method="post">
        <table class="table" border="1">
            <tr><th>Code</th><th>Description</th><th>Stock</th><th>Min_Stock</th><th>Cost</th><th>Category</th><th>Select</th></tr>
        <%
            ArrayList<Inventory> stock = (ArrayList<Inventory>) request.getAttribute("stock");
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
                <td><input type="checkbox" name="dmi" value="<%=icode%>"/></td>
            </tr>                
        <%		}
          	}
        %>
        </table>
        <input type="submit" class="btn btn-danger" value="Delete"/>
        <input type="hidden" name="action" value="delmulti"/>
        </form>
       </div>
    </body>
</html>
