package Array;

import java.util.Scanner;

public class Max {
	public static void main(String []arg)
	{
		Scanner sc=new Scanner(System.in);
        int []a=new int[6];
        int max=0,c=0;
        
        System.out.println("Enter 6 number:");
        for(int i=0;i<6;i++)
        {
            a[i]=sc.nextInt();
            if(a[i]>max)
            {
                max=a[i];
            }
        }
        for(int j=0;j<6;j++)
        {
            if(max==a[j])
            {
                c++;
            }
        }
        System.out.println("Max number:: "+max);
        System.out.println("occurance is:: "+c);
        sc.close();
	}

}
