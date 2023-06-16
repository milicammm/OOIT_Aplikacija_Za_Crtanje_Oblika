package geometry;

import java.awt.Graphics;
import java.awt.Color;

public class Point extends Shape{
	
	private int x;
	private int y;
	private Color color;
    // ovo smo brisali kod svih private boolean selected;
	
	//konstruktori
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point(int x,int y, boolean selected) //nasledjivanje prethodnog konstruktora 
	{
		this(x,y);
		this.selected=selected;

	}
	public Point(int x, int y,boolean selected,Color color)
	{
		this(x,y,selected);
		this.color=color;
	}
	
	public double distance(int x2, int y2) {
		int dx = x2-x;
		int dy =y2-y;
		double d =Math.sqrt(dx*dx+dy*dy);
		return d;
		
	}

	
	//Redefinisanje toString u metodu koja se nasledjuje iz klase object
		
	public String toString() {
		return "(" +x + ","+y+")"; //(x,y)
	}
	
	//Override-Redefisanje metode equals
	
	public boolean equals (Object obj) {
		
		if(obj instanceof Point) 
		{
			Point pomocna= (Point) obj;
			if(this.x==pomocna.x && this.y==pomocna.y)
				return true;
			else
				return false;	
		}
		else 
			return false;
	}
	
	//Metoda contains za selektovanje da li  sadrzi ili ne
	
	 public boolean contains(int x, int y)
	 {
		 return this.distance(x, y)<=2; //udaljenost centra od nase tacke, klika maksimalno 2
	 }
		
	
	//METODE PRISTUPA GET I SET 
	
	public int getX() {
		return x;
	}
	
   public void setX(int newX)
   {
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
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
  
	 /* OVO SMO BRISALI KOD SVIH 
	  * public boolean isSelected()
	{
		return selected;
	}
	public void setSelected(boolean newSelected)
	{
		selected=newSelected;
	}*/ 
     
	//Tacka se crta kao horizontalna i vertikalna linija onako ukrstene +
	@Override  //idem na onu sijalicu i kliknem ono dodaj neimplementirane metode
	public void draw(Graphics g) {
		
		
		g.setColor(color);
		g.drawLine(x-2, y, x+2, y); //horizontalna linija
		g.drawLine(x,y-2,x,y+2); // vertikalna linija 	
		
		if(selected)
		{
			g.setColor(Color.blue);
			g.drawRect(x-2, y-2, 4, 4); 
		}
	}

	//Vezbe 7 interfejsi
	
	//Moveable
	public void moveTo(int x, int y) {
		this.x=x;
		this.y=y;
		
	}
	
	public void moveBy(int byX, int byY) {
		this.x+=byX;
		this.y+=byY;
		
	}
	
	//Comparable 
	public int compareTo(Object o) 
	{
		if(o instanceof Point)
			return (int)(this.distance(0,0)-((Point)o).distance(0,0));
		return 0;
	}

}