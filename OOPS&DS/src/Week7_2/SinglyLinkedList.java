package Week7_2;

public class SinglyLinkedList {

	Node tail;
	public  void empty()
	{
		System.out.println("Linked list is empty");
	}
		
	public Node insertBeg(Node head,int data)
	{
				Node tmp=head;
				Node n=new Node(data);
				if(tmp==null)
				{
					head=n;
				}
				else
				{
					n.next=head;
					head=n;
				}
				
				return head;
		}
		
		public Node insertLast(Node head,int data)
		{
			Node tmp=head;
			Node n=new Node(data);
				
			if(tmp==null)
			{
				head=n;
			}
			else
			{
				while(tmp.next != null)
				{
					tmp=tmp.next;
				}
				tmp.next=n;
			}
			
			return head;
		}
		
		public Node insertAft(Node head,int des,int data)
		{
			Node tmp=head;
			Node n=new Node(data);
			
			if(tmp==null)
			{
				empty();
			}
			else
			{
				while(tmp.data != des && tmp.next != null)
				{
					tmp=tmp.next;
				}

				if(tmp.data == des)
				{
					n.next=tmp.next;
					tmp.next=n;
				}
				else
				{
					System.out.println("No data found");
				}
				
			}
			
			return head;
		}
		
		public Node insertBef(Node head,int des,int data)
		{
			Node tmp=head;
			Node n=new Node(data);
			
			if(tmp==null)
			{
				empty();
			}
			else if(tmp.next==null)
			{
				head=insertBeg(head,data);
			}
			else
			{
				while(tmp.next.data != des && tmp.next.next != null)
				{
					tmp=tmp.next;
				}
				
				if(tmp.next.data==des)
				{
					n.next=tmp.next;
					tmp.next=n;
				}
				else
				{
					System.out.println("No data found");
				}
				
			}
			
			return head;
		}
/** Queue using linked list  and circular queue using linked list*/		
		public Node enqueue(Node head,int val)
		{
			Node n=new Node(val);
			if(head==null)
			{
				head=tail=n;
			}
			else
			{
				tail.next=n;
				tail=tail.next;
			}
			return head;
		}
		
		public Node dequeue(Node head)
		{
			if(head==null)
			{
				empty();
			}
			else
			{
				head=head.next;
				
			}
			return head;
		}
		
		public Node Cenqueue(Node head,int val)
		{
			Node n=new Node(val);
			if(head==null)
			{
				head=tail=n;
			}
			else
			{
				tail.next=n;
				tail=tail.next;
				tail.next=head;
			}
			return head;
		}
		
		public Node Cdequeue(Node head)
		{
			if(head==null)
			{
				empty();
			}
			else
			{
				head=head.next;
				tail.next=head;
				
			}
			return head;
		}
		
		public void Cdisplay(Node head)
		{
			int c=0;
			Node tmp=head;
			if(tmp==null)
			{
				empty();
			}
			else
			{
				while(c!=1)
				{
					System.out.print("->"+tmp.data);
					tmp=tmp.next;
					if(tmp==head)
					{
						c++;
					}
				}
				System.out.println("");
			}
		}
/** Stack using Linked list*/
		
		public Node push(Node head,int data)
		{
			Node n=new Node(data);
			
			if(head==null)
			{
				head=n;
			}
			else
			{
				n.next=head;
				head=n;
			}
			return head;
		}
		
		public Node pop(Node head)
		{
			if(head==null)
			{
				empty();
			}
			else
			{
				head=head.next;
			}
			return head;
		}
/** Sorting Linked list*/
		
		public Node sort(Node head)
		{
			Node tmp=head;
			Node in=head;
			int val;
			
			while(tmp!=null)
			{
				while(in!=null)
				{
					
					if(tmp.data>in.data)
					{
						val=tmp.data;
						tmp.data=in.data;
						in.data=val;
					}
					
					in=in.next;
				}
				
				tmp=tmp.next;
				in=tmp;
			}
			
			return head;
		}
/** Left and right rotation of linked list*/
		
		public Node rotation(Node head,int k)
		{
			int c=1;
			Node tmp=head;
			
			while(c<k && tmp.next!=null)
			{
				tmp=tmp.next;
				c++;
			}
			Node rot=tmp;
			
			while(tmp.next != null)
			{
				tmp=tmp.next;
				c++;
			}
			
			tmp.next=head;
			head=rot.next;
			rot.next=null;
			
			System.out.println("Left rotation:");
			display(head);
			
			k=c-k-k;
			c=1;
			
			tmp=head;
			while(c<k && tmp.next!=null)
			{
				tmp=tmp.next;
				c++;
			}
			rot=tmp;
			
			while(tmp.next != null)
			{
				tmp=tmp.next;
				
			}
			
			tmp.next=head;
			head=rot.next;
			rot.next=null;
			
			System.out.println("Right rotation:");
			display(head);
			
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
				while(tmp != null)
				{
					System.out.print("->"+tmp.data);
					tmp=tmp.next;
				}
				System.out.println("");
			}
		}
}


