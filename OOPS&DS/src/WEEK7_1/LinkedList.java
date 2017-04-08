package WEEK7_1;
import java.util.Scanner;

class Node
{
	Node next;
	Object data;
	
	Node(Object data)
	{
		this.data=data;
		next=null;
	}
}
class LinkedList
{
	public static void empty()
	{
		System.out.println("Linked list is empty");
	}
	
	public static Node insertLast(Node head,Object data)
	{
		Node tmp=head;
		Node n=new Node(data);
			
		if(tmp==null)
		{
			head=n;
		}
		else
		{
			while(tmp.next != null)
			{
				tmp=tmp.next;
			}
			tmp.next=n;
		}
		
		return head;
	}
	
	public static Node reverse(Node head)
	{
		Node tmp=head;
		Node pre,pos;
		pre=pos=tmp;
		
		pos=pos.next;
		while(pos!=null)
		{
			pre=tmp;
			tmp=pos;
			pos=pos.next;
			
			tmp.next=pre;
		}
		head.next=null;
		head=tmp;
		return head;
	}
	
	public static void display(Node head)
	{
		Node tmp=head;
		if(tmp==null)
		{
			empty();
		}
		else
		{
			while(tmp != null)
			{
				System.out.print("->"+tmp.data);
				tmp=tmp.next;
			}
			System.out.println("");
		}
	}
	
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int ch=0;
		Object val;
		Node head=null;
		
		while(ch != -1)
		{
			System.out.println("========================");
			System.out.println("[1] insert");
			System.out.println("[2] Revers");
			System.out.println("[3] display");
			System.out.println("========================");
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			System.out.println("========================");
			
			switch(ch)
			{
				case 1:
					System.out.println("Eneter value");
					val=(Object)sc.next();
					head=insertLast(head,val);
				break;
				
				case 2:
					head=reverse(head);
				break;
				case 3:
					display(head);
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