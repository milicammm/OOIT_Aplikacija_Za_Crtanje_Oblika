package geometry;

public class Point {

	private int x;
	private int y;
	private boolean selected; 
	
	public double distance(int x1, int y1) {
		int dx= x1-x;
		int dy= y1-y;
		double d= Math.sqrt(dx*dx+dy*dy);
		return d;
	}
	
	//Metode pristupa 
	 
	public int getX()
	{ 
		return x;
	}
	public void setX(int newX) {
		
		x=newX;
	}
	
	public int getY()
	{ 
		return y;
	}
	public void setY(int newY)
	{
		y=newY;
	}
	
	public boolean isSelected()
	{ 
		return selected;
	}
	public void setSelected(boolean newSelected)
	{
	  selected= newSelected;
	}
}
