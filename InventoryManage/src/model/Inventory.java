package model;

public class Inventory
{
	private int item_code;
	private String item_description;
	private int qty_in_stock;
	private int min_required_stock;
	private double cost;
	private int category;
	private String cat_name;
	
	public Inventory (int itm_code, String itm_description,
			 int qty, int min_qty, double cost)
	{
		this.item_code=itm_code;
		this.setDescription(itm_description);
		this.qty_in_stock=qty;
		this.min_required_stock=min_qty;
		this.cost=cost;
	}
		
	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public void setCode(int cd){
		this.item_code=cd;
	}
	public int getCode()
	{
		return item_code;
	}
	
	public void setDescription(String item_description) {
		this.item_description = item_description;
	}
	public String getDescription() {
		return item_description;
	}
	
	public void setStock(int val){
		this.qty_in_stock=val;
	}
	public int getStock()
	{
		return this.qty_in_stock;
	}
	
	public void setMinStock(int val){
		this.min_required_stock=val;
	}
	
	public int getMinStock()
	{
		return this.min_required_stock;
	}
	
	public void setCost(double val){
		this.cost=val;
	}
	public double getCost()
	{
		return this.cost;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
			
}