package geometry;

import java.awt.Graphics;
import java.awt.Color;

public class Circle extends Shape {
	
	private Point center;
	private int radius;
	
	//KONSTRUKTORI
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center=center;
        this.radius=radius;
 
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected=selected;
	}
	
	
	//POVRSINA KRUGA (P=r^2PI)
	public double area()
	{
		return radius*radius*Math.PI;
	}
	
	//OBIM KRUGA (O=2*r*PI)
	public double circumference()
	{
		return 2*radius*Math.PI;
	}
	
	//REDEFINISANJE toString
	
	public String toString() {
		return "Center: " +center+ ", radius= "+ radius;// Center: (c,cd), radius= hdd
	}
	
	// Override - Redefinisanje metode equals 
	public boolean equals (Object obj)
	{
		if( obj instanceof Circle)
		{
			Circle pomocna= (Circle) obj;
			
			if(this.center.equals(pomocna.center)&& this.radius==pomocna.radius)
				return true;
			else 
				return false;
		}  
		else 
			return false;
		
	}
	
	//Metoda contains za selektovanje da li sadrzi ili ne
	
		
		public boolean contains (int x, int y){
			return center.distance(x, y)<=radius; //udaljenost centra <= od poluprecnika
		}
		 
	
		public boolean contains (Point p) {
			return center.distance(p.getX(),p.getY())<=radius ;
		}
		// mozemo da imamo 2 metode sa istim nazivom al se liste parametara moraju razlikovati -OVERLOADING
	
		
		
	//METODE PRISTUPA GET I SET
	
	public Point getCenter()
	{
		return center;
	}
	public void setCenter(Point center)
	{
		this.center=center;
		
	}
	
	public int getRadius()
	{
		return radius;
	}
	/*public void setRadius(int radius)
	{
		this.radius=radius;
	}*/
	
	//Redefinisano iz 8 vezbe
	
	public void setRadius(int radius) throws Exception
	{
		if(radius <0)
			throw new Exception("Radius ne moze biti negativan broj!");
		this.radius=radius;
	}
	
   //SELECTED SMO OBRISALI 	
	
	//Crtanje kruga
	//Parametre gledamo kao delove kvadrata opisanog oko kruga
	@Override
	public void draw(Graphics g)
	{
		g.setColor(Color.black);
		g.drawOval(center.getX()-radius, 
				center.getY()-radius, 2*radius, 2*radius);
		
		if(selected)
		{
			g.setColor(Color.blue);
			g.drawRect(center.getX()-2,center.getY()-2,4,4);
			g.drawRect(center.getX()-radius-2, center.getY()-2, 4, 4);
			g.drawRect(center.getX()+radius-2,center.getY()-2,4,4);
			g.drawRect(center.getX()-2, center.getY()-radius-2, 4, 4);
			g.drawRect(center.getX()-2,center.getY()+radius-2,4,4);
			
		}
	}
	
	//Vezba 7 interfejsi
	
	// Moveable 
	
	public void moveTo(int x, int y) {
		this.center.moveTo(x, y);
		
	}
	
	public void moveBy(int byX, int byY)
	{
		this.center.moveBy(byX, byY);
	}
	
	//Comparable
	
	public int compareTo(Object o) 
	{
		if(o instanceof Circle)
			return (int) (this.area()- ((Circle)o).area());
		return 0;
					
	}
	
	
	
}


