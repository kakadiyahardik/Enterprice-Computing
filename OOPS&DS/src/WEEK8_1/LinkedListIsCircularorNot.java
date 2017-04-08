package WEEK8_1;

import java.util.Scanner;


public class LinkedListIsCircularorNot {
	
	public static void check(Object sl)
	{
		
	}
	public static void main(String []arg)
	{
		Scanner sc=new Scanner(System.in);
		int ch=0;
		int val;
		Node head=null;
		SinglyLinkedList sl=new SinglyLinkedList();
		CirSinglyLinkedList cl=new CirSinglyLinkedList();
		while(ch != -1)
		{
			System.out.println("========================");
			System.out.println("[1] Insert in singly");
			System.out.println("[2] Insert int circular");
			System.out.println("[3] check");
			System.out.println("========================");
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			System.out.println("========================");
			
			switch(ch)
			{
				case 1:
					System.out.println("Eneter value");
					val=sc.nextInt();
					sl.insertLast(val);
				break;
				
				case 2:
					System.out.println("Eneter value");
					val=sc.nextInt();
					head=cl.insertLast(head,val);
				break;
				case 3:
					
				break;
				
				case -1:
					System.out.println("Exit");
				break;
				default:
					System.out.println("Please enter correct choice");
				break;
		
			}
			
		
		}
		sc.close();
	}

}
