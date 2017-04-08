package Week6;
import java.util.Scanner;

public class Mass
{
	public static void main(String... ar )
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter formula:");
		String ex=sc.nextLine();
		Stack s=new Stack(ex.length());
		
		for(int i=0;i<ex.length();i++)
		{
			s.push(ex.charAt(i));
		}
		
		char val;
		int num,mas;
		while(!s.isEmpty())
		{
			val=s.pop();
			
			if(val==')')
			{
				while(s.peek()!='(')
				{
					
				}
			}
			if(val !='c' && val!='h' && val!='o' && val!=')' && val!='(')
			{
				num=Character.getNumericValue(val);
			}
		}
	}
}
