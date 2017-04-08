package TestComplexity;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Time {

	public static void main(String[] args)
	{
		 Scanner sc=new Scanner(System.in);
	     Random r=new Random();
	     String s="";
		 long str;//=System.currentTimeMillis();
	        int n=100000;
	        int a[]=new int[n];
	        
	        for(int i=0;i<n;i++)
	        {
	            a[i]=100;
	            s+=a[i]+" ";
	        }
	    long end=System.currentTimeMillis();
	    
	    String nn[]=s.split(" ");
	    str=System.currentTimeMillis();
	    System.out.println(n);
	    System.out.println(str-end);
	 }

}
