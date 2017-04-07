package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Inventory;

public class Test {
	
	public static void main(String... args) throws ClassNotFoundException, SQLException, DAOException{
		InventoryDAO book_db = new InventoryDAO();
        ArrayList<Inventory> stock = book_db.getItems();
        
        Inventory item=new Inventory();
        item.setDescription("fa");
        item.setCode(4);
        item.setStock(5);
        item.setMinStock(5);
        item.setCost(45);
        item.setCategory(1);
        book_db.InsertItem(item);
	}

}
