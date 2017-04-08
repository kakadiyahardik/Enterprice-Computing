package Array;

import java.util.Scanner;

public class Sorting {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int []ml={2, 9, 5, 4, 8, 1, 6};
		
        System.out.println("How many number you want to enter::");
        int no=sc.nextInt();
        int ar[]=new int[no];
        int i,j,tmp;
        System.out.println("Entere number::");
        for(i=0;i<no;i++)
        {
            ar[i]=sc.nextInt();
        }
        
        System.out.println("define array sorting::");
        for(i=0;i<ml.length;i++)
        {
            for(j=i+1;j<ml.length;j++)
            {
                if(ml[i]>ml[j])
                {
                    tmp=ml[j];
                    ml[j]=ml[i];
                    ml[i]=tmp;
                }
            }
        }
        for(i=0;i<ml.length;i++)
        {
            System.out.print(" "+ml[i]);
        }
        
        System.out.println("sorting of user enter number::");
        for(i=0;i<no;i++)
        {
            for(j=i+1;j<no;j++)
            {
                if(ar[i]>ar[j])
                {
                    tmp=ar[j];
                    ar[j]=ar[i];
                    ar[i]=tmp;
                }
            }
        }
        
        for(i=0;i<no;i++)
        {
            System.out.print(" "+ar[i]);
        }
        sc.close();
	}

}
