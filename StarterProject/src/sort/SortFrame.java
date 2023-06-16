package sort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import geometry.Circle;
import geometry.Point;
import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SortFrame extends JFrame {

	private JPanel contentPane;
     DefaultListModel<Circle>dlm=new DefaultListModel<Circle>();
	ArrayList <Circle> listSort = new ArrayList<Circle>();
	private JToggleButton tglBtnAdd = new JToggleButton("Add circle");
	private JToggleButton tglBtnSort = new JToggleButton("Sort");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrame frame = new SortFrame();
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
	public SortFrame() {
		setTitle("Milica Misan IT8/2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 231, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("SORT CIRCLE");
		lblTitle.setForeground(new Color(153, 102, 255));
		lblTitle.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		
		JScrollPane scrlPnlSort = new JScrollPane();
		scrlPnlSort.setBorder(new LineBorder(new Color(153, 102, 255), 5));
		
		JList lstSort = new JList();
		lstSort.setBackground(new Color(255, 255, 255));
		scrlPnlSort.setViewportView(lstSort);
		lstSort.setModel(dlm);
		
		//Toggle button add
		
		tglBtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortDialog sortDialog=new SortDialog();
				sortDialog.setVisible(true);
				if(sortDialog.isConfirmed==true)
					  
                {
                    try {
                        int x = Integer.parseInt(sortDialog.getTxtXCoordinate().getText()); 
                        int y = Integer.parseInt(sortDialog.getTxtYCoordinate().getText());
                        int radius = Integer.parseInt(sortDialog.getTxtRadius().getText());
                        Circle circle = new Circle(new Point(x,y), radius); 
                        dlm.addElement(circle); 
                        listSort.add(circle);
                    }
                     catch(Exception NumberFormatException) {
                         
                         JOptionPane.showMessageDialog(null,"Please, insert values!");
                         
                     }
                    
                }
			}
		});
		
				tglBtnAdd.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						if(tglBtnAdd.isSelected())
						{
							tglBtnSort.setSelected(false);
						}
					}
				});
				
		tglBtnAdd.setForeground(new Color(153, 102, 255));
		tglBtnAdd.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		
		//Toggle button sort
		
		tglBtnSort.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tglBtnSort.isSelected())
				{
					tglBtnAdd.setSelected(false);
				}
			}
		});
		
		tglBtnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "List is empty, please enter values! ", "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    
                	listSort.sort((o1, o2) -> o1.area().compareTo(((o2.area()))));
                    dlm.clear();
                    for(int i=0; i<listSort.size();i++) { //prolazi kroz petlju i sortira to od najmanjeg do najveceg
                    	
                        dlm.addElement(listSort.get(i));
        
                    }
			}
			}
		});
		tglBtnSort.setForeground(new Color(153, 102, 255));
		tglBtnSort.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(scrlPnlSort, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(tglBtnAdd, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(207, Short.MAX_VALUE)
					.addComponent(tglBtnSort, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(104))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTitle)
							.addGap(18)
							.addComponent(scrlPnlSort, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addComponent(tglBtnAdd))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(tglBtnSort)
					.addGap(5))
		);
		
		
		contentPane.setLayout(gl_contentPane);
	}

}
