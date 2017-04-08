package WEEK8_1;

import java.util.Scanner;

public class Polynomial {
	
	public static int add(int x,SinglyLinkedList s1,SinglyLinkedList s2)
	{
		PolyNode h1=s1.head;
		PolyNode h2=s2.head;
		
		String s="";
		int sum,ans=0,local=0;
		
		while(h1!=null)
		{
			local=0;
			sum=h1.coof+h2.coof;
			
			if(sum>0)
			{
				s+=sum;
				local+=sum;
				
				if(h1.power==h2.power &&(h1.power>0 || h2.power>0))
				{
					local*=Math.pow(x,h1.power);
					s+="x^"+h1.power+"+";
				}
			}
			h1=h1.next;
			h2=h2.next;
			ans+=local;
		}
		System.out.println(s);
		return ans;
	}
	
	public static void sub(SinglyLinkedList s1,SinglyLinkedList s2)
	{
		PolyNode h1=s1.head;
		PolyNode h2=s2.head;
		
		String s="";
		int sum;
		
		while(h1!=null)
		{
			sum=h2.coof-h1.coof;
			if(sum!=0)
			{
				s+=sum;
				
				if(h1.power==h2.power &&(h1.power>0 || h2.power>0))
				{
					s+="x^"+h1.power+"+";
				}
			}
			h1=h1.next;
			h2=h2.next;
		}
		System.out.println(s);
	}
	
	public static void main(String[] ar)
	{
		Scanner sc=new Scanner(System.in);
		SinglyLinkedList s1=new SinglyLinkedList();
		SinglyLinkedList s2=new SinglyLinkedList();
		
		int n;
		int cf,pw;
		n=sc.nextInt();
		int x;
		
		for(int i=0;i<n;i++)
		{
			cf=sc.nextInt();
			pw=sc.nextInt();
			s1.insert(cf,pw);
		}
		
		System.out.println("second");
		n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			cf=sc.nextInt();
			pw=sc.nextInt();
			s2.insert(cf,pw);
		}
		x=sc.nextInt();
		s1.display();
		int ans=add(x,s1,s2);
		sub(s1,s2);
		System.out.println(ans);
		sc.close();
	}
}
