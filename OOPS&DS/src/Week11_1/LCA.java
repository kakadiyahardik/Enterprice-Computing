package Week11_1;

import java.util.Scanner;

public class LCA {
	public static void main(String [] arg)
	{
		Scanner sc=new Scanner(System.in);
		
		Node root=null;
		TreeOperation to=new TreeOperation();
	
		System.out.println("y");
		int t=sc.nextInt();
		int n1,n2;
		
		while(t-->0)
		{
			int val=sc.nextInt();
			
			root=to.insert(root, val);
		}
		n1=sc.nextInt();
		n2=sc.nextInt();
		root=to.findLCA(root, n1, n2);
		
		System.out.println(root.data);
		sc.close();
	}
}
