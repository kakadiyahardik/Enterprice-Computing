package WEEK8_1;

public class CirSinglyLinkedList {

	Node tail;
	public  void empty()
	{
		System.out.println("Linked list is empty");
	}
		
	public Node insertLast(Node head,int data)
	{
				Node tmp=head;
				Node n=new Node(data);
				if(tmp==null)
				{
					tail=head=n;
				}
				else
				{
					tail.next=n;
					tail=tail.next;
					tail.next=head;
				}
				
				return head;
		}
		
		public Node delLast(Node head)
		{
			Node tmp=head;
				
			if(tmp==null)
			{
				empty();
			}
			else
			{
				Node tm=tmp;
				while(tmp != tail)
				{
					tm=tmp;
					tmp=tmp.next;
				}
				tail=tm;
				tail.next=null;
				tail.next=head;
			}
			
			return head;
		}
		
		public Node sort(Node head)
		{
			Node t=head;
			Node i=head;
			int tc=0,ic=0;
			
			while(tc!=1)
			{
				ic=0;
				i=t;
				while(ic!=1)
				{
					if(t.data>i.data)
					{
						int s=t.data;
						t.data=i.data;
						i.data=s;
					}
					i=i.next;
					if(i==head)
					{
						ic++;
					}
				}
				t=t.next;
				if(t==head)
					tc++;
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
				while(tmp != tail)
				{
					System.out.print("->"+tmp.data);
					tmp=tmp.next;
				}
				System.out.print("->"+tmp.data);
				System.out.println("");
			}
		}
}


