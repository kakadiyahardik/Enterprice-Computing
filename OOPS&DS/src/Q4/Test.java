package Q4;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		Bank b=new Bank();
		int ch=0;
		
		while(ch!=-1)
		{
			System.out.println("..................Well-come......................");
			System.out.println("[1] Create Account::");
			System.out.println("[2] Deposit::");
			System.out.println("[3] Withdraw(22 charges)::");
			System.out.println("[4] Delete account::");
			System.out.println("[5] Balance inquiry");
			System.out.println("[-1] Exit::");
			System.out.println(".................................................");
			System.out.println("Enter your choice::");
			ch=sc.nextInt();
			
			switch(ch)
			{
			
				case 1:
					System.out.println("Enter Account no::");
					long ac=sc.nextLong();
					System.out.println("Enter amount");
					double bl=sc.nextDouble();
					sc.nextLine();
					System.out.println("Enter your name::");
					String nm=sc.nextLine();
					
					b.createAccoutnt(ac, bl, nm);
					System.out.println("::Account created::");
				break;
				
				case 2:
					System.out.println("Enter Account no");
					long dac=sc.nextLong();
					System.out.println("Enter amount");
					double dbl=sc.nextDouble();
					sc.nextLine();
					double d=b.deposit(dac, dbl);
					System.out.println("Clear Balance::"+d);
				break;
				
				case 3:
					System.out.println("Enter Account no");
					long wac=sc.nextLong();
					System.out.println("Enter amount");
					double wbl=sc.nextDouble();
					sc.nextLine();
					double w=b.withdraw(wac, wbl);
					System.out.println("Clear Balance::"+w);
				break;
				
				case 4:
					System.out.println("Enter Account no");
					long del=sc.nextLong();
					b.deleteAc(del);
				break;
				
				case 5:
					System.out.println("Enter Account no");
					long dis=sc.nextLong();
					b.display(dis);
				break;
				
				default:
					System.out.println("Enter correct choice::");
				break;
			}
		}
		sc.close();
	}
}
