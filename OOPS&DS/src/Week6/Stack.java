package Week6;

public class Stack
{
	int top=-1;
	char []st;
	
	public Stack(int l)
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
