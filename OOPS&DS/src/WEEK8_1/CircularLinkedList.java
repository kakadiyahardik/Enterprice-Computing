package WEEK8_1;

import java.util.Scanner;

public class CircularLinkedList {
	
	public static void main(String... ar)
	{
		Scanner sc=new Scanner(System.in);
		int ch=0;
		int val;
		Node head=null;
		CirSinglyLinkedList sl=new CirSinglyLinkedList();
		while(ch != -1)
		{
			System.out.println("========================");
			System.out.println("[1] Insert");
			System.out.println("[2] Delete");
			System.out.println("[3] sort");
			System.out.println("[4] display");
			System.out.println("========================");
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			System.out.println("========================");
			
			switch(ch)
			{
				case 1:
					System.out.println("Eneter value");
					val=sc.nextInt();
					head=sl.insertLast(head,val);
				break;
				
				case 2:
					head=sl.delLast(head);
				break;
				
				case 3:
					head=sl.sort(head);
					break;
				case 4:
					sl.display(head);
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
