
package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
		//p1.draw(g);
		
		Line l1=new Line(p1, new Point(70,80));
		//l1.draw(g);
		
		// M slovo, sama vezbala kuci 
		g.setColor(Color.blue);
		//l2.draw(g);
		
		Point p2=new Point(171,170);
		//p2.draw(g);
		
		Line l3=new Line(p1,p2);
		//l3.draw(g);
		
		Point p3=new Point(190,150);
		//p3.draw(g);
		
		Line l4=new Line(p2, p3);
		//l4.draw(g);
		
		Line l5= new Line(p3,new Point(190,200));
		//l5.draw(g);
		
		g.setColor(Color.RED);
		Circle c1= new Circle(new Point(100,100),45);
		//c1.draw(g);
		
		
		g.setColor(Color.GREEN);
		Rectangle r1=new Rectangle (new Point(200,200),60,60);
		//r1.draw(g);
		
		Donut d1=new Donut(new Point(250,250),50,25);
		
		//Vezbe 8
		
		//Zadatak 1
		/*Kreirati u klasi Drawing objekat klase ArrayList i nazvati ga shapes
		◄ U njega dodati po jedan objekat svake od prethodno kreiranih klasa i to
		u sledećem redosledu: tačka, linija, krug, krug sa rupom, pravougaonik
		◄ Svaki od oblika dodatih u listu shapes pomeriti po x osi za 10 piksela*/
		ArrayList<Shape>shapes=new ArrayList<Shape>();
		shapes.add(p1);
		shapes.add(l1);
		shapes.add(c1);
		shapes.add(d1);
		shapes.add(r1);
		
		Iterator<Shape>it=shapes.iterator();
		while (it.hasNext()) {
			it.next().moveBy(10, 0);
		}
		
		//Zadatak2
		/*U okviru klase Drawing izvršiti sledeće funkcionalnosti:
			◄ iscrtati četvrti element iz liste shapes,
			◄ iscrtati poslednji element liste (podrazumeva se da se ne zna
			 koliko elemenata ima u listi)
			◄ izbaciti drugi element liste,
			◄ iscrtati drugi element liste,
			◄ iscrtati element sa indeksom tri i
			◄ dodati liniju u listu tako da ona bude četvrti element liste*/
		
	     g.setColor(Color.black);
	     shapes.get(3).draw(g); //indeks ide od 0 pa je zato 3
	     shapes.get(shapes.size()-1).draw(g);
	     shapes.remove(1); //izbacivanje 2 el
	     shapes.get(1).draw(g); //crtanje 2 el
	     shapes.get(3).draw(g); //crtanje el sa indeksom 3
	     shapes.add(3,l1);
	     
	     //Izuzeci
	    try
	    {
	    	shapes.get(55);
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Greska!");
	    }
	    finally
	    {
	    	System.out.println("Ja se uvek izvrsavam");
	    }
	    try
	    {
	    	c1.setRadius(-45);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    //Zadatak 4
	    /*U svim klasama modifikovati metodu draw tako da ona iscrtava
	    kvadratić 4x4 piksela veličine u plavoj boji ukoliko je objekat selektovan
	    (promenljiva selected postavljena na vrednost true) i to na sledeći način:
	    ◄ Point – oko tačke,
	    ◄ Line – oko početne i krajnje tačke,
	    ◄ Circle – oko centra kruga i tačkama gore, levo, desno i dole na kružnici,
	    ◄ Donut – oko centra kruga i tačkama gore, levo, desno i dole na kružnici
	    unutrašnjeg i spoljašnjeg kruga i
	    ◄ Rectangle – oko temena pravougaonika
	    ◄ Testirati iscrtavanje i selektovanje svih objekata iz liste shapes*/
	    
	    p1.setSelected(true);
	    l1.setSelected(true);
		c1.setSelected(true);
		d1.setSelected(true);
		r1.setSelected(true);
		
		it=shapes.iterator();
		while(it.hasNext())
		{
			it.next().draw(g);
		}
		
		//Zadatak 5
		/*U okviru klase Drawing kreirati Hash mapu hmShapes koja će kao ključ
		prihvatati nazive klasa, a kao vrednost objekat klase Shape
		◄ Napuniti je nekim objektima i zatim ispisi neke od elemenata*/
		
		
		HashMap<String, Shape>hmShapes=new HashMap<String,Shape>();
		hmShapes.put("point",p1);
		hmShapes.put("line",l1);
		hmShapes.put("circle",c1);
		hmShapes.put("donut",d1);
		hmShapes.put("rectangle", r1);
		
		System.out.println(hmShapes.get("point"));
		System.out.println(hmShapes.get("line"));
		
		
		
		
		
	}
}
