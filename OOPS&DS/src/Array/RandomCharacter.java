package Array;
import java.util.Random;

class RandomCharacter
{
	public static void main(String []arg)
	{
		Random r=new Random();
		int i,j,cnt;
		double mean=0.0,sum=0,d=0;
		char []ch=new char[100];
		int []occur=new int[26];
		char check;
		
		for(i=0;i<100;i++)
		{
			ch[i]=String.valueOf(Character.toChars(r.nextInt(26)+97)).charAt(0);
		}
		
		for(i=0;i<26;i++)
		{
			check=String.valueOf(Character.toChars(i+97)).charAt(0);
			cnt=0;
			for(j=0;j<100;j++)
			{
				if(check==ch[j])
				{
					cnt++;
				}
			}
			occur[i]=cnt;
			mean+=cnt;
		}
		mean=mean/26;
		
		for(i=0;i<occur.length;i++)
		{
			d=occur[i]-mean;
			sum+=(d*d);
		}
		sum=sum/25;
		System.out.printf("Deviation is :: %.2f",Math.sqrt(sum));
	}
}