package Tree;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	
	static void levelOrder(Node root){
	      //Write your code here
	        Queue<Node> q=new LinkedList<Node>();
	        
	        if(root!=null)
	        {
	            q.add(root);
	        }
	        
	        while(!q.isEmpty())
	        {
	            Node c=q.remove();
	            System.out.print(c.data+" ");
	            
	            if(c.left!=null)
	            {
	                q.add(c.left);
	            }
	            
	            if(c.right!=null)
	            {
	                q.add(c.right);
	            }
	        }
	      
	    }
	
	public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
            sc.close();
        }
}
