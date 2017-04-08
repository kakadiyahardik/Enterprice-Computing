package Q6;

import java.util.Scanner;

public class Solution {
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		Circle c=new Circle();
		Triangle t=new Triangle();
		Square s=new Square();
		int radius;
		int side;
		int h,b;
		
		System.out.println("Enter radius::");
		radius=sc.nextInt();
		c.drow(radius);
		c.computeArea();
		c.erage();
		
		System.out.println("Enter Side of Square::");
		side=sc.nextInt();
		s.drow(side);
		s.computeArea();
		s.erage();
		
		System.out.println("Enter Hieght and Breadth of triangle");
		h=sc.nextInt();
		b=sc.nextInt();
		t.drow(b, h);
		t.computeArea();
		t.erage();
		sc.close();
	}
}
