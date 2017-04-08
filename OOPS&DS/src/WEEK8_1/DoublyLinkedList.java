package WEEK8_1;

public class DoublyLinkedList {

	
	public  void empty()
	{
		System.out.println("Linked list is empty");
	}
		
	public Node insertBeg(Node head,int data)
	{
		Node n=new Node(data);
		
		if(head==null)
		{
			head=n;
		}
		else
		{
			n.next=head;
			head.pre=n;
			head=n;
		}
		return head;
	}
		
	public Node insertLast(Node head,int data)
	{
		Node n=new Node(data);
		
		if(head==null)
		{
			head=n;
		}
		else
		{
			Node tmp=head;
			while(tmp.next!=null)
			{
				tmp=tmp.next;
			}
			tmp.next=n;
			n.pre=tmp;
		}
		return head;
		
	}
		
	public Node delBeg(Node head)
	{
		Node tmp=head;
		
		head=head.next;
		tmp.next=null;
		head.pre=null;
		return head;
	}
	
	public Node delLast(Node head)
	{
		if(head==null)
		{
			empty();
		}
		else
		{
			Node tmp=head;
			while(tmp.next!=null)
			{
				tmp=tmp.next;
			}
			
			tmp.pre.next=null;
			tmp.pre=null;
		}
		return head;
	}
	
	public void display(Node head)
	{
		Node tmp=head;
		if(tmp==null)
		{
			empty();
		}
		else
		{
			//Node tm=tmp;
			while(tmp != null)
			{
				System.out.print("->"+tmp.data);
				//tm=tmp;
				tmp=tmp.next;
			}
			/*System.out.println("reverse");
			while(tm != null)
			{
				System.out.print("->"+tm.data);
				tm=tm.pre;
			}*/
			System.out.println();
		}
		
		
	}
}


