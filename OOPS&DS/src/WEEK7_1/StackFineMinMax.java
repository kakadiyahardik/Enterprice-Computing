package WEEK7_1;

//import java.util.Scanner;
//import java.io.BufferedReader;
import java.io.*;

class Stack
{
	int []st=new int[10];
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
	
	int peek()
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

public class StackFineMinMax  {

	public static void main(String... arg)throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		Stack s=new Stack();
		Stack min=new Stack();
		Stack max=new Stack();
		int ch=0,val,c=0,sm,l;
		

		while(ch!=6)
		{
			System.out.println(".............................");
			System.out.println("[1] Push:");
			System.out.println("[2] Pop:");
			System.out.println("[3] Max:");
			System.out.println("[4] Min:");
			System.out.println("[5] Display:");
			System.out.println("[6] Exit:");
			System.out.println(".............................");
			System.out.println("Enter your choice:");
			ch=Integer.parseInt(br.readLine());
			
			switch(ch)
			{
				case 1:
					c++;
					System.out.println("Enter value for insert in stack:");
					val=Integer.parseInt(br.readLine());
					s.push(val);
					if(c==1)
					{
						min.push(val);
						max.push(val);
					}
					else
					{
						sm=min.peek();
						l=max.peek();
						
						if(val<sm)
						{
							min.push(val);
						}
						else
						{
							min.push(sm);
						}
						
						if(val>l)
						{
							max.push(val);
						}
						else
						{
							max.push(l);
						}
					}
				break;
					
				case 2:
					c--;
					s.pop();
					min.pop();
					max.pop();
				break;
				
				case 3:
					System.out.println("Maximum number is: "+max.peek());
				break;
				
				case 4:
					System.out.println("minimum number is: "+min.peek());	
				break;
				
				case 5:
					s.display();
				break;
				
				case 6:
					System.out.println("Exit:");
				break;
				
				default:
					System.out.println("please enter currect choice:");
				break;
			}
		}
	}
}
