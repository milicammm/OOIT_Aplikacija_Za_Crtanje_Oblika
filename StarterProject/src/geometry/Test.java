package geometry;

public class Test {

	public static void main(String[] args) {
		
	   Point point1=new Point();
		
	   /*point1.x=2; Ne moze ovako zbog specifikatora pristupa private kog je y.
	    point1.y=3;  */
	   point1.setX(10);
	   point1.setY(5);
	   
	   System.out.println("X koordinata tacke je : "+ point1.getX());
	   System.out.println("Y koordinata tacke je : " + point1.getY());
	   System.out.println("Da li je tacka selektovana " + point1.isSelected());
	   
	   double distanceResult=point1.distance(15,7);
	   System.out.println(distanceResult);
	   
	   System.out.println(point1);

	 //Vezbe 3 (13.3.2023.)

	    System.out.println("Vezbe 3");
	    
	    Line l1= new Line();
	    Rectangle r1= new Rectangle();
	    Circle c1=new Circle();
	    Point p2=new Point();
	    
	    p2.setX(15);
	    p2.setY(27);
		
	//1. Inicijalizovati x koordinatu tacke point1 na vrednost y koordinate tacke p2
	      
	    point1.setX(p2.getY());
	    System.out.println("X koordinata tacke y je: "+ point1.getX());
	
	
	//2. Postaviti za pocetni tacku linije l1 tacku point1, a za krajnju tacku linije l1 tacku p2
	    
	    l1.setStartPoint(point1);
	    l1.setEndPoint(p2);
	    System.out.println("X koordinata pocetne tacke linije l1: "+ l1.getStartPoint().getX());
	    System.out.println("Y koordinata pocetne tacke linije l1: "+ l1.getStartPoint().getY());
	    System.out.println("X koordinata krajnje tacke linije l1: "+ l1.getEndPoint().getX());
	    System.out.println("Y koordinata krajnje tacke linije l1: "+ l1.getEndPoint().getY());
	
	
	//3. Postaviti y koordinatu kranje tacke linije l1 na 23
	    
	    l1.getEndPoint().setX(23);
	    System.out.println("Y koordinata krajnje tacke linije l1: "+ l1.getEndPoint().getY());
	    
	
	//4. Inizijalizovati x koordinatu pocetne tacke linije l1 na vrednost y koordinate kranje tacke linije l1
	
	    l1.getStartPoint().setX(l1.getEndPoint().getY());
	    System.out.println("X koordinata pocetne tacke linije l1: "+ l1.getStartPoint().getX());

	
	/*5. Postaviti x koordinatu kranje tacke linije l1 na vrednost duzine linje
          l1 umanjene za vrednost zbira x i y koordinate pocetne tacke l1 */
	    
	    l1.getEndPoint().setX((int )l1.length() -
	    		(l1.getStartPoint().getX()+l1.getStartPoint().getY()));
	    System.out.println("X koordinata krajnje tacke l1: "+ l1.getEndPoint().getX());
	    
	
	/*6. Postaviti x koordinatu tacke gore levo pravougaonika r1 na vrednost 10
	     i y koordinatu na vrednost 15*/ 
	 
	    r1.setUpperLeftPoint(new Point());
	    r1.getUpperLeftPoint().setX(10);
	    r1.getUpperLeftPoint().setY(15);
	    System.out.println("X koordinata gornje leve tacke pravougaonika r1: "+ 
	    r1.getUpperLeftPoint().getX());
	    System.out.println("Y koordinata gornje leve tacke pravougaonika r1: "+
	    r1.getUpperLeftPoint().getY());
	    
	    // 6.1 Povrsina i obim pravougaonika 
    
	    r1.setWidth(20);
	    r1.setHeight(10);
	    System.out.println("Povrsina r1 je "+ r1.area());
	    System.out.println("Obim r1 je "+ r1.circumference());
    
    //7. Postaviti centar kruga c1 na koordinate tacke gore levo pravougaonika r1
    
           c1.setCenter(r1.getUpperLeftPoint());
           System.out.println("X koordinata centra kruga r1: " + c1.getCenter().getX());
           System.out.println("Y koordinata centra kruga r1: "+ c1.getCenter().getY());
           
    /*8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
	    povrsine pravougaonika r1 i y koordinate pocetne tacke linje l1*/
    
           c1.getCenter().setX(r1.area()-l1.getStartPoint().getY());
           System.out.println("X koordinata centra kruga r1: "+ c1.getCenter().getX());
           System.out.println("Y koordinata centra kruga r1: "+ c1.getCenter().getY());
           
           
           
           
   } 
}
