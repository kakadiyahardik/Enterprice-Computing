package Week5;
import java.util.Scanner;

class Stack1
{
		
		int top=-1;
		char []st;
		
		public Stack1(int l)
		{
			st=new char[l];
		}
		
		public void push(char val)
		{
				top++;
				st[top]=val;			
		}
		
		public void pop()
		{
				st[top]='0';
				top--;
		}
		
		char peek()
		{
			if(top>=0)
			{
				return st[top];
			}
			else
			{
				return '0';
			}
			
		}
		
		public boolean isEmpty()
		{
			if(top<0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
}

public class ParenthesisBal {

		public static void main(String []args)
		{
			Scanner sc=new Scanner(System.in);
			String exp=new String();
			char c;
			int l;
			
			System.out.println("Enter Expresion:");
			exp=sc.nextLine().trim();
			
			l=exp.length();
			System.out.println(l);
			Stack1 s=new Stack1(l);
			
			for(int i=0;i<exp.length();i++)
			{
				c=exp.charAt(i);
				if(c=='(' || c=='{' || c=='[')
				{
					s.push(c);
				}
				else
				{
					char tmp=s.peek();
					if(c==')' && tmp=='(')
					{
						s.pop();
					}
					else if(c=='}' && tmp=='{')
					{
						s.pop();
					}
					else if(c==']' && tmp=='[')
					{
						s.pop();
					}
				}
			}
			
			if(!s.isEmpty())
			{
				System.out.println("NOt balance");
			}
			else
			{
				System.out.println("Balance");
			}
			sc.close();
		}
}

