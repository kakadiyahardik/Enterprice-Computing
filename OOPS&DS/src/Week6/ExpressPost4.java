package Week6;

import java.util.Scanner;

public class ExpressPost4
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
		case '^':
			return 3;
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
		
		Stack s=new Stack(exp.length());
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
		
		Stack res=new Stack(pos.length());
		char tmp;
		int op1,op2;
		
		for(int j=0;j<pos.length();j++)
		{
			tmp=pos.charAt(j);
			
			if(tmp=='+' || tmp=='-' || tmp=='/' || tmp=='*' || tmp=='^')
			{
				op1=Integer.parseInt(""+res.pop());
				op2=Integer.parseInt(""+res.pop());
				System.out.println(op1+""+op2);
				if(tmp=='+')
				{
					char an=(char)(op1+op2);
					System.out.println(an);
					res.push(an);
				}
			}
			else
			{
				res.push(tmp);
			}
		}
		System.out.println(res.peek());
		
		sc.close();
		
		
	}
}
