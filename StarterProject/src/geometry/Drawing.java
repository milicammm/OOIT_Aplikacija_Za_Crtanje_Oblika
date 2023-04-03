
package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	/**
	 * Create the panel.
	 */
	public Drawing() {

	}

	public static void main(String []args) {
		JFrame frame=new JFrame("Drawing");
		frame.setSize(800,600); //velicina
		Drawing drawing=new Drawing(); //panel
	    frame.getContentPane().add(drawing); //ubacujemo panel  u okvir
	    frame.setVisible(true); //moguca vidljivost korisniku
		
	}
	
	//Crtanje po panelu
	public void paint(Graphics g) {
		Point p1=new Point(40,50); //pravimo tacku
		p1.draw(g); //crtanje
		
		Line l1=new Line(p1,new Point(70,80)); //prosledimo p1 i novu tacku sa koordinatama 70 i 80
		l1.draw(g);
		
		g.setColor(Color.RED); // da crtamo u boji, sve se crta u toj boji dok ne promenim u drugu 
		
		Circle c1=new Circle(new Point(100,100),45);
		c1.draw(g);
		
		g.setColor(Color.GREEN); // sad ce crtati kvadrat zeleno 
		
		Rectangle r1=new Rectangle(new Point(200,200),60,60);
		r1.draw(g);
		
		
	}
	
}
