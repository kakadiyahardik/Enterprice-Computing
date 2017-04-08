package Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InPrePosToTree {
	public static void main(String[] arg)
	{
		Scanner sc=new Scanner(System.in);
		char []pre=new char[20];
		char []in=new char[20];
		NodeChar root=null;
		TreeOperation to=new TreeOperation();
		
			int t=sc.nextInt();
			
			for(int i=0;i<t;i++)
			{
				pre[i]=sc.next().charAt(0);
			}
			
			for(int i=0;i<t;i++)
			{
				in[i]=sc.next().charAt(0);
			}
			
			root=to.makeTree(pre, in, 0, t-1);
			to.postOrder(root);
		

	}
}
