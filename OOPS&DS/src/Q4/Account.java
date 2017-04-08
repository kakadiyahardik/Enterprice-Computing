package Q4;

public class Account {
	private long accNumber;
	private double balance;
	
	Coust coust;
	
	Account(long an,double bl,String cn)
	{
		this.coust=new Coust(cn);
		this.accNumber=an;
		this.balance=bl;
	}

	double deposit(double amount)
	{
		return this.balance+=amount;
	}
	
	double withdraw(double amount,double fee)
	{
		return this.balance-=amount-fee;
	}
	
	double getBalance(long an)
	{
		return this.balance;
	}
	
	long getAccountNo()
	{
		return this.accNumber;
	}
	void display()
	{
		System.out.println("Account No:: "+this.accNumber);
		System.out.println("Name:: "+this.coust.getName());
		System.out.println("Clear balance is :: "+this.balance);
	}
}
