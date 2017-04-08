package woman_code_spirit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Choclate {
	
	public static void main(String... arg)throws Exception
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		String str[]=bf.readLine().split(" ");
		int ch[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			ch[i]=Integer.parseInt(str[i]);
		}
		
		str=bf.readLine().split(" ");
		int d=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		int f=0,s=0,sum=0;
		int cnt=0;
		
		for(s=0;s<m && s<n;s++)
		{
			sum+=ch[s];
		}
		if(sum==d)
			cnt++;
		
		for(;s<n;s++)
		{
			sum+=ch[s];
			sum-=ch[f];
			
			if(sum==d)
				cnt++;
			
			f++;
		}
		System.out.println(cnt);
	}
}
