package AVLtree;

import Tree.Node;

public class TreeOperation {
	
	public Node insert(Node root,int data)
	{
		if(root==null)
		{
			Node t=new Node(data);
			return t;
		}
		else
		{
			if(data<root.data)
			{
				root.left=insert(root.left,data);
			}
			else
			{
				root.right=insert(root.right,data);
			}
			return root;
		}
		
		
	}
	
	
	    Node root;
	  
	   boolean isBalanced(Node node) 
	    {
	        int lh;
	  
	        int rh;
	        
	        if (node == null)
	            return true;
	  
	        lh = height(node.left);
	        rh = height(node.right);
	  
	        if (Math.abs(lh - rh) <= 1
	                && isBalanced(node.left)
	                && isBalanced(node.right)) 
	            return true;
	  
	        return false;
	    }
	  
	    int max(int a, int b) 
	    {
	        return (a >= b) ? a : b;
	    }
	  
	    int height(Node node) 
	    {
	        if (node == null)
	            return 0;
	  
	        return 1 + max(height(node.left), height(node.right));
	    }
	  
}
