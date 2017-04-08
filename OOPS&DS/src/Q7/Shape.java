package Q7;

import java.util.Scanner;

public class Shape {

	public static void main(String[] args) {
		int ch=1;
		int x,y;
		Scanner sc=new Scanner(System.in);
		
		while(ch!=0)
		{
			System.out.println("..........................");
			System.out.println("[1] Line");
			System.out.println("..........................");
			System.out.println("enter choice:");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				
				Line l=new Line();
				for(int i=0;i<2;i++)
				{
					System.out.println("Enter cordinat x and y ");
					x=sc.nextInt();
					y=sc.nextInt();
					l.setCod(x, y);
				}
				System.out.println("Length of line::"+l.computeLength());
				System.out.println("Enter cordinate for line 2::"+l.computeLength());

				Line l2=new Line();
				for(int i=0;i<2;i++)
				{
					System.out.println("Enter cordinat x and y ");
					x=sc.nextInt();
					y=sc.nextInt();
					l2.setCod(x, y);
				}
				System.out.println((l.isParallel(l2)==true)?"Parallel":"not parallel");
			break;
			}
		}
		
		sc.close();
	}

}
