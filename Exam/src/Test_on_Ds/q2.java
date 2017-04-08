package Test_on_Ds;
import java.util.Scanner;

class Stack
{
	int []st=new int[50];
	int top=-1;
	
	public void push(int val)
	{
		if(top<st.length-1)
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

public class q2  {

	public static void main(String... arg)throws Exception
	{
		Scanner sc=new Scanner(System.in);
		
		Stack s=new Stack();
		Stack min=new Stack();
		int ch=0,val,c=0,sm;
		

		while(ch!=6)
		{
			System.out.println(".............................");
			System.out.println("[1] Push:");
			System.out.println("[2] Pop:");
			System.out.println("[3] Min:");
			System.out.println("[4] Exit:");
			System.out.println(".............................");
			System.out.println("Enter your choice:");
			ch=sc.nextInt();
			
			switch(ch)
			{
				case 1:
					c++;
					System.out.println("Enter value for insert in stack:");
					val=sc.nextInt();
					s.push(val);
					if(c==1)
					{
						min.push(val);
					}
					else
					{
						sm=min.peek();
						if(val<sm)
						{
							min.push(val);
						}
						else
						{
							min.push(sm);
						}
					}
				break;
					
				case 2:
					c--;
					s.pop();
					min.pop();
				break;
				
				case 3:
					System.out.println("minimum number is: "+min.peek());	
				break;
				
				case 6:
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

