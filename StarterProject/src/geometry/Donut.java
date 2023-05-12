package geometry;

import java.awt.Graphics;
import java.awt.Color;

//extends - nasledjivanje od nadredjene klase circle, posto se kao donut sastoji od tog kruga 
public class Donut extends Circle {
	
	private int innerRadius; //poluprecnik unutrasnjeg kruga
	
	//Konstruktori 
	public Donut() {
		
	}
	public Donut(Point center, int radius,int innerRadius) {
		super(center,radius); //nadredjena klasa Circle iz nje pozivamo vec konstruktor koji ima parametre center i radius
		this.setInnerRadius(innerRadius);
	}
	//super koristimo kada pozivamo konstruktor nadredjene klase,tamo kad smo radili sa bas konstruktorima te klase bilo je this
	
	public Donut(Point center, int radius,int innerRadius,boolean selected) {
		super(center,radius,selected); //nadredjena klasa Circle iz nje pozivamo vec konstruktor koji ima parametre center,radius i selected
		this.setInnerRadius(innerRadius);
		
	}
	//Source pa override i onda oznacimo sta nam treba 
	
	@Override
	public double area() {
		return super.area()- innerRadius *innerRadius * Math.PI;
	}
	@Override
	public double circumference() {
		return super.circumference()+2*innerRadius*Math.PI ;
	}
	
	@Override
	public String toString() {
		//Center : (x,y), radius=55, innerRadius=44
		return super.toString()+ ",innerRadius = " + innerRadius;
		}
	
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Donut) {
			Donut pomocna=(Donut)obj;
			
			if(getCenter().equals(pomocna.getCenter())
					&& this.getRadius()==pomocna.getRadius()
					&& this.innerRadius==pomocna.innerRadius) //nema zagrade jer je innerRadius ovde def a radius u circle 
				return true;
			else
				return false;
		}
		return false;
	}
	
	public boolean contains (int x, int y)
	{
		return super.contains(x,y)&& getCenter().distance(x,y)>=innerRadius;
	}
	
	public boolean contains (Point p) {
		
		return super.contains(p) && getCenter().distance(p.getX(), p.getY())>=innerRadius;
	}

	//Metode get i set moze preko source da se kreira 
	
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	//Crtanje krofne 
	@Override
	
	public void draw(Graphics g)
	{
		super.draw(g);//nacrta spoljasnji krug
		g.setColor(Color.black);
		g.drawOval(getCenter().getX()-innerRadius, getCenter().getY() -innerRadius,
				2*innerRadius, 2*innerRadius);
		
		if(selected)
		{
			g.setColor(Color.blue);
			g.drawRect(getCenter().getX()-innerRadius-2,getCenter().getY()-2,4,4);
			g.drawRect(getCenter().getX()+innerRadius-2, getCenter().getY()-2,4,4);
			g.drawRect(getCenter().getX()-2, getCenter().getY()-innerRadius,4, 4);
			g.drawRect(getCenter().getX()-2,getCenter().getY()+ innerRadius,4,4);
		}
	}

	//Vezba 7 interfejsi
	
	//Comparable 
	
	public int compareTo(Object o)
	{
		if(o instanceof Donut)
			return (int)(this.area()-((Donut)o).area());
		return 0;
		
					
	}
	
	
	
	
	

}
