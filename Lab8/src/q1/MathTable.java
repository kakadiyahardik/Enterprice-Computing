package q1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/MathTable")
public class MathTable extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num=request.getParameter("number");
		int no=Integer.parseInt(num);
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
        out.println("<head>");
        out.println("<title>Table</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Table</h3>");
        out.println("<h3>==============================================</h3>");
		for(int i=1;i<=10;i++)
		{
			out.println("<h3>"+no+" * "+i+" ="+(no*i)+"</h3>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
