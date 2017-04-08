package Week6_2;

import java.util.Scanner;

class Stack1
{
	int top=-1;
	int st[]=new int[50];
	
	void push(int data)
	{
		st[++top]=data;
	}
	
	int pop()
	{
		return st[top--];
	}
}

class Stack2
{
	int top=-1;
	int st[]=new int[50];
	
	void push(int data)
	{
		st[++top]=data;
	}
	
	int pop()
	{
		return st[top--];
	}
}

class Queue3
{
	int []qu;
	int cnt=0;
	Stack1 s1=new Stack1();
	Stack2 s2=new Stack2();
	
	void enqueue(int val)
	{
		s1.push(val);
		cnt++;
	}
	
	void dequeue()
	{
		for(int i=0;i<cnt;i++)
		{
			s2.push(s1.pop());
		}
		s2.pop();
		cnt--;
		for(int i=0;i<cnt;i++)
		{
			s1.push(s2.pop());
		}
	}
	
	void display()
	{
		for(int i=0;i<cnt;i++)
		{
			System.out.print(s1.st[i]);
		}
		System.out.println();
	}
}

public class QueUsingStack {

	public static void main(String... arg)
	{
		Scanner sc=new Scanner(System.in);
		int ch=1,val;
		
		Queue3 q=new Queue3();
		
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
