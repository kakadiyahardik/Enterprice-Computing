package Array;

import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        System.out.println("How many student score you want to enter::");
		int no=sc.nextInt();
        int []a=new int[no];
        int i,best=0;
        
        System.out.println("Enter student score::");
        for(i=0;i<no;i++)
        {
            a[i]=sc.nextInt();
            
            if(a[i]>best)
            {
                best=a[i];
            }
        }
        
        System.out.println("Grade is::");
        for(i=0;i<no;i++)
        {
            if(a[i]>=(best-10))
            {
                System.out.print(" A");
            }
            else if(a[i]>=(best-20))
            {
                System.out.print(" B");
            }
            else if(a[i]>=(best-30))
            {
                System.out.print(" C");
            }
            else if(a[i]>=(best-40))
            {
                System.out.print(" D");
            }
            else
            {
                System.out.print(" F");
            }
        }
        sc.close();
	}

}
