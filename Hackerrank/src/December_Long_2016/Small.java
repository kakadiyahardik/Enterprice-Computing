package December_Long_2016;

import java.util.Scanner;

public class Small {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		int nd=sc.nextInt();
		
		
		int min=1;
		
		for(int i=0;i<nd-1;i++)
		{
			min*=10;
		}
		
		int status=0;
		int sum;
		while(true)
		{
			sum=0;
			String tmp=Integer.toString(min);
			
			for(int j=0;j<tmp.length();j++)
			{
				sum+=Integer.parseInt(Character.toString(tmp.charAt(j)));
			}
			
			if(sum==s)
			{
				System.out.println(min);
				break;
			}
			
			if(Integer.toString(min).length()>nd)
			{
				System.out.println("Not Possible");
				break;
			}
			
			if(status>8)
			{
				min+=10;
			}
			else
			{
				min++;
			}

			status++;
		}
		
		System.out.println(min);
	}

}
