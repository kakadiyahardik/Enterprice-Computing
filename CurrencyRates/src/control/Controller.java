package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CurrencyDAO;
import model.Currency;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String action=req.getParameter("action");
		
		if(action==null || action.equals("")){
			action="homepage";
		}
		
		if(action.equals("homepage")){
			req.getRequestDispatcher("index.jsp").forward(req, res);
		}
		else if(action.equals("convert")){
			String source=req.getParameter("source");
			String target=req.getParameter("target");
			double amt=Double.parseDouble(req.getParameter("amt"));
			
			
			
			try {
				CurrencyDAO dao=new CurrencyDAO();
				
				double result= dao.getResult(source.toUpperCase(),target.toUpperCase(),amt);
				
				if(result==0.0){
					String tmp="for amount "+amt+" "+source + " to "+ target + " = not exist";
					req.setAttribute("result", tmp);
				}
				else{
					String tmp="for amount "+amt+" "+source + " to "+ target + " = "+result;
					req.setAttribute("result", tmp);
				}
				
				req.getRequestDispatcher("result.jsp").forward(req, res);
			} catch (ClassNotFoundException | SQLException e) {
				
				System.out.println(e+ "problem in convert");
			}
		}
		else if(action.equals("AddCurrency")){
			String source=req.getParameter("source");
			String target=req.getParameter("target");
			double rate=Double.parseDouble(req.getParameter("rate"));
			
			Currency cur=new Currency();
			cur.setSource_Currency(source.toUpperCase());
			cur.setTarget_Currency(target.toUpperCase());
			cur.setRate(rate);
			
			try {
				CurrencyDAO dao=new CurrencyDAO();
				
				boolean status=dao.insertCurrency(cur);
				
				if(status){
					String tmp="Add success";
					req.setAttribute("result", tmp);
				}
				else{
					String tmp="Already exist";
					req.setAttribute("result", tmp);
				}
				req.getRequestDispatcher("result.jsp").forward(req, res);
			} catch (ClassNotFoundException | SQLException e) {
				
				System.out.println(e+ "problem in controller add currency");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
