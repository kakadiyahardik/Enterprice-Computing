package Week6_2;
import java.util.Scanner;

class BinaryQueue
{
	String []qu;
	int front=-1,rear=-1;
	
	BinaryQueue(int l)
	{
		qu=new String[l+1];
	}
	
	void enqueue(String val)
	{
		if(front==-1 && rear==-1)
		{
			front=rear=0;
			qu[rear]=val;
		}
		else if(rear>=qu.length-1)
		{
			//System.out.println("Queue is overflow");
		}
		else
		{
			rear++;
			qu[rear]=val;
		}
	}
	
	String dequeue()
	{
		String c;
		if(front==-1 && rear==-1)
		{
			c="0";
			System.out.println("underflow");
		}
		else if(front==rear)
		{
			c=qu[front];
			front=rear=-1;
		}
		else
		{
			c=qu[front];
			front++;
		}
		return c;
	}
}

public class BinaryUsinQueue {

	public static void main(String... arg)
	{
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("Enter number:");
		n=sc.nextInt();
		BinaryQueue q=new BinaryQueue(n);
		String fs;
		
		for(int i=0;i<n;)
		{
			if(q.front==-1 && q.rear==-1)
			{
				q.enqueue("1");
			}
			else
			{
				fs=q.dequeue();
				q.enqueue(fs+"0");
				q.enqueue(fs+"1");
				System.out.println(fs);
				i++;
			}
		}
		
		sc.close();
	}
}
