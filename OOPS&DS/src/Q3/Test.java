package Q3;

import java.util.Scanner;

class ComplexNumber{
	
	int r,i;
	int x;
	void setnumber(int a,int b){
		r=a;
		i=b;
	}
	
	ComplexNumber add(ComplexNumber c1, ComplexNumber c2){
		ComplexNumber c3=new ComplexNumber();
		c3.r=c1.r+c2.r;
		c3.i=c1.i+c2.i;
		return c3;
	}
	
	ComplexNumber sub(ComplexNumber c1, ComplexNumber c2){
		ComplexNumber c3=new ComplexNumber();
		c3.r=c1.r-c2.r;
		c3.i=c1.i-c2.i;
		return c3;
	}
	
	ComplexNumber mul(ComplexNumber c1, ComplexNumber c2){
		ComplexNumber c3=new ComplexNumber();
		
		c3.r=c1.r*c2.r;
		c3.i=(c1.r*c2.i)+(c1.i*c2.r);
		c3.x=c1.i*c2.i;
		return c3;
	}
	
	ComplexNumber div(ComplexNumber c1, ComplexNumber c2){
		ComplexNumber c3=new ComplexNumber();
		c3.r=c1.r/c2.r;
		c3.i=c1.i/c2.i;
		return c3;
	}
}

class Test{
	
	public static void main(String args[]){
		
		Scanner s=new Scanner(System.in);
		
		int ch=1;
		
		while(ch!=0){
			System.out.println("Enter 1st Complex Number (real imaginary)");
			int r=s.nextInt();
			int i=s.nextInt();
			
			ComplexNumber obj1=new ComplexNumber();
			obj1.setnumber(r, i);
			
			System.out.println("Enter 2nd Complex Number (real imaginary)");
			r=s.nextInt();
			i=s.nextInt();
			
			ComplexNumber obj2=new ComplexNumber();
			obj2.setnumber(r, i);
			
			ComplexNumber obj3=new ComplexNumber();
			System.out.println("..................................");
			System.out.println("\n[1] Add\n[2].Sub\n[3].Mul\n[4].Div\n[0].Exit");
			System.out.println("..................................");
			
			System.out.println("Enter your choice:: ");
			int choice=s.nextInt();
			
			switch(choice)
			{
			case 1:
				obj3=obj3.add(obj1,obj2);
				
				break;
			case 2:
				obj3=obj3.sub(obj1, obj2);
				break;
			case 3:
				obj3=obj3.mul(obj1, obj2);
				break;
			case 4:
				obj3=obj3.div(obj1, obj2);
				break;
			}
			
			if(obj3.i>=0 && choice > 3)
			{
				System.out.println(obj3.r +"+"+ obj3.i+"i");
			}
			else if(choice > 3)
			{
				System.out.println(obj3.r +""+ obj3.i+"i");
			}
			
			if(choice==3)
			{
				System.out.println(obj3.r +"+"+ obj3.i+"i+"+obj3.x+"ii");
			}
			
			
			System.out.println("Do you want to continue 1/0");
			
			ch=s.nextInt();
				
		}
		s.close();
	}
}