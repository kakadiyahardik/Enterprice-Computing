package RookieRank2;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Knight
{
    static Position increment=new Position(-1,-1);
    static class Position
    {
        int x;
        int y;
        
        Position(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
        
        public boolean equaleTo(Position p)
        {
            return (this.x==p.x && this.y==p.y);
        }
    }
    
    public static boolean isSafe(boolean [][]board,Position p)
    {
        return (p.x>0 && p.x<board[0].length && p.y>0 && p.y<board[0].length);
    }
    
    public static int solve(boolean [][]board,Position s,Position d,int a,int b)
    {
        Queue<Position> q=new LinkedList<Position>();
        
        q.add(s);
        q.add(increment);
        int moves=0;
        while(q.size()>1)
        {
            Position tmp=q.poll();
            
            if(tmp.equaleTo(increment))
            {
                moves++;
                q.add(increment);
            }
            else if(tmp.equaleTo(d))
            {
                return moves;
            }
            else
            {
                Position nn=new Position(tmp.x+a,tmp.y+b);
                if(isSafe(board,nn))
                {
                    q.add(nn);
                    board[nn.x][nn.y]=true;
                }
                
                nn=new Position(tmp.x+a,tmp.y-b);
                if(isSafe(board,nn))
                {
                    q.add(nn);
                    board[nn.x][nn.y]=true;
                }
                
                nn=new Position(tmp.x-a,tmp.y+b);
                if(isSafe(board,nn))
                {
                    q.add(nn);
                    board[nn.x][nn.y]=true;
                }
                
                nn=new Position(tmp.x-a,tmp.y-b);
                if(isSafe(board,nn))
                {
                    q.add(nn);
                    board[nn.x][nn.y]=true;
                }
                
                nn=new Position(tmp.x+b,tmp.y+a);
                if(isSafe(board,nn))
                {
                    q.add(nn);
                    board[nn.x][nn.y]=true;
                }
                
                nn=new Position(tmp.x+b,tmp.y-a);
                if(isSafe(board,nn))
                {
                    q.add(nn);
                    board[nn.x][nn.y]=true;
                }
                
                nn=new Position(tmp.x-b,tmp.y+a);
                if(isSafe(board,nn))
                {
                    q.add(nn);
                    board[nn.x][nn.y]=true;
                }
                
                nn=new Position(tmp.x-b,tmp.y-a);
                if(isSafe(board,nn))
                {
                    q.add(nn);
                    board[nn.x][nn.y]=true;
                }
            }
        }
        return -1;
    }
    
        
    

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result[][]=new int[n][n];
        boolean board[][]=new boolean[n+1][n+1];
        for(int i=1;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                
        
                int x=solve(board,new Position(1,1),new Position(n,n),i,j);
               result[i][j]=x;
               result[j][i]=x;
               // System.out.println(result[i][j]+" "+i+" "+j);
                System.out.println(x);
            }
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<n;j++)
            {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}

