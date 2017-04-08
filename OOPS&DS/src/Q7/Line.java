package Q7;

import java.util.ArrayList;

public class Line {
	
	ArrayList<Point> al=new ArrayList<Point>();
	Point []pc=new Point[2];
	void setCod(int x,int y)
	{
		Point p=new Point(x,y);
		al.add(p);
	}
	
	double computeLength()
	{
		int i=0;
		double dis;
		for(Point p:al)
		{
			pc[i]=p;
			i++;
		}
		dis=Math.sqrt((pc[0].x-pc[1].x)*(pc[0].x-pc[1].x)+(pc[0].y-pc[1].y)*(pc[0].y-pc[1].y));
		return dis;
	}
	
	boolean isParallel(Line l)
	{
		return true;
	}
}
