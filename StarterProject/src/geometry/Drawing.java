
package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public Drawing(){
		
	}
	public static void main(String[]args) {
		
		JFrame frame= new JFrame("Drawing");
		frame.setSize(800,600);
		Drawing drawing= new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}
	public void paint(Graphics g) {
		Point p1=new Point(150,150);
		p1.draw(g);
		
		/*Line l1=new Line(p1, new Point(70,80));
		l1.draw(g);*/
		
		// M slovo, sama vezbala kuci 
		g.setColor(Color.blue);
		Line l2=new Line(p1, new Point(150,200));
		l2.draw(g);
		
		Point p2=new Point(171,170);
		p2.draw(g);
		
		Line l3=new Line(p1,p2);
		l3.draw(g);
		
		Point p3=new Point(190,150);
		p3.draw(g);
		
		Line l4=new Line(p2, p3);
		l4.draw(g);
		
		Line l5= new Line(p3,new Point(190,200));
		l5.draw(g);
		
		g.setColor(Color.RED);
		Circle c1= new Circle(new Point(100,100),45);
		c1.draw(g);
		
		
		g.setColor(Color.GREEN);
		Rectangle r1=new Rectangle (new Point(200,200),60,60);
		r1.draw(g);
		
		
		
		
		
		
		
	}
}
