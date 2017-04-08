package Q5;

import java.util.HashMap;
import java.util.Scanner;

public class Quiz {

	private String q;
	private String op1;//,op2,op3,op4;
	private char an;
	
	HashMap<Integer,Question> data=new HashMap<Integer,Question>();
	static int cnt=0;
	
	Quiz()
	{
		cnt++;
		q="What is the size of boolean variable?";
		op1="8 bit";
		op1+="\n16 bit ";
		op1+="\n32 bit ";
		op1+="\nNone of the above";
		an='b';
		Question t=new Question(q,op1,an);
		this.data.put(cnt, t);
		
		cnt++;
		q="What is the default value of short variable?";
		op1="0.0 ";
		op1+="\n0 ";
		op1+="\nNull ";
		op1+="\nUndefine ";
		an='a';
		Question t2=new Question(q,op1,an);
		this.data.put(cnt, t2);
		
		cnt++;
		q="What is the default value of Object variable?";
		op1="undefine";
		op1+="\n0";
		op1+="\nNull";
		op1+="\nNot define";
		an='c';
		Question t3=new Question(q,op1,an);
		this.data.put(cnt, t3);
		
		cnt++;
		q="Method Overloading is an example of";
		op1="Dynamic Binding.";
		op1+="\nStatic Binding.";
		op1+="\nboth";
		op1+="\nnone of above";
		an='b';
		Question t4=new Question(q,op1,an);
		this.data.put(cnt, t4);
		
	}
	
	void giveQuiz()
	{
		int k=1;
		int m=0;
		char ans;
		Scanner scan=new Scanner(System.in);
		while(data.containsKey(k))
		//for(Question tm:data)
		{
			Question tm=(Question)this.data.get(k);
			System.out.println("["+k+"] "+tm.q);
			
			char in='a';
			for(int i=0;i<tm.op1.length;i++)
			{
				System.out.print("\t["+in+"] ");in++;
				System.out.println(tm.op1[i]);
			}
			System.out.println("............................................");
			System.out.println("Enter answer(in form of single character like a)::");
			ans=scan.nextLine().charAt(0);
			
			if(ans==tm.an)
			{
				//System.out.println(tm.an);
				m++;
			}
			
			k++;
			System.out.println("______________________________________________");
		}
		System.out.println("Your mark is:: "+m);//sc.next();
		
		//scan.close();
		
	}
	
	void addQuestion(String q,String op,char an)
	{
			cnt++;
			Question aq=new Question(q,op,an);
			this.data.put(cnt, aq);
	}
}
