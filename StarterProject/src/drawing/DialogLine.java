package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;


import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;

public class DialogLine extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtStartPtX;
    private JTextField txtStartPtY;
    private JTextField txtEndPtX;
    private JTextField txtEndPtY;
    private JButton btnColor;
    private JLabel lblStartPoint;
    private JLabel lblStartPtX;
    private JLabel lblStartPtY;
    private JLabel lblEndPoint;
    private JLabel lblEndPtX;
    private JLabel lblEndPtY;
    private JLabel lblTitle;
    private JTextField txtColor;
    public Line line;
    private boolean isConfirmed;
  

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DialogLine dialog = new DialogLine();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DialogLine() {
        setModal(true);
        setTitle("EDIT LINE");
        setResizable(false);
        setLocationRelativeTo(null);
        setBounds(100, 100, 318, 370);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(231, 241, 254));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        {
            lblStartPoint = new JLabel("START POINT");
            lblStartPoint.setForeground(new Color(0, 0, 128));
            lblStartPoint.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            lblStartPtX = new JLabel("X :");
            lblStartPtX.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtStartPtX = new JTextField();
            txtStartPtX.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtStartPtX.setColumns(10);
        }
        {
            lblStartPtY = new JLabel("Y :");
            lblStartPtY.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtStartPtY = new JTextField();
            txtStartPtY.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtStartPtY.setColumns(10);
        }
        {
            lblEndPoint = new JLabel("END POINT");
            lblEndPoint.setForeground(new Color(0, 0, 128));
            lblEndPoint.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            lblEndPtX = new JLabel("X : ");
            lblEndPtX.setForeground(new Color(0, 0, 128));
            lblEndPtX.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtEndPtX = new JTextField();
            txtEndPtX.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtEndPtX.setColumns(10);
        }
        {
            lblEndPtY = new JLabel("Y : ");
            lblEndPtY.setForeground(new Color(0, 0, 128));
            lblEndPtY.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtEndPtY = new JTextField();
            txtEndPtY.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtEndPtY.setColumns(10);
        }
        {
            btnColor = new JButton("Color");
            btnColor.setBackground(SystemColor.control);
            btnColor.setForeground(new Color(0, 0, 128));
            btnColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
            btnColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    Color color = JColorChooser.showDialog(null, "Choose outline color",Color.white);
                    if (color != null)
                    txtColor.setBackground(color);
                    txtColor.setEditable(false);

                }
            });
        }
        lblTitle = new JLabel("Enter :");
        lblTitle.setForeground(new Color(0, 0, 128));
        lblTitle.setFont(new Font("Segoe UI Black", Font.PLAIN, 22));
        txtColor = new JTextField();
        txtColor.setEditable(false);
        txtColor.setForeground(new Color(255, 255, 255));
        txtColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        txtColor.setColumns(10);
        txtColor.setBackground(Color.black);
        
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
        	gl_contentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblStartPoint)
        			.addContainerGap(132, Short.MAX_VALUE))
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap(72, Short.MAX_VALUE)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblStartPtX)
        				.addComponent(lblStartPtY)
        				.addComponent(lblEndPtX)
        				.addComponent(lblEndPtY))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(txtEndPtY, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
        				.addComponent(txtEndPtX, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
        				.addComponent(txtStartPtY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        				.addComponent(txtStartPtX, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
        			.addGap(37))
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btnColor)
        			.addGap(18)
        			.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(125, Short.MAX_VALUE))
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblEndPoint, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(137, Short.MAX_VALUE))
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addGap(102)
        			.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(114, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
        	gl_contentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblTitle)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblStartPoint)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblStartPtX)
        				.addComponent(txtStartPtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(4)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtStartPtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblStartPtY))
        			.addGap(11)
        			.addComponent(lblEndPoint)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtEndPtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblEndPtX))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtEndPtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblEndPtY))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnColor)
        				.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(20))
        );
        contentPanel.setLayout(gl_contentPanel);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(200, 222, 253));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
                okButton.setForeground(new Color(0, 0, 128));
                okButton.setBackground(SystemColor.control);
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                    	String startPointX = txtStartPtX.getText().trim(); 
                    	String startPointY = txtStartPtY.getText().trim();
                    	String endPointX = txtEndPtX.getText().trim();
                    	String endPointY = txtEndPtY.getText().trim();

                    	if (startPointX.isEmpty() || startPointY.isEmpty() || endPointX.isEmpty() || endPointY.isEmpty()) {
                    	    isConfirmed = false;
                    	    JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    	} else {
                    	    try {
                    	        int startX = Integer.parseInt(startPointX);
                    	        int startY = Integer.parseInt(startPointY);
                    	        int endX = Integer.parseInt(endPointX);
                    	        int endY = Integer.parseInt(endPointY);

                    	        if (startX < 0 || startY < 0 || endX < 0 || endY < 0) {
                    	            JOptionPane.showMessageDialog(null, "Insert values greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
                    	        } else {
                    	            Point startPoint = new Point(startX, startY);
                    	            Point endPoint = new Point(endX, endY);
                    	            line = new Line(startPoint, endPoint, false, txtColor.getBackground());

                    	            isConfirmed = true;
                    	            setVisible(false);
                    	        }
                    	    } catch (NumberFormatException e2) {
                    	        JOptionPane.showMessageDialog(null, "Enter numbers only!", "Error", JOptionPane.ERROR_MESSAGE);
                    	    }
                    	}
                    }
                });
                
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setForeground(new Color(0, 0, 128));
                cancelButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
                cancelButton.setBackground(SystemColor.control);
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
    
    //Get i set metode
    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public JTextField getTxtX1() {
        return txtStartPtX;
    }

    public void setTxtX1(JTextField txtX1) {
        this.txtStartPtX = txtX1;
    }

    public JTextField getTxtY1() {
        return txtStartPtY;
    }

    public void setTxtY1(JTextField txtY1) {
        this.txtStartPtY = txtY1;
    }

    public JTextField getTxtX2() {
        return txtEndPtX;
    }

    public void setTxtX2(JTextField txtX2) {
        this.txtEndPtX = txtX2;
    }

    public JTextField getTxtY2() {
        return txtEndPtY;
    }

    public void setTxtY2(JTextField txtY2) {
        this.txtEndPtY = txtY2;
    }


    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public JButton getBtnOutlineColor() {
        return btnColor;
    }

    public void setBtnOutlineColor(JButton btnOutlineColor) {
        this.btnColor = btnOutlineColor;
    }

	public JTextField getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextField txtColor) {
		this.txtColor = txtColor;
	}

}