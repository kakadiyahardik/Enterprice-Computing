package Week7_2;

import java.util.Scanner;

public class RotationLinked {
	public static void main(String... ar)
	{
		Scanner sc=new Scanner(System.in);
		int ch=0;
		int val;
		Node head=null;
		SinglyLinkedList sl=new SinglyLinkedList();
		while(ch != -1)
		{
			System.out.println("========================");
			System.out.println("[1] Insert");
			System.out.println("[2] Rotation");
			System.out.println("[3] display");
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
					System.out.println("enter moves:");
					int k=sc.nextInt();
					head=sl.rotation(head,k);
				break;
				case 3:
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
