package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogDonut extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCenterX;
    private JTextField txtCenterY;
    private JTextField txtRadius;
    private JTextField txtInnerRadius;
    public JButton btnOutlineColor;
    public JButton btnInnerColor;
    private JLabel lblCenter;
    private JLabel lblCenterX;
    private JLabel lblCenterY;
    private JLabel lblRadius;
    private JLabel lblInnerRadius;
    private JTextField txtColor;
    private JTextField txtInnerColor;
    public boolean isConfirmed;
    public Donut donut;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DialogDonut dialog = new DialogDonut();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DialogDonut() {
      
        setModal(true);
        setTitle("EDIT DONUT");
        setResizable(false);
        setLocationRelativeTo(null);
        setBounds(100, 100, 339, 435);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(231, 241, 254));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        {
            lblCenter = new JLabel("Center :");
            lblCenter.setForeground(new Color(0, 0, 128));
            lblCenter.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            lblCenterX = new JLabel("X :");
            lblCenterX.setForeground(new Color(0, 0, 128));
            lblCenterX.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtCenterX = new JTextField();
            txtCenterX.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtCenterX.setColumns(10);
        }
        {
            lblCenterY = new JLabel("Y :");
            lblCenterY.setForeground(new Color(0, 0, 128));
            lblCenterY.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtCenterY = new JTextField();
            txtCenterY.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtCenterY.setColumns(10);
        }
        {
            lblRadius = new JLabel("Radius :");
            lblRadius.setForeground(new Color(0, 0, 128));
            lblRadius.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtRadius = new JTextField();
            txtRadius.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtRadius.setColumns(10);
        }
        {
            lblInnerRadius = new JLabel("Inner radius :");
            lblInnerRadius.setForeground(new Color(0, 0, 128));
            lblInnerRadius.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtInnerRadius = new JTextField();
            txtInnerRadius.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtInnerRadius.setColumns(10);
        }
        {
            btnOutlineColor = new JButton("Outline color");
            btnOutlineColor.setBackground(SystemColor.control);
            btnOutlineColor.setForeground(new Color(0, 0, 128));
            btnOutlineColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
            btnOutlineColor.addActionListener(new ActionListener() {
              
            	public void actionPerformed(ActionEvent e) {
                    Color innerClr = JColorChooser.showDialog(null, "Choose inner color", btnOutlineColor.getBackground());
                    if (innerClr != null)
                    txtColor.setBackground(innerClr);
                    txtColor.setEditable(false);
                }
            });
        }
        {
            btnInnerColor = new JButton("InnerColor");
            btnInnerColor.setBackground(SystemColor.control);
            btnInnerColor.setForeground(new Color(0, 0, 128));
            btnInnerColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
           
            btnInnerColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Color outlineClr = JColorChooser.showDialog(null, "Choose outline color",Color.white);
                            
                    if (outlineClr != null)
                    txtInnerColor.setBackground(outlineClr);
                    txtInnerColor.setEditable(false);
                        
                }
            });
        }
        JLabel lblTitle = new JLabel("Enter :");
        lblTitle.setForeground(new Color(0, 0, 128));
        lblTitle.setFont(new Font("Segoe UI Black", Font.PLAIN, 22));
       
        txtColor = new JTextField();
        txtColor.setEditable(false);
        txtColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        txtColor.setColumns(10);
        txtColor.setBackground(Color.black);
        txtInnerColor = new JTextField();
        txtInnerColor.setEditable(false);
        txtInnerColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        txtInnerColor.setColumns(10);
       
        
        
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
        	gl_contentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblCenter)
        			.addContainerGap(367, Short.MAX_VALUE))
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addComponent(lblInnerRadius)
        					.addGap(18)
        					.addComponent(txtInnerRadius, 105, 105, 105))
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(btnOutlineColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(txtColor, 0, 0, Short.MAX_VALUE))
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(gl_contentPanel.createSequentialGroup()
        							.addGap(18)
        							.addComponent(txtInnerColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_contentPanel.createSequentialGroup()
        							.addGap(21)
        							.addComponent(btnInnerColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addComponent(lblRadius)
        					.addGap(18)
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))))
        			.addGap(35))
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addGap(65)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblCenterX)
        				.addComponent(lblCenterY))
        			.addGap(18)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(txtCenterY, 0, 0, Short.MAX_VALUE)
        				.addComponent(txtCenterX, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
        			.addGap(97))
        );
        gl_contentPanel.setVerticalGroup(
        	gl_contentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblTitle)
        			.addGap(17)
        			.addComponent(lblCenter)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblCenterX))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCenterY)
        				.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(26)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblRadius)
        				.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblInnerRadius))
        			.addGap(29)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnOutlineColor)
        				.addComponent(btnInnerColor))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtInnerColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                okButton.setForeground(new Color(0, 0, 128));
                okButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
                okButton.setBackground(SystemColor.control);
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                    	String centerXCord = txtCenterX.getText().trim(); 
                    	String centerYCord = txtCenterY.getText().trim();
                    	String radius = txtRadius.getText().trim();
                    	String innerRadius = txtInnerRadius.getText().trim();

                    	if (centerXCord.isEmpty() || centerYCord.isEmpty() || radius.isEmpty() || innerRadius.isEmpty()) {
                    	    setConfirmed(false);
                    	    JOptionPane.showMessageDialog(null, "All values are required, please enter them!", "Error", JOptionPane.ERROR_MESSAGE);
                    	} else {
                    	    try {
                    	        int centerX = Integer.parseInt(centerXCord);
                    	        int centerY = Integer.parseInt(centerYCord);
                    	        int circleRadius = Integer.parseInt(radius);
                    	        int innerCircleRadius = Integer.parseInt(innerRadius);

                    	        if (innerCircleRadius <= 0 || circleRadius <= 0 || centerX < 0 || centerY < 0) {
                    	            JOptionPane.showMessageDialog(null, "Please insert values greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
                    	        } else {
                    	            if (innerCircleRadius < circleRadius) {
                    	                donut = new Donut(new Point(centerX, centerY), circleRadius, false, innerCircleRadius,
                    	                        txtColor.getBackground(), txtInnerColor.getBackground());

                    	                setConfirmed(true);
                    	                setVisible(false);
                    	            } else {
                    	                JOptionPane.showMessageDialog(null, "Please insert inner radius less than outer radius!", "Error",
                    	                        JOptionPane.ERROR_MESSAGE);
                    	            }
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
    public JTextField getTxtX() {
        return txtCenterX;
    }

    public void setTxtX(JTextField txtX) {
        this.txtCenterX = txtX;
    }

    public JTextField getTxtY() {
        return txtCenterY;
    }

    public void setTxtY(JTextField txtY) {
        this.txtCenterY = txtY;
    }

    public JTextField getTxtR() {
        return txtRadius;
    }

    public void setTxtR(JTextField txtR) {
        this.txtRadius = txtR;
    }

    public JTextField getTxtInnerR() {
        return txtInnerRadius;
    }

    public void setTxtInnerR(JTextField txtInnerR) {
        this.txtInnerRadius = txtInnerR;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirm) {
        this.isConfirmed = confirm;
    }

    public Donut getDonut() {
        return donut;
    }

    public void setDonut(Donut donut) {
        this.donut = donut;
    }

    public JButton getBtnInnerColor() {
        return btnOutlineColor;
    }

    public void setBtnInnerColor(JButton btnInnerColor) {
        this.btnOutlineColor = btnInnerColor;
    }

    public JButton getBtnOutlineColor() {
        return btnInnerColor;
    }

    public void setBtnOutlineColor(JButton btnOutlineColor) {
        this.btnInnerColor = btnOutlineColor;
    }

	public JTextField getTxtInnerColor() {
		return txtColor;
	}

	public void setTxtInnerColor(JTextField txtInnerColor) {
		this.txtColor = txtInnerColor;
	}

	public JTextField getTxtColor() {
		return txtInnerColor;
	}

	public void setTxtColor(JTextField txtColor) {
		this.txtInnerColor = txtColor;
	}

	
}

