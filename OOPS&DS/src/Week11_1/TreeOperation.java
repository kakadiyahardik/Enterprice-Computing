package Week11_1;

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
	
	public boolean isBST(Node root,int min,int max)
	{
		if(root==null)
			return true;
		
		if(root.data<min || root.data>max)
			return false;
		
		return (isBST(root.left,min,root.data-1) && 
				isBST(root.right,root.data+1,max));
		
	}
	
	 Node minVal(Node root)
	 {
	        Node cur = root;
	 
	     
	        while (cur.left != null) {
	            cur = cur.left;
	        }
	        return cur;
	}
	 
	 Node inOrderSuccessor(Node root, Node n)
	 {
		 if (n.right != null)
		 {
	            return minVal(n.right);
	     }
	 
	     Node p = n.parent;
	     
	     while (p != null && n == p.right)
	     {
	            n = p;
	            p = p.parent;
	     }
	        return p;
	 }
	 
	 Node findLCA(Node root, int n1, int n2)
	    {
	        if (root == null)
	            return null;
	 
	        if (root.data == n1 || root.data == n2)
	            return root;
	 
	        Node left= findLCA(root.left, n1, n2);
	        Node right = findLCA(root.right, n1, n2);
	 
	        if (left!=null && right!=null)
	            return root;
	 
	        return (left != null) ? left : right;
	    }
}
