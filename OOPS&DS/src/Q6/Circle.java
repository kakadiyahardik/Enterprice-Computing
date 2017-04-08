package Q6;

public class Circle extends Shape{

	private int rd;
	
	void drow(int r)
	{
		rd=r;
	}
	
	void erage()
	{
		rd=0;
	}
	
	void computeArea()
	{
		System.out.println("Area of circle is:: "+3.14*rd*rd);
	}
}
