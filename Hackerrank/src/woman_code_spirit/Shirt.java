package woman_code_spirit;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Shirt {

	public static void main(String[] args)throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int q=Integer.parseInt(br.readLine());
		
		while(q-->0)
		{
			TreeMap<Integer,Integer> tm=new TreeMap<>();
			int cnt=0;
			
			int n=Integer.parseInt(br.readLine());
			String val[]=br.readLine().split(" ");
			int shirt[]=new int[n];
			int max=0;
			for(int i=0;i<n;i++)
			{
				shirt[i]=Integer.parseInt(val[i]);
				
				if(shirt[i]>max)
					max=shirt[i];
				
			}
			boolean st[]=new boolean[max+2];
			
			for(int i=0;i<n;i++)
				st[shirt[i]]=true;
			
			int v=Integer.parseInt(br.readLine());
			
			for(int i=0;i<v;i++)
			{
				val=br.readLine().split(" ");
				tm.put(Integer.parseInt(val[0]),Integer.parseInt(val[1]));
			}
			
			Set<Entry<Integer, Integer>> entry=tm.entrySet();
			
			Iterator i=entry.iterator();
			int s=0,l=0;
			while(i.hasNext())
			{
				Entry<Integer,Integer> rn=(Entry<Integer, Integer>) i.next();
				
				if(l>=rn.getValue())
					continue;
				if(rn.getKey()>max)
					break;
				if(l>=rn.getKey())
				{
					s=l+1;
				}
				else
				{
					s=rn.getKey();					
				}
				
				l=rn.getValue();
				
				for(int in=s;in<=l;in++)
				{
					if(st[in]==true)
						cnt++;
				}
			}
			
			System.out.println(cnt);
		}
		
		/*TreeMap<Integer,Integer> tm=new TreeMap<>();
		
		tm.put(1,10);
		tm.put(10,100);
		tm.put(5, 50);
		tm.put(4, 40);
		
		Set<Entry<Integer, Integer>> entry=tm.entrySet();
		
		Iterator i=entry.iterator();
		
		while(i.hasNext())
		{
			Entry<Integer,Integer> rn=(Entry<Integer, Integer>) i.next();
			System.out.println(rn.getKey()+" "+rn.getValue());
		}*/
	}

}
