package Week6;

import java.util.Scanner;

public class InToPrefix
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
		String exp2=new String();
		String exp1=new String();
		String pos=new String();
		
		System.out.println("Enter infix expresion:");
		exp2=sc.nextLine().trim();
		
		for(int j=exp2.length()-1;j>=0;j--)
		{
			if(exp2.charAt(j)=='(')
			{
				exp1+=')';
			}
			else if(exp2.charAt(j)==')')
			{
				exp1+='(';
			}
			else
			{
				exp1+=exp2.charAt(j);
			}
		}
		Stack s=new Stack(exp1.length());
		char c;
		
		for(int i=0;i<exp1.length();i++)
		{
			c=exp1.charAt(i);
			
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
		
		exp1="";
		for(int k=pos.length()-1;k>=0;k--)
		{
			exp1+=pos.charAt(k);
		}
		System.out.println(exp1);
		sc.close();
	}

}
