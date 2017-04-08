package Q2;

import java.util.Scanner;

class CheckDiff
{
	private int df=0;
	
	void checkDiff(String d11,String d22)
	{
		String []d1=d11.split(" ");
		String []d2=d22.split(" ");
		
		df+=Math.abs(Integer.parseInt(d1[2])-Integer.parseInt(d2[2]))*365;
		
		df+=Math.abs(Integer.parseInt(d1[1])-Integer.parseInt(d2[1]))*30;
		
		df+=Math.abs(Integer.parseInt(d1[0])-Integer.parseInt(d2[0]));
		
		System.out.println("Diffrence day is :: "+df);
	}
	
}
public class DiffDate {

	public static void main(String[] args) {
	
		CheckDiff c=new CheckDiff();
		String d1,d2;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Date 1 (dd mm yyyy)");
		d1=sc.nextLine();
		System.out.println("Enter Date 2 (dd mm yyyy)");
		d2=sc.nextLine();
		
		c.checkDiff(d1, d2);
		sc.close();
	}

}
