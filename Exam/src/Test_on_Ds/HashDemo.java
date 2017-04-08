package Test_on_Ds;
import java.util.HashMap;

public class HashDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Character,Integer> h=new HashMap<>();
		
		
		h.put('a', 1);
		h.put('b', 2);
		h.put('c', 3);
		h.put('d', 4);
		h.put('f', null);
		
		int s=h.size();
		
		for(int i=0;i<s;i++)
		{
			System.out.println(h.keySet().toArray()[i]);
		}
	}

}
