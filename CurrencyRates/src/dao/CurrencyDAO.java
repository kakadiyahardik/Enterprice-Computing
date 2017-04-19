package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Currency;

public class CurrencyDAO 
{
	
	private final Connection con;
	
	public CurrencyDAO()throws ClassNotFoundException,SQLException
	{
		con=DBConnection.getInstance().getConnection();
	}
	
	
	 public boolean insertCurrency(Currency cur)throws SQLException
	 {
		 try{
				 PreparedStatement ps=con.prepareStatement("select *from currencyrates where source_currency=? and target_currency=?");
				
				 ps.setString(1, cur.getSource_Currency());
				 ps.setString(2, cur.getTarget_Currency());
				 
				 ResultSet rs=ps.executeQuery();
				 
				 if(rs.next()){
					 return false;
				 }
				 
				 ps=con.prepareStatement("select *from currencyrates where source_currency=? and target_currency=?");
					
				 ps.setString(1, cur.getTarget_Currency());
				 ps.setString(2, cur.getSource_Currency());
				 
				 rs=ps.executeQuery();
				 
				 if(rs.next()){
					 return false;
				 }
			 }
			 catch(Exception e){
				 System.out.println(e+ " check");
			 }
		 
		 try{
			 PreparedStatement ps=con.prepareStatement("insert into currencyrates(id,source_currency,target_currency,conversion_rate) values(DEFAULT,?,?,?)");
			
			 ps.setString(1, cur.getSource_Currency());
			 ps.setString(2, cur.getTarget_Currency());
			 ps.setDouble(3, cur.getRate());
			 
			 ps.executeUpdate();
		 }
		 catch(Exception e){
			 System.out.println(e+ " problem in insert currency");
		 }
		 return true;
	 }
	 
	 public double getResult(String src,String tr,double amt)throws SQLException{
		 
		 try{
			 PreparedStatement ps=con.prepareStatement("select conversion_rate from currencyrates where source_currency=? and target_currency=?");
			
			 ps.setString(1, src);
			 ps.setString(2, tr);
			 
			 ResultSet rs=ps.executeQuery();
			 
			 if(rs.next()){
				 double reult=amt+(amt*rs.getDouble(1)/100);
				 
				 return reult;
			 }
			 
			 
			 
			 ps=con.prepareStatement("select conversion_rate from currencyrates where source_currency=? and target_currency=?");
				
			 ps.setString(1, tr);
			 ps.setString(2, src);
			 
			 rs=ps.executeQuery();
			 
			 if(rs.next()){
				 double rate=rs.getDouble(1);
				 rate+=100;
				 double reult=(100*amt/rate);
				 
				 return reult;
			 }
			 
		 }
			 catch(Exception e){
				 System.out.println(e+ " get result");
			 
			 }
		 
		 return 0.0;
	 }
}
