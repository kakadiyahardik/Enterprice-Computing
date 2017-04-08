package Q5;
import java.util.*;

public class QuizTime {
	public static void main(String []args)
	{
		Quiz qz=new Quiz();
		Scanner sc=new Scanner(System.in);
		String q;
		String op="";
		char an;
		int ch=0;
		
		while(ch!=3)
		{
			System.out.println(".....................................");
			System.out.println("[1] Add question::");
			System.out.println("[2] Give quiz::");
			System.out.println("[3] Exit::");
			System.out.println(".....................................");
			System.out.println("::Enter your choice::");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter Question::");
				q=sc.next();q=sc.nextLine();
				System.out.println("Enter option(4)::");
				for(int i=0;i<4;i++)
				{
					System.out.printf("Enter option %c::",(i+65));
					op+=sc.nextLine()+"\n";
				}
				
				System.out.print("Enter Answer in form of single character (like a)::");
				an=sc.nextLine().charAt(0);
				qz.addQuestion(q, op, an);
			break;
				
			case 2:
				System.out.println("Your quiz now strat");
				qz.giveQuiz();
				//System.out.println("Thank you");
			break;
			
			default:
				System.out.println("Exit");
			break;
			}
		}
		
		
		
		//qz.giveQuiz();
	
		sc.close();
	}
}
