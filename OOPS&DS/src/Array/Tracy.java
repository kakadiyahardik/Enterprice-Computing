package Array;

import java.util.Scanner;

public class Tracy {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String []l1=new String[3];
		String []l2=new String[3];
		String tmp=new String();
		char []pass;
		int i,j,c,f,k;
		
		System.out.println("Enter 3 String for list 1::");
		for(i=0;i<3;i++)
		{
			l1[i]=sc.nextLine().trim();
		}
		
		System.out.println("Enter 3 String for list 2::");
		for(i=0;i<3;i++)
		{
			l2[i]=sc.nextLine().trim();
		}
		
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				tmp=l1[i]+l2[j];
				pass=new char[tmp.length()];
				c=0;
				f=0;
				for(k=0;k<tmp.length();k++)
				{
					if(tmp.charAt(k)>='a' && tmp.charAt(k)<='z')
					{
						pass[c++]=tmp.charAt(k);
						System.out.print(pass[c-1]);
					}
				}
				for(k=0;k<c-1;k++)
				{
					if(pass[k]!=pass[c-k-1])
					{
						break;
					}
					f++;
				}
				
				if(f==c-1)
				{
					System.out.println("=SAFE");
				}
				else
				{
					System.out.println("=BOOM");
				}
				
			}
		}
	
		sc.close();
	}

}
