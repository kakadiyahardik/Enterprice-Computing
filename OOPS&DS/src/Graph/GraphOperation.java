package Graph;

public class GraphOperation {

	void addAdge(Graph graph,int src,int des)
	{
		AdjListNode nn=new AdjListNode(des);
		nn.next=graph.arr[src].head;
		graph.arr[src].head=nn;
		
		nn=new AdjListNode(src);
		nn.next=graph.arr[des].head;
		graph.arr[src].head=nn;
		
	}
	
	/*void printGraph(Graph graph)
	{
		for(int v=0;v<graph.v;v++)
		{
			AdjListNode pc=graph.arr[v].head;
			System.out.println("Adjacency list of vertex head "+v);
			
			while(pc!=null)
			{
				System.out.print("->"+pc.des);
				pc=pc.next;
			}
			System.out.println();
		}
	}*/
}
