package Graph;

public class Graph {
	int v;
	AdjList arr[];
	
	Graph(int v)
	{
		this.v=v;
		this.arr=new AdjList[v];
		
		for(int i=0;i<v;i++)
		{
			this.arr[i].head=null;
		}
	}
}
