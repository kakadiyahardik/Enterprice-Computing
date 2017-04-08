package Q6;

public class Triangle {

	private int b;
	private int h;
	
	void drow(int b,int h)
	{
		this.b=b;
		this.h=h;
	}
	
	void erage()
	{
		this.b=0;
		this.h=0;
	}
	
	void computeArea()
	{
		System.out.println("Area of Triangle is :: "+ 0.5 * this.h * this.b);
	}
}
