package drawing;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Line;
import geometry.Point;
import geometry.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDrawing extends JPanel {
    
    private FrameDrawing frame; 
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private Point startPoint;
    private Shape selectedShape; 

    /**
     * Create the panel.
     */
    
    //Konstruktori
    public PanelDrawing() {

    }
    
    public PanelDrawing (FrameDrawing frame) {
        this.frame = frame;     
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                thisMouseClicked(me);       
            }
        });
        
    }
    
    protected void thisMouseClicked(MouseEvent me) {
        Shape newShape = null;
        Point click = new Point(me.getX(), me.getY());

        if (frame.getTglbtnSelect().isSelected()) {
            selectedShape = null;
            Iterator<Shape> iterator = shapes.iterator();

            while (iterator.hasNext()) {
                Shape shape = iterator.next();
                shape.setSelected(false);
                if (shape.contains(click.getX(), click.getY()))
                    selectedShape = shape;

            }

            if (selectedShape != null)
                selectedShape.setSelected(true);

        } else if (frame.getTglbtnPoint().isSelected()) {

            newShape = new Point(click.getX(), click.getY(), false);

        } else if (frame.getTglbtnLine().isSelected()) {

            if (startPoint == null)
                startPoint = click;
            else {
                newShape = new Line(startPoint, new Point(me.getX(), me.getY(), false));
                startPoint = null;
            }
            
        } else if (frame.getTglbtnCircle().isSelected()) {
            
            DialogCircle dialogCircle = new DialogCircle();

            dialogCircle.getTxtX().setText("" + Integer.toString(click.getX()));
            dialogCircle.getTxtX().setEditable(false);
            dialogCircle.getTxtY().setText("" + Integer.toString(click.getY()));
            dialogCircle.getTxtY().setEditable(false);
            dialogCircle.setVisible(true);
            
            if (dialogCircle.isConfirmed()) {
                newShape = dialogCircle.getCircle();
            }
            
        } else if (frame.getTglbtnDonut().isSelected()) {
            
            DialogDonut dialogDonut = new DialogDonut();
            dialogDonut.setModal(true);
            dialogDonut.getTxtX().setText("" + Integer.toString(click.getX()));
            dialogDonut.getTxtX().setEditable(false);
            dialogDonut.getTxtY().setText("" + Integer.toString(click.getY()));
            dialogDonut.getTxtY().setEditable(false);
            dialogDonut.setVisible(true);

            if (dialogDonut.isConfirmed()) {

                newShape = dialogDonut.getDonut();
            }
        } else if (frame.getTglbtnRectangle().isSelected()) {
    
            DialogRectangle dialogRect = new DialogRectangle();
            dialogRect.setModal(true);
            dialogRect.getTxtX().setText("" + Integer.toString(me.getX()));
            dialogRect.getTxtX().setEditable(false);
            dialogRect.getTxtY().setText("" + Integer.toString(me.getY()));
            dialogRect.getTxtY().setEditable(false);
            dialogRect.setVisible(true);

            if (!dialogRect.isConfirmed())
                return;

            try {
                newShape = dialogRect.getRect();
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(frame, "Wrong data type", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (newShape != null)
            shapes.add(newShape);

        repaint();

    }
    //Nasledjena metoda paint 
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    //Get i set metode
    public final Point getStartPoint() {
        return startPoint;
    }

    public  void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public   Shape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }
    
}