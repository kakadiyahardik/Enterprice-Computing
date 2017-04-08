package Demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="EMP")
public class Employee 
{
	@Id
	@Column (name="EMP_ID")
	private int employeeId;  
	@Column (name="EMP_NAME")
	private String employeeName;
	
	public int getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId(int employeeId)
	{
		this.employeeId = employeeId;
	}

	public String getEmployeeName()
	{
		return employeeName;
	}

	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}
}
