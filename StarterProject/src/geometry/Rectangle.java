package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int width;
	private int height;
 
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height) {
		
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
		this.selected = selected;
	}

	//POVRSINA PRAVOUGAONIKA P=width*height
	 
	public int area()
	{
		return width*height;
	}
	
	//OBIM PRAVOUGAONIKA O=2*(width+height)
	
	public int circumference()
	{
		return 2*(width+height);
	}
	
	public String toString() {
		return "Upper left point:" + upperLeftPoint + ", width: "+ width +", height: "+ height;
		// Upper left point (x,y), width: width, height: height
	}
	
	// Override - Redefinisanje metode equals
	
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle){
			Rectangle pomocna=(Rectangle) obj;
			if(this.upperLeftPoint.equals(pomocna.upperLeftPoint)&& width==pomocna.width && height==pomocna.height)
				return true;
			else
				return false; 
		}else
			return false;
	}
	
	//Metoda contains za selektovanje da li  sadrzi ili ne
	
		public boolean contains(int x,int y) {
			return (x >= upperLeftPoint.getX()
					&& x<= upperLeftPoint.getX()+width 
					&& y>= upperLeftPoint.getY() 
					&& y<= upperLeftPoint.getY() + height);
		}
		
	//METODE PRISTUPA 
	
	public Point getUpperLeftPoint()
	{
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint)
	{
		this.upperLeftPoint=upperLeftPoint;
	}
	
	public int getWidth()
	{
		return width;
	}
	

	public void setWidth(int width)
	{
		this.width=width;
	}
	
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
	    this.height=height;	
	}

	//Crtanje pravougaonika
	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		
	}
	
	
	
	
	
}

