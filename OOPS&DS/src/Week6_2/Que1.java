package Week6_2;
import java.util.Scanner;

class QueueArray
{
	int []qu;
	int front=-1,rear=-1;
	
	QueueArray(int l)
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
		else if(rear>=qu.length-1)
		{
			System.out.println("Queue is overflow");
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
		else
		{
			c=qu[front];
			front++;
		}
		return c;
	}
	
	void display()
	{
		if(front==-1 &rear==-1)
		{
			System.out.println("Queue is empty");
		}
		else
		{
			for(int i=front;i<=rear;i++)
			{
				System.out.print(qu[i]+" ");
			}
		}
		System.out.println();
	}
}
public class Que1 {
	
	public static void main(String... arg)
	{
		Scanner sc=new Scanner(System.in);
		int ch=1,val;
		System.out.println("How many number you want enter:");
		int n=sc.nextInt();
		QueueArray q=new QueueArray(n);
		
		while(ch!=0)
		{
			System.out.println("------------------------");
			System.out.println("[1] enqueu");
			System.out.println("[2] dequeue");
			System.out.println("[3] Display");
			System.out.println("------------------------");
			
			System.out.println("Enter your choice:");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				
				System.out.println("Enetr value you want to enter:");
				val=sc.nextInt();
				q.enqueue(val);
				break;
			
			case 2:
			    q.dequeue();
				break;
			
			case 3:
				q.display();
				break;
				
			}
		}
		sc.close();
	}
}
