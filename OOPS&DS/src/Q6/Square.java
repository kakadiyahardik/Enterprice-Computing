package Q6;

public class Square extends Shape{
	
	private int side;
	
	void drow(int side)
	{
		this.side=side;
	}
	
	void erage()
	{
		this.side=0;
	}
	
	void computeArea()
	{
		System.out.println("Area of square is:: "+this.side * this.side);
	}
}
