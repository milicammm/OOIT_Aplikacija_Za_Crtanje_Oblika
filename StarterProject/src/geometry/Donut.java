package geometry;

//extends - nasledjivanje od nadredjene klase circle, posto se kao donut sastoji od tog kruga 
public class Donut extends Circle {
	
	private int innerRadius; //poluprecnik unutrasnjeg kruga
	
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
	
	
	//Metode get i set moze preko source da se kreira 
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	
	
	
	
	
	

}
