package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Font;

public class DialogCircle extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCenterX;
    private JTextField txtCenterY;
    private JTextField txtRadius;
    private JButton btnInnerColor;
    private JButton btnOutlineColor;
    private JLabel lblCenter;
    private JLabel lblCenterX;
    private JLabel lblCenterY;
    private JLabel lblRadius;
    private JTextField txtInnerColor;
    private JTextField txtColor;
    private Circle circle;
    private boolean isConfirmed;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DialogCircle dialog = new DialogCircle();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DialogCircle() {
       
        setResizable(false);
        setTitle("EDIT CIRCLE");
        setModal(true);
        setBounds(100, 100, 361, 341);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(231, 241, 254));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        {
            lblCenter = new JLabel("Center");
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
            btnInnerColor = new JButton("Inner Color");
            btnInnerColor.setBackground(SystemColor.control);
            btnInnerColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
            btnInnerColor.setForeground(new Color(0, 0, 128));
            btnInnerColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    Color innerClr = JColorChooser.showDialog(null, "Choose inner color",Color.white);
                    if (innerClr != null)
                    txtInnerColor.setBackground(innerClr);
                    txtInnerColor.setEditable(false);
                }
            });
        }
        {
            btnOutlineColor = new JButton("Outline color");
            btnOutlineColor.setBackground(SystemColor.control);
            btnOutlineColor.setForeground(new Color(0, 0, 128));
            btnOutlineColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
            btnOutlineColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    Color outlineClr = JColorChooser.showDialog(null, "Choose outline color",Color.white);
                    if (outlineClr != null)
                     txtColor.setBackground(outlineClr);
                     txtColor.setEditable(false);
                }
            });
        }
        JLabel lblTitle = new JLabel("Enter :");
        lblTitle.setForeground(new Color(0, 0, 128));
        lblTitle.setFont(new Font("Segoe UI Black", Font.PLAIN, 22));
        txtInnerColor = new JTextField();
        txtInnerColor.setEditable(false);
        txtInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtInnerColor.setColumns(10);
        txtColor = new JTextField();
        txtColor.setEditable(false);
        txtColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtColor.setColumns(10);
        txtColor.setBackground(Color.black);
        
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
        	gl_contentPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGap(86)
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblCenterX)
        						.addComponent(lblCenterY))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtCenterY, 0, 0, Short.MAX_VALUE)
        						.addComponent(txtCenterX, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblCenter))
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGap(101)
        					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblRadius)
        					.addGap(18)
        					.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(98, Short.MAX_VALUE))
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(txtInnerColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        				.addComponent(btnInnerColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(49)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(txtColor, 0, 0, Short.MAX_VALUE)
        				.addComponent(btnOutlineColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(146))
        );
        gl_contentPanel.setVerticalGroup(
        	gl_contentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblTitle)
        			.addGap(15)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblCenterX))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblCenterY)))
        				.addComponent(lblCenter))
        			.addGap(13)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblRadius)
        				.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(26)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnInnerColor)
        				.addComponent(btnOutlineColor))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtInnerColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(17, Short.MAX_VALUE))
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
                        
                    	String centerXCoord = txtCenterX.getText().trim();
                    	String centerYCoord = txtCenterY.getText().trim();
                    	String radius = txtRadius.getText().trim();

                    	if (centerXCoord.isEmpty() || centerYCoord.isEmpty() || radius.isEmpty()) {
                    	    setConfirmed(false);
                    	    JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    	} else {
                    	    try {
                    	        int centerX = Integer.parseInt(centerXCoord);
                    	        int centerY = Integer.parseInt(centerYCoord);
                    	        int circleRadius = Integer.parseInt(radius);

                    	        if (circleRadius <= 0 || centerX < 0 || centerY < 0) {
                    	            JOptionPane.showMessageDialog(null, "Enter a number greater than 0!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    	        } else {
                    	            Point centerPoint = new Point(centerX, centerY);
                    	            circle = new Circle(centerPoint, circleRadius, false, txtInnerColor.getBackground(), txtColor.getBackground());

                    	            setConfirmed(true);
                    	            setVisible(false);
                    	        }
                    	    } catch (NumberFormatException e2) {
                    	        JOptionPane.showMessageDialog(null, "Enter numbers!", "Error", JOptionPane.ERROR_MESSAGE);
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

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirm) {
        this.isConfirmed = confirm;
    }

    public JButton getBtnInnerColor() {
        return btnInnerColor;
    }

    public void setBtnInnerColor(JButton btnInnerColor) {
        this.btnInnerColor = btnInnerColor;
    }

    public JButton getBtnOutlineColor() {
        return btnOutlineColor;
    }

    public void setBtnOutlineColor(JButton btnOutlineColor) {
        this.btnOutlineColor = btnOutlineColor;
    }

	public JTextField getTxtInnerColor() {
		return txtInnerColor;
	}

	public void setTxtInnerColor(JTextField txtInnerColor) {
		this.txtInnerColor = txtInnerColor;
	}

	public JTextField getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextField txtColor) {
		this.txtColor = txtColor;
	}
	
}
