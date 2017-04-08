package P1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Emp;

public class JdbcDaoImpl 
{
	public Emp getEmp(int id)
	{
		Connection con=null;
		String driver="org.postgresql.Driver";
		try
		{
			Class.forName(driver).newInstance();
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/hibernatedb","postgres","root");
			PreparedStatement ps=con.prepareStatement("SELECT * from EMP where emp_id = ?");
			ps.setInt(1, id);
			
			Emp e=null;
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				e=new Emp(id,rs.getString("emp_name"));
			}
			
			return e; 
		}
		catch(Exception e)
		{
			System.out.println("yes");
			throw new RuntimeException(e);
		}
		finally
		{
			try 
			{
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}