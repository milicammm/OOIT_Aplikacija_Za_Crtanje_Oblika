package geometry;

public class Circle {
	
	private Point center;
	private int radius;
	private boolean selected;
	
	public Circle() {
		
	}
	public Circle(Point center, int radius)
	{
		this.center=center;
		this.radius=radius;
	}
	public Circle(Point center, int radius, boolean selected)
	{
		this(center,radius);
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
	
	public String toString() {
		return "Center" + center+ ", radius ="+ radius; //Center: (x,y), radius= radius
	}
	
	// Override - Redefinisanje metode equals 
	 
	public boolean equals(Object obj)
	{
		if(obj instanceof Circle) {
			Circle pomocna= (Circle) obj;
			if(this.center.equals(pomocna.center)&& this.radius==pomocna.radius)// ovo je equals jer je tipa Point,a ovo je = jer je tipa int
				return true;
			else
				return false;
			
		}else
			return false;
	}
	
	//Metoda contains za selektovanje da li sadrzi ili ne
	
		public boolean contains(int x,int y) {
			return center.distance(x, y)<= radius; //udaljenost centra <= od poluprecnika
		}
		public boolean contains (Point p) {
			return center.distance(p.getX(),p.getY()) <= radius;
		}
		// mozemo da imamo 2 metode sa istim nazivom al se liste parametara moraju razlikovati -OVERLOADING
	
		
		
	//METODE PRISTUPA
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
	public void setRadius(int radius)
	{
		this.radius=radius;
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	public void setSelected(boolean selected)
	{
		this.selected=selected;
	}
	
}


