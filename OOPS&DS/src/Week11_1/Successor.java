package Week11_1;
import java.util.Scanner;

public class Successor {

	public static void main(String... arg)
	{
		Scanner sc=new Scanner(System.in);
		
		Node root=null,temp=null;
		TreeOperation to=new TreeOperation();
		System.out.println("y");
		int t=sc.nextInt();
		
		
		while(t-->0)
		{
			int val=sc.nextInt();
			
			root=to.insert(root, val);
		}
		
		root= to.inOrderSuccessor(root, temp);
        
		if (root != null) {
            System.out.println("Inorder successor of "+ root.data);
        } else {
            System.out.println("Inorder successor not found ");
        }
		sc.close();
	}
}
