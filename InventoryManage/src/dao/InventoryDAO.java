package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import model.CartItem;
import model.Category;
import model.Inventory;
import model.User;


public class InventoryDAO 
{
	
	private final Connection con;
	
	public InventoryDAO()throws ClassNotFoundException,SQLException
	{
		con=DBConnection.getInstance().getConnection();
	}
	
	
	 public void InsertItem(Inventory items)throws DAOException, SQLException
	 {
		 try{
		 PreparedStatement ps=con.prepareStatement("insert into item(icode,idescription,istock,min_stock,cost,category) values(DEFAULT,?,?,?,?,?)");
		
		 ps.setString(1, items.getDescription());
		 ps.setInt(2, items.getStock());
		 ps.setInt(3, items.getMinStock());
		 ps.setDouble(4, items.getCost());
		 ps.setInt(5, items.getCategory());
		 
		 ps.executeUpdate();
		 }
		 catch(Exception e){
			 System.out.println("problem in insert");
		 }
	 }
	 
	 public Inventory getItem(int icode)
	 {
		 Inventory i=new Inventory();
		 String sql="select * from item where icode=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, icode);
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			i.setCode(rs.getInt(1));
			i.setDescription(rs.getString(2));
			i.setStock(rs.getInt(3));
			i.setMinStock(rs.getInt(4));
			i.setCost(rs.getDouble(5));
			i.setCategory(rs.getInt(6));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
		 return i;
	 }
	  
	 public ArrayList<Inventory> getItems(){
		 
		 ArrayList<Inventory> items=new ArrayList<>();
		 Inventory i;
		 try
		 {
			 String sql="select * from item join category on item.category=category.cateid";
			 PreparedStatement ps=con.prepareStatement(sql);
			 
			 ResultSet rs=ps.executeQuery();
			
			 while(rs.next())
			 {
				 i=new Inventory();
				 i.setCode(rs.getInt(1));
				 i.setDescription(rs.getString(2));
				 i.setStock(rs.getInt(3));
				 i.setMinStock(rs.getInt(4));
				 i.setCost(rs.getDouble(5));
				 i.setCategory(rs.getInt(6));
				 i.setCat_name(rs.getString(8));
				
				 items.add(i);
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println("error from get" + e.getMessage());
		 }
		 
		 return items;
	 }
	 
	 public void deleteItem(int code)
	 {
		 String sql="delete from item where icode=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, code);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	 }
	 
	 public ArrayList<Category> getCategory(){
		 String sql="select * from category";
		 ArrayList<Category> items=new ArrayList<>();
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			Category i;
			 ResultSet rs=ps.executeQuery();
				
			 while(rs.next())
			 {
				 i=new Category();
				 i.setCateid(rs.getInt(1));
				 i.setCatename(rs.getString(2));
				 
				 items.add(i);
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return items;
	 }
	 
	 public void updateItem(Inventory items)throws SQLException
	 {

		 try
		{
			
			String sql="update item set idescription=?,istock=?,min_stock=?,cost=?,category=? where icode=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			 ps.setString(1, items.getDescription()); 
			 ps.setInt(2, items.getStock());
			 ps.setInt(3, items.getMinStock());
			 ps.setDouble(4, items.getCost());
			 ps.setInt(5, items.getCategory());
			 ps.setInt(6, items.getCode());
			 ps.executeUpdate();
		 
		}
		catch(Exception e)
		{
			System.out.println("problem in update "+e.getMessage());
		}
	 }
	 
	 public ArrayList<Inventory> getUnderStock(){
		 
		 ArrayList<Inventory> items=new ArrayList<>();
		 Inventory i;
		 try
		 {
			 String sql="select * from item join category on item.category=category.cateid";
			 PreparedStatement ps=con.prepareStatement(sql);
			 
			 ResultSet rs=ps.executeQuery();
			
			 while(rs.next())
			 {
				 if(rs.getInt(3) > rs.getInt(4))
					 continue;
				 i=new Inventory();
				 i.setCode(rs.getInt(1));
				 i.setDescription(rs.getString(2));
				 i.setStock(rs.getInt(3));
				 i.setMinStock(rs.getInt(4));
				 i.setCost(rs.getDouble(5));
				 i.setCategory(rs.getInt(6));
				 i.setCat_name(rs.getString(8));
				
				 items.add(i);
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println("error from get" + e.getMessage());
		 }
		 
		 return items;
	 }
	 
	 public ArrayList<Inventory> selectCatWise(int cat)
	 {
		 ArrayList<Inventory> items=new ArrayList<>();
		 Inventory i;
		 try
		 {
			 String sql="select * from item join category on item.category=category.cateid where category=?";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setInt(1, cat);
			 ResultSet rs=ps.executeQuery();
			
			 while(rs.next())
			 {
				 i=new Inventory();
				 i.setCode(rs.getInt(1));
				 i.setDescription(rs.getString(2));
				 i.setStock(rs.getInt(3));
				 i.setMinStock(rs.getInt(4));
				 i.setCost(rs.getDouble(5));
				 i.setCategory(rs.getInt(6));
				 i.setCat_name(rs.getString(8));
				
				 items.add(i);
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println("error from get" + e.getMessage());
		 }
		 
		 return items;
	 }
	 
	 //from here there is the operation of the user only
	 public void addUser(User user)throws DAOException, SQLException
	 {
		 try{
		 PreparedStatement ps=con.prepareStatement("insert into public.user(user_id,email,password,name,phone,address) values(DEFAULT,?,?,?,?,?)");
		
		 ps.setString(1,user.getEmail());
		 ps.setString(2,user.getPassword());
		 ps.setString(3, user.getName());
		 ps.setLong(4, user.getPhone());
		 ps.setString(5, user.getAdd());
		 //System.out.println(ps.toString());
		 ps.executeUpdate();
		 }
		 catch(Exception e){
			 System.out.println(e+ "problem in add user");
		 }
	 }
	 
	 public User validateLogin(String un,String pass)
	 {
		 String sql="select * from public.user where email=? and password=?";
		
		
		 User user=new User();
		
		 try {
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, un);
			 ps.setString(2, pass);
			 
			 ResultSet rs=ps.executeQuery();
			 
			 if(rs.next())
			 {
				user.setUser_id(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setName(rs.getString(4));
			 }
			 else
			 {
				 return null;
			 }
			 
		} catch (SQLException e) {
			
			System.out.println(e+" error at the time of login");
		}
		return user;	
	}
	
	 public void addToCart(CartItem cart,int uid){
		 
		 try{
			 PreparedStatement ps=con.prepareStatement("insert into cart(cart_id,item_code,des,qty,rate,user_id) values(DEFAULT,?,?,?,?,?)");
			
			 ps.setInt(1, cart.getItem_code());
			 ps.setString(2, cart.getDes());
			 ps.setInt(3, cart.getQty());
			 ps.setDouble(4, cart.getRate());
			 ps.setInt(5, uid);
			 
			 ps.executeUpdate();
			 }
			 catch(Exception e){
				 System.out.println("problem in insert");
			 }
	 }
	 
	 public void addToCarts(Object itm,int uid){
		 
		 ArrayList<CartItem> cartItem=(ArrayList<CartItem>)itm;
		 try {
			PreparedStatement ps=con.prepareStatement("delete from cart where user_id=?");
			ps.setInt(1,uid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e+ " addToCarts");
		}
		 for(CartItem cart:cartItem){
			 addToCart(cart,uid);
		 }
	 }
	 
	 public ArrayList<CartItem> getFromCart(int user_id){
		 
		 ArrayList<CartItem> items=new ArrayList<>();
		 CartItem i;
		 try
		 {
			 String sql="select * from cart where user_id=?";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setInt(1, user_id);
			 
			 ResultSet rs=ps.executeQuery();
			
			 while(rs.next())
			 {
				 i=new CartItem();
				 i.setCartid(rs.getInt(1));
				 i.setItem_code(rs.getInt(2));
				 i.setDes(rs.getString(3));
				 i.setQty(rs.getInt(4));
				 i.setRate(rs.getDouble(5));
				 
				 items.add(i);
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println("error from get" + e.getMessage());
		 }
		 
		 return items;
	 }
	 
	 public void deleteFromCart(int id){
		 
		 String sql="delete from cart where cart_id=?";
		 
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println(e+" problem in delete from cart");
		}
	 }
	
}
