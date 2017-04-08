package TreeMore;

import java.util.Scanner;

public class CheckIsFullIsComplete {

	public static void main(String []ar)
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
		
		if(to.isFull(root))
			System.out.println("Tree is full");
		else
			System.out.println("Tree is not full");
		
		int tnode=to.countNode(root);
		
		if(to.isComplete(root,0,tnode))
			System.out.println("Tree is complete");
		else
			System.out.println("Tree is not complete");
		
		sc.close();
		sc.close();
	}
}
