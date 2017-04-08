package Week11_2;

import java.util.Scanner;

public class ConvertMinToMaxHeap {

	public static void main(String []ar)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("y");
		
		int t=sc.nextInt();
		
		HeapOperation hp=new HeapOperation(t);
		int arr[]=new int[t];
		
		for(int i=0;i<t;i++)
		{
			int val=sc.nextInt();
			arr[i]=val;
		}
		
		hp.create(arr);
		hp.display();
		hp.convertMaxHeap(t);
		hp.display();
		sc.close();
	}
}
