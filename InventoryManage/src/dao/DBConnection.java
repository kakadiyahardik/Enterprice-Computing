package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private final String driver="org.postgresql.Driver";
	private final String url="jdbc:postgresql://localhost:5432/Inventory";
	private final String uName="postgres";
	private final String pass="root";
	
	private final Connection con;
	private static DBConnection instance=null;
	
	private DBConnection()throws ClassNotFoundException,SQLException{
		Class.forName(driver);
		con=DriverManager.getConnection(url,uName,pass);
	}
	
	public static DBConnection getInstance()throws SQLException,ClassNotFoundException{
		if(instance==null)
			instance=new DBConnection();
		
		return instance;
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public void close() throws SQLException{
        con.close();
        instance = null;
    }
}
