package Array;

import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int [][]a=new int[3][3];
        int [][]b=new int[3][3];
        int i,j;
        
        long startTime = System.currentTimeMillis();
      //code
       
        System.out.println("Eneter matrix A in form of 3 X 3");
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("A transform");
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                System.out.print(" "+a[j][i]);
            }
            System.out.print("\n");
        }
        
        System.out.println("Eneter matrix B in form of 3 X 3");
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                b[i][j]=sc.nextInt();
            }
        }
        
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                a[i][j]=a[i][j]+b[i][j];
            }
        }
        
        System.out.println("A+b transform");
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                System.out.print(" "+a[j][i]);
            }
            System.out.print("\n");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Took "+(endTime - startTime) + " ns");
        sc.close();
	}

}
