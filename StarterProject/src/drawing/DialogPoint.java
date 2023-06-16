package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;

public class DialogPoint extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtXCoordinate;
    private JTextField txtYCoordinate;
    private JButton btnColor; 
    private JLabel lblXCoordinate;
    private JLabel lblYCoordinate;
    private JTextField txtColor;
    private boolean isConfirmed;
    private Point point;
 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DialogPoint dialog = new DialogPoint();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DialogPoint() {
        setTitle("EDIT POINT");
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setBounds(100, 100, 252, 314);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(231, 241, 254));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        //Labele 
        {
            lblXCoordinate = new JLabel("X :");
            lblXCoordinate.setForeground(new Color(0, 0, 128));
            lblXCoordinate.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtXCoordinate = new JTextField();
            txtXCoordinate.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtXCoordinate.setColumns(10);
        }
        {
            lblYCoordinate = new JLabel("Y :");
            lblYCoordinate.setForeground(new Color(0, 0, 128));
            lblYCoordinate.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtYCoordinate = new JTextField();
            txtYCoordinate.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtYCoordinate.setColumns(10);
        }
        {
            btnColor = new JButton("Color");
            btnColor.setBackground(SystemColor.control);
            btnColor.setForeground(new Color(0, 0, 128));
            btnColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
            btnColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Color selectedColor = JColorChooser.showDialog(null, "Choose outline color",Color.white);
                    if (selectedColor != null) {
                        txtColor.setBackground(selectedColor);
                        txtColor.setEditable(false);
                        
                    }
                }
            });
        }
        
        JLabel lblTitle = new JLabel("Enter :");
        lblTitle.setForeground(new Color(0, 0, 128));
        lblTitle.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
      
        //Text field X coordinate
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
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblYCoordinate)
        						.addComponent(lblXCoordinate))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtYCoordinate)
        						.addComponent(txtXCoordinate, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGap(73)
        					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(66, Short.MAX_VALUE))
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addGap(60)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(txtColor, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
        				.addComponent(btnColor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(162, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
        	gl_contentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addGap(18)
        			.addComponent(lblTitle)
        			.addGap(18)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblXCoordinate))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblYCoordinate)
        				.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(22)
        			.addComponent(btnColor)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(49))
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
                    	String xCoordTxt = txtXCoordinate.getText().trim();
                    	String yCoordTxt = txtYCoordinate.getText().trim();

                    	if (xCoordTxt.isEmpty() || yCoordTxt.isEmpty()) {
                    	    JOptionPane.showMessageDialog(null, "Please enter coordinates!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    	} else {
                    	    try {
                    	        int xCoord = Integer.parseInt(xCoordTxt);
                    	        int yCoord = Integer.parseInt(yCoordTxt);

                    	        if (xCoord< 0 || yCoord < 0) {
                    	            JOptionPane.showMessageDialog(null, "Number must be greater than 0!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    	        } else {
                    	            point = new Point(xCoord, yCoord, false, txtColor.getBackground());
                    	            isConfirmed = true;
                    	            setVisible(false);
                    	        }
                    	    } catch (NumberFormatException e1) {
                    	        JOptionPane.showMessageDialog(null, "Please enter only numbers!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    	    }
                    	}
                    }});
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
        return txtXCoordinate;
    }

    public void setTxtX(JTextField txtX) {
        this.txtXCoordinate = txtX;
    }

    public JTextField getTxtY() {
        return txtYCoordinate;
    }

    public void setTxtY(JTextField txtY) {
        this.txtYCoordinate = txtY;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirm) {
        this.isConfirmed= confirm;
    }

     public JButton getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(JButton btnColor) {
        this.btnColor = btnColor;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point= point;
    }


	public JTextField getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextField txtColor) {
		this.txtColor = txtColor;
	} 

}