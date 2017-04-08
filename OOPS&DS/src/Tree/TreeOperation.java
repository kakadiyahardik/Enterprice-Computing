package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeOperation {
	
	static int preIndex=0;
	
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
	
	void levelOrder(Node root){
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
	
	public void postOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public void preOrder(Node root)
	{
		if(root==null)
			return;
		
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(Node root)
	{
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

//-------------print path from root to leaf---------------------
	public void path(Node root,int len)
	{
		int []pathArr=new int[len];
		pathRTL(root,pathArr,0);
	}
	
	public void pathRTL(Node root,int []pathArr,int l)
	{
		if(root==null)
			return;
		
		pathArr[l++]=root.data;
		
		if(root.left==null && root.right==null)
		{
			printPath(pathArr,l);
		}
		
		pathRTL(root.left,pathArr,l);
		pathRTL(root.right,pathArr,l);
	}
	
	public void printPath(int []pathArr,int len)
	{
		System.out.println();
		for(int i=0;i<len;i++)
		{
			System.out.print(pathArr[i]+" ");
		}
	}
//--------------make tree from pre order and in order--------------
	
	public NodeChar makeTree(char []pre,char[] in,int start,int end)
	{
		if(start>end)
			return null;
		
		NodeChar root=new NodeChar(pre[preIndex++]);
		
		if(start==end)
			return root;
		
		int inIndex=findInIndex(in, start, end, root.v);
		
		root.left=makeTree(pre,in,start,inIndex-1);
		root.right=makeTree(pre,in, inIndex+1, end);

		return root;
	}
	
	int findInIndex(char [] in,int s,int e,char v)
	{
		int i;
		for(i=s;i<=e;i++)
		{
			if(in[i]==v)
				return i;
		}
		return i;
	}
	
	public void postOrder(NodeChar root)
	{
		if(root==null)
		{
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.v+" ");
	}
}
