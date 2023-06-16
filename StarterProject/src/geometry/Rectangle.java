package geometry;

import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int width;
	private int height;
	private Color innerColor;
	private Color color;
 
	//KONSTRUKTORI 
	
	public Rectangle()
	{
		 
	}
    public Rectangle(Point upperLeftPoint, int width, int height) 
    {
    	this.upperLeftPoint=upperLeftPoint;
    	this.width=width;
    	this.height=height; 
  
    }
    
    public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
    	this.upperLeftPoint=upperLeftPoint;
    	this.height =height;
    	this.width=width;
    	this.selected=selected; 
    	
    }
    public Rectangle(Point upperLeftPoint, int width, int height,boolean selected, Color color,Color innerColor)
    {
    	this(upperLeftPoint, width, height,selected);
    	this.color=color;
    	this.innerColor=innerColor;
    	
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
	
   //REDEFINISANJE toString
	
	public String toString() {
		return "Upper left point: " + upperLeftPoint + ", widht= "+
									width + ",height= "+ height; 
		//Upper left point :(x,y), width = ,height=
	}
	
	// Override - Redefinisanje metode equals
	
	public boolean equals(Object obj){
		if(obj instanceof Rectangle)
		{
			Rectangle pomocna= (Rectangle) obj;

			if(this.upperLeftPoint.equals(pomocna.upperLeftPoint)&& height==pomocna.height 
					&& width==pomocna.width) // ovo je kao .equals jer nije u ovoj klasi nego nasledjuje iz
				                              //point to sam sama skontala moram proveriti jel tako dobro je
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	//Metoda contains za selektovanje da li  sadrzi ili ne
	
		public boolean contains(int x, int y) {
			
			return(x >= upperLeftPoint.getX() && x <= upperLeftPoint.getX() + width && y >=upperLeftPoint.getY()
					&& y<= upperLeftPoint.getY() + height);
		}
	//METODE PRISTUPA GET I SET
		
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
	public Color getInnerColor() {
		return innerColor;
	}
	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
	
	//Crtanje pravougaonika
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
        g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
        g.setColor(innerColor);
        g.fillRect(upperLeftPoint.getX()+1, upperLeftPoint.getY()+1, width-1, height-1);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeftPoint.getX()-2, upperLeftPoint.getY()-2, 4,4); //gore levo
			g.drawRect(upperLeftPoint.getX()+ width -2, upperLeftPoint.getY()-2, 4,4); //gore desno
			g.drawRect(upperLeftPoint.getX()-2, upperLeftPoint.getY() + height -2, 4,4); //dole levo
			g.drawRect(upperLeftPoint.getX() + width -2, upperLeftPoint.getY() + height -2, 4,4); //dole desno
		}

	}

	//Vezbe 7 interfejsi
	
	//Moveable
	
	public void moveTo(int x, int y) {
		this.upperLeftPoint.moveTo(x,y);
		
	}
	
	public void moveBy(int byX, int byY) {
		this.upperLeftPoint.moveBy(byX, byY);
		
	}
	
	//Comparable
	//mora da vraca neku int vrednost 
	public int compareTo(Object o) {
		if(o instanceof Rectangle)
			return (int)(this.area()-((Rectangle)o).area());
		return 0;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	
	
	
	
	
	
	
	
	
}

