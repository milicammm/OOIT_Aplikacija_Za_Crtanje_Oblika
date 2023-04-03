package geometry;

import java.awt.Graphics;

public abstract class Shape {
	
	protected boolean selected; //sve klase u geometry paketu vide ovo
	
	//Apstraktne metode 
	
	public abstract boolean contains(int x,int y); //nema {} jer je abstract
	
	public abstract void draw(Graphics g); //graphics kao math ona crta nase oblike 
	
	
	//konstruktori
	public Shape() {
		
	}

	public Shape(boolean selected) {
		this.selected=selected;
	}
	
	//get i set metode 
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean newSelected) 
	{
		selected=newSelected;
		
	}
	

}
