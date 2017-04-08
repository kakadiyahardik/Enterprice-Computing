package Week6_2;
import java.util.Scanner;

class CardQueue
{
	int []qu;
	int front=-1,rear=-1;
	
	CardQueue(int l)
	{
		qu=new int[l];
	}
	
	void enqueue(int val)
	{
		if(front==-1 && rear==-1)
		{
			front=rear=0;
			qu[rear]=val;
		}
		else if(rear==qu.length-1 && front>0)
		{
			rear=0;
			qu[rear]=val;
			
		}
		else if(rear==front-1 || (front == 0 && rear==qu.length-1))
		{
			System.out.println("Over flow");
		}
		else
		{
			rear++;
			qu[rear]=val;
		}
	}
	
	int dequeue()
	{
		int c;
		if(front==-1 && rear==-1)
		{
			c=-1;
			System.out.println("underflow");
		}
		else if(front==rear)
		{
			c=qu[front];
			front=rear=-1;
		}
		if(front==qu.length-1)
		{
			c=qu[front];
			front=0;
			
		}
		else
		{
			c=qu[front];
			front++;
		}
		return c;
	}
}

public class CardRotation {
	
	public static void main(String... arg)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number:");
		int n=sc.nextInt();
		int ele;
		
		CardQueue q=new CardQueue(n);
		
		for(int i=1;i<=n;i++)
		{
			q.enqueue(i);
		}
		
		for(int i=1;i<=n;i++)
		{
			
			for(int j=1;j<=i;j++)
			{
				ele=q.dequeue();
				q.enqueue(ele);
			}
			
			System.out.println(q.dequeue()+" ");
		}
		
		sc.close();
	}
}
