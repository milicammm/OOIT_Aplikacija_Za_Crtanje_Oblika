package stack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import geometry.Circle;
import geometry.Point;
import java.util.Stack;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class StackFrame extends JFrame {

	private JPanel contentPane;
	DefaultListModel <Circle> dlm = new DefaultListModel<Circle>();
	private JToggleButton tglbtnPull = new JToggleButton("Pull element");
	private JToggleButton tglbtnPush = new JToggleButton("Push element"); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StackFrame() {
		setTitle("Milica Misan IT8/2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("STACK FOR CIRCLE ");
		lblTitle.setForeground(new Color(219, 112, 147));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		
		JScrollPane scrlPane = new JScrollPane();
		
		JList lstStack = new JList();
		scrlPane.setViewportView(lstStack);
		lstStack.setModel(dlm);
		
		

		tglbtnPush.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tglbtnPush.isSelected())
				{
					tglbtnPull.setSelected(false);
				}
			}
		});
		tglbtnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackDialog stackDialog= new StackDialog();
				stackDialog.setVisible(true);
	
				  if(stackDialog.isConfirmed==true)
					  
	                {
	                    try {
	                        int x = Integer.parseInt(stackDialog.getTxtXCoordinate().getText()); 
	                        int y = Integer.parseInt(stackDialog.getTxtYCoordinate().getText());
	                        int radius = Integer.parseInt(stackDialog.getTxtRadius().getText());
	                        Circle circle = new Circle(new Point(x,y), radius); 
	                        dlm.add(0,circle);  
	                        
	                    }
	                     catch(Exception NumberFormatException) {
	                         
	                         JOptionPane.showMessageDialog(null,"Please, insert values!");
	                         
	                     }
	                    
	                }
			}
		});
		tglbtnPush.setForeground(new Color(219, 112, 147));
		tglbtnPush.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		
		//Toggle button pull
		tglbtnPull.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tglbtnPull.isSelected())
				{
					tglbtnPush.setSelected(false);
				}
				
			}
		});
		

		tglbtnPull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(dlm.isEmpty() == false)
				 {
	                    dlm.removeElementAt(0);
	                }
	                else {
	                    JOptionPane.showMessageDialog(null,"Stack is empty, please enter a value!","ERROR", JOptionPane.ERROR_MESSAGE);
	                return;
	                }   
			}
		});
		tglbtnPull.setForeground(new Color(219, 112, 147));
		tglbtnPull.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(scrlPane, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(149)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tglbtnPull, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tglbtnPush, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrlPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tglbtnPush)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnPull)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane); 
			
		
	}


}
