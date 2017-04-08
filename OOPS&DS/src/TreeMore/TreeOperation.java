package TreeMore;

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
	
	public boolean isFull(Node root)
	{
		
		if(root==null)
			return true;
		
		if(root.left==null && root.right==null)
			return true;
		
		if(root.left!=null && root.right!=null)
			return(isFull(root.left) && isFull(root.right));
		
	
		return false;
	}
	
	public int countNode(Node root)
	{
		if(root==null)
			return 0;
		
		return (1 + countNode(root.left) + countNode(root.right));
	}
	
	boolean isComplete(Node root,int index,int tnode)
	{
		if(root==null)
			return true;
		
		if(index>=tnode)
			return false;
		
		return (isComplete(root.left,index*2+1,tnode)&&isComplete(root.right,index*2+2,tnode));
	}
}
