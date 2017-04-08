package BAsic;

interface ia
{
	void m1();
}

class ib implements ia
{
	public void m1()
	{
		System.out.println("b");
	}
}

public class DemoInterface 
{
	public static void main(String []s)
	{
		ia demo=new ib();
		demo.m1();
	}
	
}
