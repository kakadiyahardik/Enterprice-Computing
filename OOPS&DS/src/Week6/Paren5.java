package Week6;

import java.util.Scanner;

public class Paren5
{
	public static void main(String... arg)
	{
		Scanner sc=new Scanner(System.in);
		String exp=new String();
		char c;
		int l,cnt=0;
		
		System.out.println("Enter Expresion:");
		exp=sc.nextLine().trim();
		
		l=exp.length();
		
		Stack s=new Stack(l);
		
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
					cnt++;
				}
				else if(c=='}' && tmp=='{')
				{
					s.pop();
					cnt++;
				}
				else if(c==']' && tmp=='[')
				{
					s.pop();
					cnt++;
				}
			}
		}
		System.out.println(cnt*2);
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
