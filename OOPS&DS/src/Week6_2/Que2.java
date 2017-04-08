package Week6_2;

import java.util.Scanner;

class QueueCircular
{
	int []qu;
	int front=-1,rear=-1;
	
	QueueCircular(int l)
	{
		qu=new int[l];
	}
	
	void enqueue(int val)
	{
		if(front==-1 && rear==-1)
		{
			front=rear=0;
			qu[rear]=val;
		}
		else if(rear==qu.length-1 && front>0)
		{
			rear=0;
			qu[rear]=val;
			
		}
		else if(rear==front-1 || (front == 0 && rear==qu.length-1))
		{
			System.out.println("Over flow");
		}
		else
		{
			rear++;
			qu[rear]=val;
		}
	}
	
	int dequeue()
	{
		int c;
		if(front==-1 && rear==-1)
		{
			c=-1;
			System.out.println("underflow");
		}
		else if(front==rear)
		{
			c=qu[front];
			front=rear=-1;
		}
		if(front==qu.length-1)
		{
			c=qu[front];
			front=0;
			
		}
		else
		{
			c=qu[front];
			front++;
		}
		return c;
	}
	
	void display()
	{
		if(front==-1 && rear==-1)
		{
			System.out.println("Queue is empty");
		}
		else
		{
			int i=front;
			while(true)
			{
				
				System.out.print(qu[i]+" ");
				
				
				if(i==rear)
				{
					break;
				}
				i++;
				if(i==qu.length)
				{
					i=0;
				}
				
			}
		}
		System.out.println();
	}
}

public class Que2 {
	public static void main(String... arg)
	{
		Scanner sc=new Scanner(System.in);
		int ch=1,val;
		System.out.println("How many number you want enter:");
		int n=sc.nextInt();
		QueueCircular q=new QueueCircular(n);
		
		while(ch!=0)
		{
			System.out.println("------------------------");
			System.out.println("[1] enqueu");
			System.out.println("[2] dequeue");
			System.out.println("[3] Display");
			System.out.println("------------------------");
			
			System.out.println("Enter your choice:");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				
				System.out.println("Enetr value you want to enter:");
				val=sc.nextInt();
				q.enqueue(val);
				break;
			
			case 2:
			    q.dequeue();
				break;
			
			case 3:
				q.display();
				break;
				
			}
		}
		sc.close();
	}
}
