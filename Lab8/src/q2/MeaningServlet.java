package q2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.rmi.server.Dispatcher;



public class MeaningServlet extends HttpServlet {
	ArrayList<String> history=new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String spelling=request.getParameter("word");
		String name=request.getParameter("name");
		HttpSession session=null;
		if(session==null)
		{
			session=request.getSession();
			//out.print(session.getAttribute("name"));
			
			if(session.getAttribute("name").equals(""))
			{//out.print("yes");
				session.setAttribute("name", name);
			}
			session.setAttribute("history", history);
		}
		
		
		
		
		
		Properties prop=new Properties();
		InputStream inp=MeaningServlet.class.getClassLoader().getResourceAsStream("q2/vocab.properties");
			
		prop.load(inp);
		String ans=prop.getProperty(spelling);
		
		ArrayList<String> tmp=(ArrayList<String>) session.getAttribute("history");
		tmp.add("Word: "+spelling+" Meaning: "+ans);
				
		
		
		
		out.println("<html>");
        out.println("<head>");
        out.println("<title>Table</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Meaning</h3>");
        out.println("<h3>==============================================</h3>");
        out.println("<h2>" + "Word :"  + spelling + "</h2>" );
        out.println("<h2>" + "Meaning :"  + ans + "</h2>" );
        /*Iterator i=tmp.iterator();
        while(i.hasNext())
		{
			out.println(i.next());
		}*/
        
        out.println("<a href=index.html> Click here for Bake </a>&nbsp");
        out.println("<a href=history.jsp> History </a>" );
        //out.println("<h3>"+spelling+"</h3>");
        //out.println("<h3>Meaning: </h3><"+prop.getProperty(spelling)+">");
		out.println("</body>");
		out.println("</html>");
		
		RequestDispatcher rd=request.getRequestDispatcher("history.jsp");
	//	rd.forward(request, response);
	}

}
