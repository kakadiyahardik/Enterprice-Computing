package Graph;

class Matrix
{
	boolean [][]a;
	int v;
	
	Matrix(int v)
	{
		this.v=v;
		a=new boolean[this.v][this.v];
	}
	
	void addAdge(int i,int j)
	{
		a[i][j]=true;
		a[j][i]=true;
	}
	
	void display()
	{
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(a[i][j])
				{
					System.out.print("1 ");
				}
				else
				{
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
}
public class GraphUsingMatrix {
	
	
	public static void main(String []a)
	{
		Matrix m=new Matrix(5);
		
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
