package woman_code_spirit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gift {
	public static void main(String...strings)throws Exception
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String gift[]={"..O..","O.o.O"};
		String val[]=bf.readLine().split(" ");
		int r=Integer.parseInt(val[0]);
		int c=Integer.parseInt(val[1]);
		
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				System.out.print(gift[0]);
			}
			System.out.println();
			for(int j=0;j<c;j++)
			{
				System.out.print(gift[1]);
			}
			System.out.println();
			for(int j=0;j<c;j++)
			{
				System.out.print(gift[0]);
			}
			System.out.println();
		}
	}

}
