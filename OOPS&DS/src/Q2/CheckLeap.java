package Q2;

import java.util.Scanner;

class Leap
{
	
	void isLeap(int y)
	{
		if(y%4==0 && y%100 != 0 || y%400==0)
		{
			System.out.println("Entered year is Leap Year");
		}
		else
		{
			System.out.println("Year is not a Leap Year");
		}
	}
}
public class CheckLeap {

	public static void main(String[] args) {
		
		Leap l=new Leap();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any year:: ");
		int y=sc.nextInt();
		
		l.isLeap(y);
		sc.close();
		

	}

}
