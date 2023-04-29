package geometry;

import java.awt.Graphics;

public class Line extends Shape {
	
	private Point startPoint;
	private Point endPoint;
	
	
	public 	Line()
	{
		
	}
	public Line(Point startPoint, Point endPoint)
	{
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	public Line(Point startPoint, Point endPoint, boolean selected)
	{
		this(startPoint, endPoint);
		this.selected=selected;
	}
	
	public double length() {
		
		return startPoint.distance(endPoint.getX(),endPoint.getY());
	}
	
	public String toString() {
		return startPoint +"-->"+ endPoint; // (x,y)-->(xEnd,yEnd)
	}
	
	//Override - Redefinisanje metode equals
	
	public boolean equals(Object obj) {
		
		if(obj instanceof Line) {
			Line pomocna=(Line) obj;
			if(this.startPoint.equals(pomocna.startPoint)&& 
					endPoint.equals(pomocna.endPoint))
				return true;
			else
				return false;
			
		}else
			return false;
	}
	
	//Metoda contains za selektovanje da li  sadrzi ili ne
	
		public boolean contains(int x,int y) {
			return startPoint.distance(x, y)+ endPoint.distance(x, y) - length() <=2; 
			// metoda preko nekog trougla kao nesto komplikovano
		}

  //METODE PRISTUPA 
	 
   public Point getStartPoint()
   {
	   return startPoint;
   }
   
   public void setStartPoint(Point startPoint)
   {
	   this.startPoint =startPoint;
   }
   
   public Point getEndPoint()
   {
	   return endPoint;
   }
   
   public void setEndPoint(Point endPoint)
   {
	   this.endPoint= endPoint;
   }
	
	//Crtanje linje
	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(),startPoint.getY(),endPoint.getX(),endPoint.getY());
		
	}
	
	
}
