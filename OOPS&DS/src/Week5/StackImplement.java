package Week5;

import java.util.Scanner;

class Stack
{
	int []st=new int[8];
	int top=-1;
	
	public void push(int val)
	{
		if(top<8-1)
		{
			top++;
			st[top]=val;
		}
		else
		{
			System.out.println("Stack overflow:");
		}
		
	}
	
	public void pop()
	{
		if(top>=0)
		{
			st[top]=0;
			top--;
		}
		else
		{
			System.out.println("Stack is empty:");
		}
		
	}
	
	int peep()
	{
		if(top>=0)
		{
			return st[top];
		}
		else
		{
			return -1;
		}
	}
	
	public void display()
	{
		for(int i=0;i<=top;i++)
		{
			System.out.print(st[i]+" ");
		}
		System.out.println();
	}
}

class StackImplement
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int ch=0,val;
		Stack s=new Stack();
		
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
					System.out.println((s.peep()==-1)?"Stack is empty:":s.peep());
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
		
	}
}
