package Graph;
import java.util.HashMap;
import java.util.LinkedList;

class List
{
	HashMap<Integer,LinkedList<Integer>> vt=new HashMap<>();
	LinkedList<Integer> l=new LinkedList<>();
	
	void addAdge(int i,int j)
	{
		if(!vt.containsKey(i))
		{
			vt.put(i, new LinkedList<>());
		}
		if(!vt.containsKey(j))
		{
			vt.put(j, new LinkedList<>());
		}
		
		l=vt.get(i);
		l.add(j);
		vt.put(i,l);
		
		l=vt.get(j);
		l.add(i);
		vt.put(j,l);
	}
	
	void display()
	{
		for(int i=0;i<5;i++)
		{
			if(vt.containsKey(i))
			{
				l=vt.get(i);
				System.out.println(i+": "+l);
				//l.clear();
			}
		}
	}
}

public class GraphUsingList {
	public static void main(String []arg)
	{
		List m=new List();
		
		m.addAdge(0,1);
		m.addAdge(0,4);
		m.addAdge(1,2);
		m.addAdge(1,3);
		m.addAdge(1,4);
		m.addAdge(2,3);
		m.addAdge(3,4);
		
		m.display();
	}
}
