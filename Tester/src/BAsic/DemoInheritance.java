package BAsic;

class A
{
	void m1()
	{
		System.out.println("a");
	}
}

class B extends A
{
	 void m1()
	{
		System.out.println("b");
	}
}

class C extends B
{
	/*void m1()
	{
		System.out.println("c");
	}*/
}
public class DemoInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A test=new C();
		
		test.m1();
	}

}
