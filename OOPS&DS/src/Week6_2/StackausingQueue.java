package Week6_2;

import java.util.Scanner;

class Queue1
{
	int front=-1;
	int rear=-1;
	int qu[]=new int[50];
	
	void enqueue(int data)
	{
		if(front==-1 && rear==-1)
		{
			front=rear=0;
			qu[rear]=data;
		}
		else
		{
			qu[++rear]=data;
		}
	}
	
	int dequeue()
	{
		if(front==rear)
		{
			int val=qu[front];
			front=rear=-1;
			return val;
		}
		else if(!isEmpty())
		{
			return qu[front++];
		}
		else
		{
			return 0;
		}
	}
	
	boolean isEmpty()
	{
		if(rear==-1 && front==-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
class Queue2
{
	int front=-1;
	int rear=-1;
	int qu[]=new int[50];
	
	void enqueue(int data)
	{
		if(front==-1 && rear==-1)
		{
			front=rear=0;
			qu[rear]=data;
		}
		else
		{
			qu[++rear]=data;
		}
	}
	
	int dequeue()
	{
		if(front==rear)
		{
			int val=qu[front];
			front=rear=-1;
			return val;
		}
		else if(!isEmpty())
		{
			return qu[front++];
		}
		else
		{
			return 0;
		}
	}
	
	boolean isEmpty()
	{
		if(rear==-1 && front==-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

class Stack3
{
	int cnt=0;
	Queue1 q1=new Queue1();
	Queue2 q2=new Queue2();
	
	void push(int val)
	{
		q1.enqueue(val);
		cnt++;
	}
	
	void pop()
	{
		for(int i=0;i<cnt;i++)
		{
			q2.enqueue(q1.dequeue());
		}
		q2.dequeue();
		cnt--;
		
		for(int i=0;i<cnt;i++)
		{
			q1.enqueue(q2.dequeue());
		}
	}
	
	int peek()
	{
		return q1.qu[q1.rear];
	}
	
	void display()
	{
		for(int i=0;i<cnt;i++)
		{
			System.out.println(q1.qu[i]+" ");
		}
	}
}

public class StackausingQueue {

	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int ch=0,val;
		Stack3 s=new Stack3();
		
		while(ch!=5)
		{
			System.out.println(".............................");
			System.out.println("[1] Push:");
			System.out.println("[2] Pop:");
			System.out.println("[3] Peek:");
			System.out.println("[4] Display:");
			System.out.println("[5] Exit:");
			System.out.println(".............................");
			System.out.println("Enter your choice:");
			ch=sc.nextInt();
			
			switch(ch)
			{
				case 1:
					System.out.println("Enter value for insert in stack:");
					val=sc.nextInt();
					s.push(val);
				break;
					
				case 2:
					s.pop();
				break;
				
				case 3:
					System.out.println((s.peek()==-1)?"Stack is empty:":s.peek());
				break;
				
				case 4:
					s.display();	
				break;
				
				case 5:
					System.out.println("Exit:");
				break;
				
				default:
					System.out.println("please enter currect choice:");
				break;
			}
			
		}
		sc.close();
	}
}