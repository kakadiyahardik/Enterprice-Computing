package Chess;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
		
		public boolean compareTo(Position p)
		{
			return (this.x==p.x && this.y==p.y);
		}
	}
	
	public static boolean isSafe(boolean [][]board,Position p)
	{
		return (p.x>0 && p.x < board.length && p.y>0 && p.y<board[0].length && !board[p.x][p.y]);
	}
	
	public static int solve(boolean board[][],Position src,Position des)
	{
		
		Queue<Position> q=new LinkedList<Position>();
		int moves=0;
		q.add(src);
		q.add(increment);
		
		while(q.size()>1)
		{
			Position tmp=q.poll();
			
			if(tmp.compareTo(increment))
			{
				moves++;
				q.add(increment);
			}
			else if(tmp.compareTo(des))
			{
				return moves;
			}
			else
			{
				Position ch=new Position(tmp.x-1,tmp.y+2);
				if(isSafe(board,ch))
				{
					q.add(ch);
					board[ch.x][ch.y]=true;
				}
				
				ch=new Position(tmp.x+1,tmp.y+2);
				if(isSafe(board,ch))
				{
					q.add(ch);
					board[ch.x][ch.y]=true;
				}
				
				ch=new Position(tmp.x+1,tmp.y-2);
				if(isSafe(board,ch))
				{
					q.add(ch);
					board[ch.x][ch.y]=true;
				}
				
				ch=new Position(tmp.x-1,tmp.y-2);
				if(isSafe(board,ch))
				{
					q.add(ch);
					board[ch.x][ch.y]=true;
				}
				
				ch=new Position(tmp.x+2,tmp.y-1);
				if(isSafe(board,ch))
				{
					q.add(ch);
					board[ch.x][ch.y]=true;
				}
				
				ch=new Position(tmp.x+2,tmp.y+1);
				if(isSafe(board,ch))
				{
					q.add(ch);
					board[ch.x][ch.y]=true;
				}
				
				ch=new Position(tmp.x-2,tmp.y+1);
				if(isSafe(board,ch))
				{
					q.add(ch);
					board[ch.x][ch.y]=true;
				}
				
				ch=new Position(tmp.x-2,tmp.y-1);
				if(isSafe(board,ch))
				{
					q.add(ch);
					board[ch.x][ch.y]=true;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			
			int sx=sc.nextInt();
			int sy=sc.nextInt();
			
			int dx=sc.nextInt();
			int dy=sc.nextInt();
			
			boolean board[][]=new boolean[n+1][m+1];
			
			System.out.println(solve(board,new Position(sx,sy),new Position(dx,dy)));
		}
		sc.close();
	}

}
