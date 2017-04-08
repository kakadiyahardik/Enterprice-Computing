package Tree;
import java.util.Scanner;

public class PreInPosTraversal {

	public static void main(String[] args) {
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
		
		System.out.println("Pre order");
		to.preOrder(root);
		System.out.println("\nIn order");
		to.inOrder(root);
		System.out.println("\nPost order");
		to.postOrder(root);
		sc.close();
	}

}
