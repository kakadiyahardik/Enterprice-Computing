package Week5;
import java.util.Scanner;

class Stackintopos
{
	int top=-1;
	char []st;
	
	public Stackintopos(int l)
	{
		st=new char[l];
	}
	
	public void push(char val)
	{
			top++;
			st[top]=val;			
	}
	
	public char pop()
	{
		char val=st[top];
		st[top]='0';
		top--;
		
		return val;
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
	
	boolean isEmpty()
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

public class IntoPost
{
	public static int checkPrecedence(char op)
	{
		switch(op)
		{
		case '+':
		case '-':
			return 1;
		
		case '/':
		
		case '*':
			return 2;
		}
		return 1;
	}
	
	public static boolean isOpParenthesis(char p)
	{
		if(p=='(')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void main(String... arg)
	{
		Scanner sc=new Scanner(System.in);
		String exp=new String();
		String pos=new String();
		
		System.out.println("Enter infix expresion:");
		exp=sc.nextLine().trim();
		
		Stackintopos s=new Stackintopos(exp.length());
		char c;
		
		for(int i=0;i<exp.length();i++)
		{
			c=exp.charAt(i);
			
			if(c=='(')
			{
				s.push(c);
			}
			else if(c=='*' || c=='/' || c=='+' || c=='-')
			{
				while(checkPrecedence(c)<=checkPrecedence(s.peek()) && !s.isEmpty()
						&& !isOpParenthesis(s.peek()))
				{
					pos+=s.pop();
				}
				s.push(c);
			}
			else if(c==')')
			{
				while(!isOpParenthesis(s.peek()))
				{
					pos+=s.pop();
				}
				s.pop();
			}
			else
			{
				pos+=c;
			}
		}
		while(!s.isEmpty())
		{
			pos+=s.pop();
		}
		System.out.println(pos);
		sc.close();
	}
}
