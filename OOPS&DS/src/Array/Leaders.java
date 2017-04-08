package Array;

import java.util.Scanner;

public class Leaders {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        		
        int max;
        
        System.out.println("How many number you want to enter::");
        int no=sc.nextInt();
        int []ar=new int[no];
        
        System.out.println("Enter number::");
        for(int i=0;i<no;i++)
        {
            ar[i]=sc.nextInt();
        }
// O(n) complexity        
        System.out.println("Leader are::");
        max=ar[ar.length-1];
        for(int j=ar.length-1;j>=0;j--)
        {
        	if(ar[j]>=max)
        	{
        		System.out.print(" "+ar[j]);
        		max=ar[j];
        	}
        }

// O(n*n) complexity
/*  
 * 		int f=0    
  		for(int j=0;j<no;j++)
        {
            for(int k=j+1;k<no;k++)
            {
                if(ar[j]<ar[k])
                {
                    f=1;
                }
            }
            if(f==0)
            {
                System.out.println(ar[j]);
            }
            else
            {
                f=0;
            }
        }*/
        sc.close();
	}

}
