package Q5;

public class Question {
	public String q;
	public String[] op1;
	public char an;
	
	Question(String q,String op,char an)
	{
		this.q=q;
		this.op1=op.split("\n");
		
		this.an=an;
	}

}
