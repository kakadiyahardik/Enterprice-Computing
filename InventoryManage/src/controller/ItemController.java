package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.InventoryDAO;
import model.CartItem;
import model.Category;
import model.Inventory;
import model.Order;
import model.User;


@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	
	
	protected void controll(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException, ClassNotFoundException, SQLException{
		
		String action=req.getParameter("action");
		
		if(action==null)
			action="viewitem";
		
		if(action.equals("viewitem"))
		{
			 String view = "catalogue_view.jsp";
		        
		        try
		        {
		        	setStock(req, res);
		        }
		        catch(Exception e) {
		        	
		            req.setAttribute("error", e.toString() + ";[ShowCat.java]");
		        }

		     req.getRequestDispatcher(view).forward(req, res);
		}
		else if(action.equals("insert"))
		{
			//int icode=Integer.parseInt(req.getParameter("icode"));
			String des=req.getParameter("des");
			int stock=Integer.parseInt(req.getParameter("stock"));
			int min_stock=Integer.parseInt(req.getParameter("min_stock"));
			double cos=Double.parseDouble(req.getParameter("cost"));
			int cateid=Integer.parseInt(req.getParameter("cat"));
			
			try
			{
	            InventoryDAO inventory = new InventoryDAO();
	            Inventory item=new Inventory();
	            
	           // item.setCode(icode);
	            item.setDescription(des);
	            item.setStock(stock);
	            item.setMinStock(min_stock);
	            item.setCost(cos);
	            item.setCategory(cateid);
	            
	            inventory.InsertItem(item);
	            setStock(req, res);
	        }
	        catch(Exception e) {
	        	
	            req.setAttribute("error", e.toString() + ";[ShowCat.java]");
	            
	        }
			req.getRequestDispatcher("catalogue_view.jsp").forward(req, res);
		}
		else if(action.equals("deleteitem"))
		{
			int icode=Integer.parseInt(req.getParameter("icode"));
			InventoryDAO in=new InventoryDAO();
			
			in.deleteItem(icode);
			
            setStock(req, res);
			req.getRequestDispatcher("catalogue_view.jsp").forward(req, res);
		}
		else if(action.equals("edititem"))
		{
			int icode=Integer.parseInt(req.getParameter("icode"));
			
			Inventory in=new InventoryDAO().getItem(icode);
			
			req.setAttribute("editdetail", in);
			req.getRequestDispatcher("edit.jsp").forward(req, res);
			
		}
		else if(action.equals("update"))
		{
			int icode=Integer.parseInt(req.getParameter("icode"));
			String des=req.getParameter("des");
			int stock=Integer.parseInt(req.getParameter("stock"));
			int min_stock=Integer.parseInt(req.getParameter("min_stock"));
			double cos=Double.parseDouble(req.getParameter("cost"));
			int cateid=Integer.parseInt(req.getParameter("cat"));
			
			try
			{
	            InventoryDAO inventory = new InventoryDAO();
	            Inventory item=new Inventory();
	            
	            item.setCode(icode);
	            item.setDescription(des);
	            item.setStock(stock);
	            item.setMinStock(min_stock);
	            item.setCost(cos);
	            item.setCategory(cateid);
	            
	            inventory.updateItem(item);
	            setStock(req, res);
	        }
	        catch(Exception e) {
	        	
	            req.setAttribute("error", e.toString() + ";[ShowCat.java]");
	            
	        }
			req.getRequestDispatcher("catalogue_view.jsp").forward(req, res);
		}
		else if(action.equals("understock"))
		{
			InventoryDAO in=new InventoryDAO();
			ArrayList<Inventory> items = in.getUnderStock();
	        req.setAttribute("understock", items);
	        req.getRequestDispatcher("understock.jsp").forward(req, res);
		}
		else if(action.equals("catwise"))
		{
			int cat=Integer.parseInt(req.getParameter("cat"));
			InventoryDAO in=new InventoryDAO();
			ArrayList<Inventory> items = in.selectCatWise(cat);
	        req.setAttribute("catwise", items);
	        req.getRequestDispatcher("categorywise.jsp").forward(req, res);
		}
		else if(action.equals("godeletepage"))
		{
			setStock(req,res);
			req.getRequestDispatcher("multidelete.jsp").forward(req, res);
		}
		else if(action.equals("delmulti"))
		{
			String []did=req.getParameterValues("dmi");
			
			InventoryDAO in=new InventoryDAO();
			
			for(int i=0;i<did.length;i++){
				int icode=Integer.parseInt(did[i]);
				in.deleteItem(icode);
			}

            setStock(req, res);
			req.getRequestDispatcher("catalogue_view.jsp").forward(req, res);
		}
		
		
		//for the user response and handle him
		if(action.equals("register"))
		{
			String email=req.getParameter("email");
			String pass=req.getParameter("password");
			String name=req.getParameter("name");
			String phone=req.getParameter("phone");
			String add=req.getParameter("add");
			
			User user=new User();
			user.setEmail(email);
			user.setPassword(encriptPass(pass));
			user.setName(name);
			user.setPhone(Long.parseLong(phone));
			user.setAdd(add);
			
			InventoryDAO in=new InventoryDAO();
			try {
				in.addUser(user);
			} catch (DAOException e) {
				
				//e.printStackTrace();
			}
		}
		else if(action.equals("userlogin"))
		{
			String email=req.getParameter("email");
			String pass=req.getParameter("password");
			
			InventoryDAO in=new InventoryDAO();
			User user=in.validateLogin(email, encriptPass(pass));
			
			if(user==null)
				res.sendRedirect("user/login.jsp");
			else
			{
				setStock(req, res);
				req.getSession().setAttribute("user", user);
				req.getSession().setAttribute("cart",in.getFromCart(user.getUser_id()));
				req.getRequestDispatcher("/user/home.jsp").forward(req, res);
			}
		}
		else if(action.equals("home"))
		{
			setStock(req, res);
			req.getRequestDispatcher("/user/home.jsp").forward(req, res);
		}
		else if(action.equals("gotocart")){
			req.getRequestDispatcher("/user/cart.jsp").forward(req, res);
		}
		else if(action.equals("addtocart")){
			
			ArrayList<CartItem> al=(ArrayList<CartItem>) req.getSession().getAttribute("cart");
			
			String sqty=req.getParameter("qty");
			int qty;
			
			//set ddefault qty
			if(sqty=="" || sqty==null){
				qty=1;
			}
			else{
				qty=Integer.parseInt(sqty);
			}
			
			int item_code=Integer.parseInt(req.getParameter("icode"));
			
			Iterator i=al.iterator();
			boolean flag=true;
			while(i.hasNext()){
				CartItem cartitem=(CartItem)i.next();
				
				if(cartitem.getItem_code()==item_code){
					flag=false;
					cartitem.setQty(cartitem.getQty()+qty);
				}
			}
			
			if(flag){
				Inventory in=new InventoryDAO().getItem(item_code);
				CartItem cart=new CartItem();
				
				cart.setItem_code(in.getCode());
				cart.setDes(in.getDescription());
				cart.setRate(in.getCost());
				cart.setQty(qty);
								
				al.add(cart);
			}
			
			req.getSession().setAttribute("cart", al);
			setStock(req, res);
			req.getRequestDispatcher("/user/home.jsp").forward(req, res);
			
		}
		else if(action.equals("saveToCart")){
			
			User user=(User) req.getSession().getAttribute("user");
			int user_id=user.getUser_id();
			InventoryDAO in=new InventoryDAO();
			
			in.addToCarts(req.getSession().getAttribute("cart"), user_id);
			req.getRequestDispatcher("/user/cart.jsp").forward(req, res);
		}
		else if(action.equals("deletecart")){
			
			int icode=Integer.parseInt(req.getParameter("icode"));
			
			ArrayList<CartItem> al=(ArrayList<CartItem>)req.getSession().getAttribute("cart");
			Iterator i=al.iterator();
			
			while(i.hasNext()){
				CartItem cart=(CartItem) i.next();
				
				if(cart.getItem_code()==icode){
					i.remove();
				}
			}
			
			req.getSession().setAttribute("cart",al);
			req.getRequestDispatcher("/user/cart.jsp").forward(req, res);
		}
		else if(action.equals("editcart")){
			int code=Integer.parseInt(req.getParameter("icode"));
			
			ArrayList<CartItem> al=(ArrayList<CartItem>)req.getSession().getAttribute("cart");
			Iterator i=al.iterator();
			CartItem cart=new CartItem();
			
			while(i.hasNext()){
				
				cart=(CartItem) i.next();
				
				if(cart.getItem_code()==code){
					break;
				}
			}
			
			req.setAttribute("edititem", cart);
			req.getRequestDispatcher("/user/edit.jsp").forward(req, res);
		}
		else if(action.equals("updatecart")){
			int code=Integer.parseInt(req.getParameter("icode"));
			
			int qty=Integer.parseInt(req.getParameter("qty"));
			
			ArrayList<CartItem> al=(ArrayList<CartItem>)req.getSession().getAttribute("cart");
			Iterator i=al.iterator();
			
			while(i.hasNext()){
				CartItem cart=(CartItem) i.next();
				
				if(cart.getItem_code()==code){
					cart.setQty(qty);
				}
			}
			
			req.getSession().setAttribute("cart",al);
			req.getRequestDispatcher("/user/cart.jsp").forward(req, res);
		}
		else if(action.equals("placeOrder")){
			
			ArrayList<CartItem> cart=(ArrayList<CartItem>) req.getSession().getAttribute("cart");
			InventoryDAO in=new InventoryDAO();
			User user=(User) req.getSession().getAttribute("user");
			in.placeOrders(cart, user.getUser_id());
			
			req.getSession().setAttribute("cart", new ArrayList<CartItem>());
			movetoOrderPage(req, res);
		}
		else if(action.equals("movetoorder")){
			movetoOrderPage(req, res);
		}
		else if(action.equals("catwiseuser")){
			int cat=Integer.parseInt(req.getParameter("cat"));
			InventoryDAO in=new InventoryDAO();
			ArrayList<Inventory> items = in.selectCatWise(cat);
	        req.setAttribute("stock", items);
	        req.getRequestDispatcher("user/home.jsp").forward(req, res);
		}
	}
	
	//this method is for encript password
	
	public String encriptPass(String pass)
	{
		if (pass == null || pass.length() == 0) {
	        throw new IllegalArgumentException(
	                "String to encrypt cannot be null or zero length");
	    }

	    StringBuffer hexString = new StringBuffer();

	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(pass.getBytes());
	        byte[] hash = md.digest();

	        for (int i = 0; i < hash.length; i++) {
	            if ((0xff & hash[i]) < 0x10) {
	                hexString.append("0"
	                        + Integer.toHexString((0xFF & hash[i])));
	            } else {
	                hexString.append(Integer.toHexString(0xFF & hash[i]));
	            }
	        }
	    } catch (NoSuchAlgorithmException e) {
	    		System.out.println("problem in password encription");
	    }

	    return hexString.toString();
	}
	
	//this method is for set stock from database to attribute so it can be aaccess in jsp file
	public void setStock(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException{
		InventoryDAO in=new InventoryDAO();
		ArrayList<Inventory> items = in.getItems();
        req.setAttribute("stock", items);
       
        
	}
	
	public void movetoOrderPage(HttpServletRequest req, HttpServletResponse res){
		InventoryDAO in;
		try {
			in = new InventoryDAO();
			User user=(User) req.getSession().getAttribute("user");
			
			ArrayList<Order> order=in.getOrder(user.getUser_id());
			req.setAttribute("order", order);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			req.getRequestDispatcher("user/order.jsp").forward(req, res);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			controll(request,response);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			controll(request, response);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
