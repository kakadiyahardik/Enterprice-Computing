package Q4;

import java.util.HashMap;

public class Bank {
	
	HashMap<Long,Account> data=new HashMap<Long,Account>();
	
	void createAccoutnt(long accountNumber,double balance,String cName)
	{
		Account a=new Account(accountNumber,balance,cName);
		this.data.put(accountNumber,a);
	}
	
	double deposit(long ac,double amount)
	{
		Account t=(Account)this.data.get(ac);
		return t.deposit(amount);
	}
	
	double withdraw(long ac,double bl)
	{
		Account t=(Account)this.data.get(ac);
		return t.withdraw(bl, 22);
	}
	
	void deleteAc(long an)
	{
		this.data.remove(an);
		System.out.println("Account Deleted::");
	}
	
	void display(long ac)
	{
		Account t=(Account)this.data.get(ac);
		t.display();
	}
}
