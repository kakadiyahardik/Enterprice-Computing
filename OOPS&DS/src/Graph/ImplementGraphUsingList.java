package Graph;

public class ImplementGraphUsingList {
	public static void main(String... ar)
	{
		int v=5;
		Graph graph=new Graph(v);
		
		GraphOperation gp=new GraphOperation();
		
		gp.addAdge(graph,0,1);
		gp.addAdge(graph,0,4);
		gp.addAdge(graph,1,2);
		gp.addAdge(graph,1,3);
		gp.addAdge(graph,1,4);
		gp.addAdge(graph,2,3);
		gp.addAdge(graph,3,4);
		
		//gp.printGraph(graph);
	}
}
