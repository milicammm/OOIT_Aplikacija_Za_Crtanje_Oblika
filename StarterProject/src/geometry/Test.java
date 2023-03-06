package geometry;

public class Test {

	public static void main(String[] args) {
		
		Point point1= new Point();
		
		/*point1.x=2; Ne moze ovako zbog specifikatora pristupa private kog je y.
	    point1.y=3;  */
		point1.setX(2);
		point1.setY(3);
		point1.setSelected(false);
		System.out.println("X koordinata " + point1.getX());
		System.out.println("Y koordinata " + point1.getY());
		System.out.println("Selektovana tacka " + point1.isSelected());
		System.out.println(point1);
	    double result =	point1.distance(6, 7);
		System.out.print(result);
	}

}
