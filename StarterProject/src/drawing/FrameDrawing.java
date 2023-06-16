package drawing;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.JToggleButton;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class  FrameDrawing extends JFrame {

    private JPanel contentPane;
    private PanelDrawing panelDrawing = new PanelDrawing(this); 
    private JToggleButton tglbtnPoint = new JToggleButton("Point"); 
    private JToggleButton tglbtnLine = new JToggleButton("Line");
    private JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
    private JToggleButton tglbtnCircle = new JToggleButton("Circle");
    private JToggleButton tglbtnDonut = new JToggleButton("Donut");
    private JButton btnModify = new JButton("Modify");
    private JButton btnDelete = new JButton("Delete");
    private JToggleButton tglbtnSelect = new JToggleButton("Select");
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	// () -> lambda izraz
        EventQueue.invokeLater(() -> {      
            try {
                FrameDrawing frame = new FrameDrawing();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    

    /**
     * Create the frame.
     */
    public FrameDrawing() {
        setTitle("Milica Misan IT8/2022");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 614, 425);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(231, 241, 254));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        panelDrawing.setBorder(new LineBorder(new Color(0, 0, 128), 3));
        
        panelDrawing.setBackground(Color.WHITE);
        GroupLayout gl_pnlDrawing = new GroupLayout(panelDrawing);
        gl_pnlDrawing.setHorizontalGroup(
        	gl_pnlDrawing.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 380, Short.MAX_VALUE)
        );
        gl_pnlDrawing.setVerticalGroup(
        	gl_pnlDrawing.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 344, Short.MAX_VALUE)
        );
        panelDrawing.setLayout(gl_pnlDrawing);
       
        //Modify  button 
        btnModify.setForeground(new Color(0, 0, 128));
        btnModify.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        btnModify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if (panelDrawing.getSelectedShape() != null) {
                    modify();
                    panelDrawing.getSelectedShape().setSelected(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Please, select what you want to modify!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    tglbtnSelect.setSelected(true);
                }
                panelDrawing.setSelectedShape(null);
                tglbtnSelect.setSelected(false);
                
            }
        });
           
         //Delete button 
         btnDelete.setForeground(new Color(0, 0, 128));
         btnDelete.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
         btnDelete.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 delete();
                 tglbtnSelect.setSelected(false);
             }
         });
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panelDrawing, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnDelete, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        				.addComponent(tglbtnRectangle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        				.addComponent(tglbtnCircle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        				.addComponent(btnModify, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        				.addComponent(tglbtnSelect, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        				.addComponent(tglbtnDonut, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        				.addComponent(tglbtnPoint, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        				.addComponent(tglbtnLine, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
        			.addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addComponent(panelDrawing, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(tglbtnPoint)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(tglbtnLine)
        					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
        					.addComponent(tglbtnRectangle)
        					.addGap(18)
        					.addComponent(tglbtnCircle)
        					.addGap(18)
        					.addComponent(tglbtnDonut)
        					.addGap(20)
        					.addComponent(btnModify)
        					.addGap(18)
        					.addComponent(tglbtnSelect)
        					.addGap(18)
        					.addComponent(btnDelete)))
        			.addGap(18))
        );
        
        //Toggle button Point
        tglbtnPoint.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if(tglbtnPoint.isSelected())
        		{
        			tglbtnLine.setSelected(false);
        			tglbtnCircle.setSelected(false);
        			tglbtnDonut.setSelected(false);
        			tglbtnRectangle.setSelected(false);
        			tglbtnSelect.setSelected(false);
        		}
        	}
        });
        
        //Toggle button Line
        tglbtnLine.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if(tglbtnLine.isSelected())
        		{
        			tglbtnPoint.setSelected(false);
        			tglbtnCircle.setSelected(false);
        			tglbtnDonut.setSelected(false);
        			tglbtnRectangle.setSelected(false);
        			tglbtnSelect.setSelected(false);	
        		}
        	}
        });
        
        //Toggle button Rectangle 
        tglbtnRectangle.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if(tglbtnRectangle.isSelected())
        		{
        			tglbtnLine.setSelected(false);
        			tglbtnCircle.setSelected(false);
        			tglbtnDonut.setSelected(false);
        			tglbtnPoint.setSelected(false);
        			tglbtnSelect.setSelected(false);
        		}
        	}
        });
        
        //Toggle button Circle
        tglbtnCircle.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if(tglbtnCircle.isSelected())
        		{
        			tglbtnLine.setSelected(false);
        			tglbtnPoint.setSelected(false);
        			tglbtnDonut.setSelected(false);
        			tglbtnRectangle.setSelected(false);
        			tglbtnSelect.setSelected(false);
        		}
        	}
        });
        
        //Toggle button Donut
        tglbtnDonut.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if(tglbtnDonut.isSelected())
        		{
        			tglbtnLine.setSelected(false);
        			tglbtnCircle.setSelected(false);
        			tglbtnPoint.setSelected(false);
        			tglbtnRectangle.setSelected(false);
        			tglbtnSelect.setSelected(false);
        		}
        	}
        });
        
        //Toggle button Select
        tglbtnSelect.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if(tglbtnSelect.isSelected())
        		{
        			tglbtnLine.setSelected(false);
        			tglbtnCircle.setSelected(false);
        			tglbtnPoint.setSelected(false);
        			tglbtnRectangle.setSelected(false);
        			tglbtnDonut.setSelected(false);
        		}
        	}
        });
        
        //Boje i fontovi toggle buttona
        tglbtnSelect.setForeground(new Color(0, 0, 128));
        tglbtnSelect.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        tglbtnPoint.setForeground(new Color(0, 0, 128));
        tglbtnPoint.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        tglbtnLine.setForeground(new Color(0, 0, 128));
        tglbtnLine.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        tglbtnRectangle.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        tglbtnRectangle.setForeground(new Color(0, 0, 128));
        tglbtnCircle.setForeground(new Color(0, 0, 128));
        tglbtnCircle.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        tglbtnDonut.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        tglbtnDonut.setForeground(new Color(0, 0, 128));
        contentPane.setLayout(gl_contentPane);
        panelDrawing.repaint();
    }
    
    protected void delete() {

        Shape selectedShape = panelDrawing.getSelectedShape();

        if (selectedShape != null) {
            int selectedOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this shape?", "Warning message",
                    JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_OPTION) {
                panelDrawing.getShapes().remove(selectedShape);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You haven't selected any shape, please select it!", "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
        panelDrawing.setSelectedShape(null);
        panelDrawing.repaint(); 
    }

    protected void modify() {

        Shape selectedShape = panelDrawing.getSelectedShape();

        if (selectedShape != null) {

            if (selectedShape instanceof Point) {

                Point point = (Point) selectedShape;
                DialogPoint dialogPoint = new DialogPoint();

                dialogPoint.getTxtX().setText("" + Integer.toString(point.getX()));
                dialogPoint.getTxtY().setText("" + Integer.toString(point.getY()));
                dialogPoint.getTxtColor().setBackground(point.getColor());
                dialogPoint.setVisible(true);

                if (dialogPoint.isConfirmed()) {
                	
                	point.setColor(dialogPoint.getTxtColor().getBackground());
                    panelDrawing.getShapes().remove(selectedShape);
                    panelDrawing.getShapes().add(dialogPoint.getPoint());
                    repaint();
                }

            } else if (selectedShape instanceof Donut) {

                Donut donut = (Donut) selectedShape;
                DialogDonut dialogDonut = new DialogDonut();

                dialogDonut.getTxtX().setText("" + Integer.toString(donut.getCenter().getX()));
                dialogDonut.getTxtY().setText("" + Integer.toString(donut.getCenter().getY()));
                dialogDonut.getTxtR().setText("" + Integer.toString(donut.getRadius()));
                dialogDonut.getTxtInnerR().setText("" + Integer.toString(donut.getInnerRadius()));
                dialogDonut.getTxtInnerColor().setBackground(donut.getInnerColor());
                dialogDonut.getTxtColor().setBackground(donut.getColor()); 
                dialogDonut.setModal(true);
                dialogDonut.setVisible(true);

                if (dialogDonut.isConfirmed()) {
                	
                	donut.setColor(dialogDonut.getTxtColor().getBackground());
                	donut.setInnerColor(dialogDonut.getTxtInnerColor().getBackground());
                    panelDrawing.getShapes().remove(selectedShape); 
                    panelDrawing.getShapes().add(dialogDonut.getDonut()); 
                    repaint();
                }
            } else if (selectedShape instanceof Circle && (selectedShape instanceof Donut) == false) {

                Circle circle = (Circle) selectedShape;
                DialogCircle dialogCircle = new DialogCircle();

                dialogCircle.getTxtX().setText("" + Integer.toString(circle.getCenter().getX()));
                dialogCircle.getTxtY().setText("" + Integer.toString(circle.getCenter().getY()));
                dialogCircle.getTxtR().setText("" + Integer.toString(circle.getRadius()));
                dialogCircle.getTxtInnerColor().setBackground(circle.getInnerColor());
                dialogCircle.getTxtColor().setBackground(circle.getColor());

                dialogCircle.setVisible(true);
                dialogCircle.setModal(true);

                if (dialogCircle.isConfirmed()) {
                	circle.setColor(dialogCircle.getTxtColor().getBackground());
                	circle.setInnerColor(dialogCircle.getTxtInnerColor().getBackground());
                    panelDrawing.getShapes().remove(selectedShape);
                    panelDrawing.getShapes().add(dialogCircle.getCircle());
                    repaint();
                }

            } else if (selectedShape instanceof Line) {

                Line line = (Line) selectedShape;
                DialogLine dialogLine = new DialogLine();

                dialogLine.getTxtX1().setText("" + Integer.toString(line.getStartPoint().getX()));
                dialogLine.getTxtY1().setText("" + Integer.toString(line.getStartPoint().getY()));
                dialogLine.getTxtX2().setText("" + Integer.toString(line.getEndPoint().getX()));
                dialogLine.getTxtY2().setText("" + Integer.toString(line.getEndPoint().getY()));
                dialogLine.getTxtColor().setBackground(line.getColor());

                dialogLine.setVisible(true);

                if (dialogLine.isConfirmed()) {
                	
                	line.setColor(dialogLine.getTxtColor().getBackground());
                    panelDrawing.getShapes().remove(selectedShape);
                    panelDrawing.getShapes().add(dialogLine.getLine());
                    repaint();
                }

            } else if (selectedShape instanceof Rectangle) {

                Rectangle rectangle = (Rectangle) selectedShape;
                DialogRectangle dialogRect = new DialogRectangle();

                dialogRect.getTxtX().setText("" + Integer.toString(rectangle.getUpperLeftPoint().getX()));
                dialogRect.getTxtY().setText("" + Integer.toString(rectangle.getUpperLeftPoint().getY()));
                dialogRect.getTxtHeight().setText("" + Integer.toString(rectangle.getHeight()));
                dialogRect.getTxtWidth().setText("" + Integer.toString(rectangle.getWidth()));
                dialogRect.getTxtInnerColor().setBackground(rectangle.getInnerColor());
                dialogRect.getTxtColor().setBackground(rectangle.getColor());
                dialogRect.setModal(true);
                dialogRect.setVisible(true);

                if (dialogRect.isConfirmed()) {
                	rectangle.setInnerColor(dialogRect.getTxtInnerColor().getBackground());
                	rectangle.setColor(dialogRect.getTxtColor().getBackground());
                    panelDrawing.getShapes().remove(selectedShape);
                    panelDrawing.getShapes().add(dialogRect.getRect());
                    repaint();
                }
            }

        }
    }
    
    
    public PanelDrawing getPnlDrawing() {
        return panelDrawing;
    }

    public void setPnlDrawing(PanelDrawing panelDrawing) {
        this.panelDrawing = panelDrawing;
    }

    public JToggleButton getTglbtnPoint() {
        return tglbtnPoint;
    }

    public void setTglbtnPoint(JToggleButton tglbtnPoint) {
        this.tglbtnPoint = tglbtnPoint;
    }

    public JToggleButton getTglbtnLine() {
        return tglbtnLine;
    }

    public void setTglbtnLine(JToggleButton tglbtnLine) {
        this.tglbtnLine = tglbtnLine;
    }

    public JToggleButton getTglbtnRectangle() {
        return tglbtnRectangle;
    }

    public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
        this.tglbtnRectangle = tglbtnRectangle;
    }

    public JToggleButton getTglbtnCircle() {
        return tglbtnCircle;
    }

    public void setTglbtnCircle(JToggleButton tglbtnCircle) {
        this.tglbtnCircle = tglbtnCircle;
    }

    public JToggleButton getTglbtnDonut() {
        return tglbtnDonut;
    }

    public void setTglbtnDonut(JToggleButton tglbtnDonut) {
        this.tglbtnDonut = tglbtnDonut;
    }

    public JToggleButton getTglbtnSelect() {
        return tglbtnSelect;
    }

    public void setTglbtnSelect(JToggleButton tglbtnSelect) {
        this.tglbtnSelect = tglbtnSelect;
    }

}