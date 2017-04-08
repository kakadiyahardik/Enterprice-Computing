package AVLtree;
import java.util.Scanner;

import Tree.Node;

public class AVL
{
	public static void main(String... arg)
	{
		Scanner sc=new Scanner(System.in);
		Node root=null;
		TreeOperation to=new TreeOperation();
		System.out.println("y");
		int t=sc.nextInt();
		
		while(t-->0)
		{
			int val=sc.nextInt();
			root=to.insert(root, val);
		}
		
		if(to.isBalanced(root))
		{
			System.out.println("Balanced");
		}
		else
		{
			System.out.println("Not balanced");
		}
		sc.close();
	}
}
