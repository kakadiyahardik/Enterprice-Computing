package Tree;
import java.util.Scanner;

public class RootToLeafPath {
	public static void main(String... arg)
	{
		Scanner sc=new Scanner(System.in);
		Node root=null;
		TreeOperation to=new TreeOperation();
		System.out.println("y");
		int t=sc.nextInt();
		int n=t;
		while(t-->0)
		{
			int val=sc.nextInt();
			root=to.insert(root, val);
		}
		
		System.out.println("Path from root to leaf:");
		to.path(root,n);
		
		sc.close();
	}
}
