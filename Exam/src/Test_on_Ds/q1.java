package Test_on_Ds;
import java.util.Scanner;

public class q1 {
	
	
	static Node heap(Node root,int val)
	{
		return root;
	}
	
	public static void main(String []ar)
	{
		Scanner sc=new Scanner(System.in);
		Node root=null;
		int no=sc.nextInt();
		int val;
		
		while(no-->0)
		{
			val=sc.nextInt();
			root=heap(root,val);
		}
		
		sc.close();
	}
}
