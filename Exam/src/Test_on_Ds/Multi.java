package Test_on_Ds;

class a
{
	a(){
		System.out.println("a con");
	}
	public void m(){
		System.out.println("Super");
				
	}
}
class b extends a
{
	b(){
		System.out.println("b con");
	}
}
class c extends b
{
	c(){
		System.out.println("c con");
	}
	public void m(){
		System.out.println("c before");
		super.m();
		System.out.println("c after");
	}		
}
class d extends c
{
	d(){
		System.out.println("d con");
		m();
	}
}

public class Multi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		d n=new d();
		n.m();
	}

}
