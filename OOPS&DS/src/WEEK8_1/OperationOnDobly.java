package WEEK8_1;

import java.util.Scanner;

public class OperationOnDobly {
	public static void main(String... ar)
	{
		Scanner sc=new Scanner(System.in);
		int ch=0;
		int val;
		Node head=null;
		DoublyLinkedList dl=new DoublyLinkedList();
		while(ch != -1)
		{
			System.out.println("========================");
			System.out.println("[1] Insert Beg");
			System.out.println("[2] Insert last");
			System.out.println("[3] del beg");
			System.out.println("[4] del last");
			System.out.println("[5] display");
			System.out.println("========================");
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			System.out.println("========================");
			
			switch(ch)
			{
				case 1:
					System.out.println("Eneter value");
					val=sc.nextInt();
					head=dl.insertBeg(head,val);
				break;
				
				case 2:
					System.out.println("Eneter value");
					val=sc.nextInt();
					head=dl.insertLast(head,val);
				break;
				case 3:
					head=dl.delBeg(head);
					
				break;
				
				case 4:
					head=dl.delLast(head);
					break;
				case 5:
					dl.display(head);
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
