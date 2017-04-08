package Chess;
import java.util.*;

public class NqueenProblem 
{

	public static boolean fnd;
	    
	    public static boolean safe(int ch[][],int row,int col,int n)
	    {
	        int i,j;
	        
	        for(i=0;i<col;i++)
	        {
	            if(ch[row][i]==1)
	                return false;
	        }
	        
	        for(i=row,j=col; i>=0 && j>=0;i--,j--)
	        {
	            if(ch[i][j]==1)
	                return false;
	        }
	        
	        for(i=row,j=col;i<n && j>=0;i++,j--)
	        {
	            if(ch[i][j]==1)
	                return false;
	        }
	        return true;
	    }
	    
	    public static void solve(int ch[][],int col,int n)
	    {
	        if(col>=n)
	        {
	             StringBuilder s=new StringBuilder();
	             fnd=true;
	             s.append("[");
	    		
	    		    for(int j=0;j<n;j++)
	    		    {
	    		        for(int k=0;k<n;k++)
	    		        {
	    		            if(ch[k][j]==1)
	    		            {
	    		                s.append(k+1+" ");
	    		            }
	    		        }
	    		    }
	    		    s.append("] ");
	    		    System.out.print(s.toString());
	        }
	        else
	        {
	            for(int i=0;i<n;i++)
	            {
	                if(safe(ch,i,col,n))
	                {
	                    ch[i][col]=1;
	                    solve(ch,col+1,n);
	                    ch[i][col]=0;
	                }
	            }
	        }
	    }
	    
		public static void main (String[] args)
		{
			
			Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();
			
			for(int i=0;i<t;i++)
			{
			    int n=sc.nextInt();
			    int ch[][]=new int[n][n];
			    fnd=false;
			    solve(ch,0,n);
			     
	    		if(!fnd)
			        System.out.print(-1);
			        
			    System.out.print("\n");
			}
			sc.close();
		}
	
}
