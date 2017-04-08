package Week6;
import java.util.Scanner;

public class Recursion2
{
 
	public static void main(String []ar)
	{
		Scanner sc=new Scanner(System.in);
		String ex=new String();
		System.out.println("Enter String:");
		ex=sc.nextLine().trim();
		
		Stack s=new Stack(ex.length());
		Stack rec=new Stack(ex.length());
		
		for(int i=0;i<ex.length();i++)
		{
			s.push(ex.charAt(i));
		}
		//int tp=s.top;
		recur(s,rec);
		
		while(!rec.isEmpty())
		{
			System.out.println(rec.peek());
		}
		
		sc.close();
	}
	
	public static void recur(Stack s,Stack rec)
	{
		if(s.isEmpty())
		{
			
		}
		else
		{
			rec.push(s.pop());
			recur(s,rec);
		}
	}
}
