package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emp
{
	@Id
	private int emp_id;
	private String emp_name;
	
	public Emp(int id,String name)
	{
		setEmp_id(id);
		setEmp_name(name);
	}
	
	public int getEmp_id() {
		return emp_id;
	}
	
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	public String getEmp_name() {
		return emp_name;
	}
	
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

}
