package WEEK8_1;

public class SinglyLinkedList {

	PolyNode tail;
	PolyNode head=null;
	
	public  void empty()
	{
		System.out.println("Linked list is empty");
	}
		
		public void insert(int coof,int power)
		{
			PolyNode tmp=head;
			PolyNode n=new PolyNode(coof,power);
				
			if(tmp==null)
			{
				head=tail=n;
			}
			else
			{
				tail.next=n;
				tail=n;
			}
		}
		
		public void display()
		{
			PolyNode tmp=head;
			String s="";
			while(tmp!=null)
			{
				if(tmp.coof>0)
				{
					s+=tmp.coof;
					
					if(tmp.power>0)
					{
						s+="x^"+tmp.power+"+";
					}
				}
				
				tmp=tmp.next;
			}
			System.out.println(s);
		}
}


