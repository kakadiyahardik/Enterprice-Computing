package Week11_1;

import java.util.Scanner;

public class CheckIsBST {

	public static void main(String []ar)
	{
		Scanner sc=new Scanner(System.in);
		Node root=null;
		TreeOperation to=new TreeOperation();
		System.out.println("y");
		int t=sc.nextInt();
		int min=0,max=100;
		
		while(t-->0)
		{
			int val=sc.nextInt();
			if(min>val)
				min=val;
			
			if(max<val)
				max=val;
			
			root=to.insert(root, val);
		}
		
		if(to.isBST(root, min, max))
			System.out.println("BST");
		else
			System.out.println("Not BST");
		
		sc.close();
	}
}
