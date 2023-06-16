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
import geometry.Rectangle;


import javax.swing.JLabel;
import javax.swing.JOptionPane;



import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogRectangle extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtUppLeftX;
    private JTextField txtUppLeftY;
    private JTextField txtWidth;
    private JTextField txtHeight;
    private JButton btnInnnerClr;
    private JButton btnOutlineColor;
    private JLabel lblUpperLeftPt;
    private JLabel lblUppLeftX;
    private JLabel lblUppLeftY;
    private JLabel lblWidth;
    private JLabel lblHeight;
    private JLabel lblTitle;
    private JPanel buttonPane;
    private JTextField txtInnerColor;
    private JTextField txtColor;
    public boolean isConfirmed;
    public Rectangle rect; 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DialogRectangle dialog = new DialogRectangle();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DialogRectangle() {
        setModal(true);
        setTitle("EDIT RECTANGLE");
        setResizable(false);
        setLocationRelativeTo(null);
        setBounds(100, 100, 381, 474);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(231, 241, 254));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      
        getContentPane().add(contentPanel, BorderLayout.SOUTH);
        {
            lblUpperLeftPt = new JLabel("Upper left point");
            lblUpperLeftPt.setForeground(new Color(0, 0, 128));
            lblUpperLeftPt.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            lblUppLeftX = new JLabel("X :");
            lblUppLeftX.setForeground(new Color(0, 0, 128));
            lblUppLeftX.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtUppLeftX = new JTextField();
            txtUppLeftX.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtUppLeftX.setColumns(10);
        }
        {
            lblUppLeftY = new JLabel("Y :");
            lblUppLeftY.setForeground(new Color(0, 0, 128));
            lblUppLeftY.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtUppLeftY = new JTextField();
            txtUppLeftY.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtUppLeftY.setColumns(10);
        }
        {
            lblWidth = new JLabel("Width :");
            lblWidth.setForeground(new Color(0, 0, 128));
            lblWidth.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtWidth = new JTextField();
            txtWidth.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtWidth.setColumns(10);
        }
        {
            lblHeight = new JLabel("Height :");
            lblHeight.setForeground(new Color(0, 0, 128));
            lblHeight.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        }
        {
            txtHeight = new JTextField();
            txtHeight.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            txtHeight.setColumns(10);
        }
        {
            {
                btnInnnerClr = new JButton("Inner Color");
                btnInnnerClr.setBackground(SystemColor.control);
                btnInnnerClr.setForeground(new Color(0, 0, 128));
                btnInnnerClr.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
                btnInnnerClr.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Color innerClr = JColorChooser.showDialog(null, "Choose inner color!", Color.white);
                        if (innerClr != null)
                        txtInnerColor.setBackground(innerClr);
                        txtInnerColor.setEditable(false);
                    }
                });
            }
        }
        {
            btnOutlineColor = new JButton("Outline Color");
            btnOutlineColor.setBackground(SystemColor.control);
            btnOutlineColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
            btnOutlineColor.setForeground(new Color(0, 0, 128));
            btnOutlineColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Color outlineClr = JColorChooser.showDialog(null, "Choose outline color",Color.white);
                    if (outlineClr != null)
                    txtColor.setBackground(outlineClr);
                    txtColor.setEditable(false);
                }
            });
        }
        
        lblTitle = new JLabel("Enter :");
        lblTitle.setForeground(new Color(0, 0, 128));
        lblTitle.setFont(new Font("Segoe UI Black", Font.PLAIN, 22));
        
        {
            buttonPane = new JPanel();
            buttonPane.setBackground(new Color(200, 222, 253));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            {
                JButton okButton = new JButton("OK");
                okButton.setForeground(new Color(0, 0, 128));
                okButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
                okButton.setBackground(SystemColor.control);
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                    	String upperLeftPtX = txtUppLeftX.getText().trim(); // trim brise razmake
                    	String upperLeftPtY = txtUppLeftY.getText().trim();
                    	String height = txtHeight.getText().trim();
                    	String width = txtWidth.getText().trim();

                    	if (upperLeftPtX.isEmpty() || upperLeftPtY.isEmpty() || height.isEmpty() || width.isEmpty()) {
                    	    setConfirmed(false);
                    	    JOptionPane.showMessageDialog(null, "All values are required, please enter them!", "Error", JOptionPane.ERROR_MESSAGE);
                    	} else {
                    	    try {
                    	        int uppLeftXCoord = Integer.parseInt(upperLeftPtX);
                    	        int uppLeftYCoord = Integer.parseInt(upperLeftPtY);
                    	        int rectHeight = Integer.parseInt(height);
                    	        int rectWidth = Integer.parseInt(width);

                    	        if (rectWidth <= 0 || rectHeight <= 0 || uppLeftXCoord < 0 || uppLeftYCoord < 0) {
                    	            JOptionPane.showMessageDialog(null, "Insert values greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
                    	        } else {
                    	            Point upperLeftPoint = new Point(uppLeftXCoord, uppLeftYCoord);
                    	            rect = new Rectangle(upperLeftPoint, rectWidth, rectHeight, false, txtColor.getBackground(), txtInnerColor.getBackground());

                    	            setConfirmed(true);
                    	            setVisible(false);
                    	        }
                    	    } catch (NumberFormatException e1) {
                    	        JOptionPane.showMessageDialog(null, "Please enter numbers only!", "Error", JOptionPane.ERROR_MESSAGE);
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
        
        //Text Field edit
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
        			.addContainerGap()
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPanel.createSequentialGroup()
        					.addGap(64)
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblWidth)
        						.addComponent(lblUppLeftY)
        						.addComponent(lblUppLeftX)
        						.addComponent(lblHeight))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtHeight, 0, 0, Short.MAX_VALUE)
        						.addComponent(txtWidth, 0, 0, Short.MAX_VALUE)
        						.addComponent(txtUppLeftY, 0, 0, Short.MAX_VALUE)
        						.addComponent(txtUppLeftX, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
        				.addComponent(lblUpperLeftPt))
        			.addContainerGap(128, Short.MAX_VALUE))
        		.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addGap(101)
        			.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(177, Short.MAX_VALUE))
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(txtInnerColor, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        				.addComponent(btnInnnerClr, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
        			.addGap(29)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnOutlineColor)
        				.addComponent(txtColor, 0, 0, Short.MAX_VALUE))
        			.addContainerGap())
        );
        gl_contentPanel.setVerticalGroup(
        	gl_contentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPanel.createSequentialGroup()
        			.addGap(32)
        			.addComponent(lblTitle)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblUpperLeftPt)
        			.addGap(10)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtUppLeftX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblUppLeftX))
        			.addGap(13)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtUppLeftY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblUppLeftY))
        			.addGap(21)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblWidth))
        			.addGap(17)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblHeight))
        			.addGap(26)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnInnnerClr)
        				.addComponent(btnOutlineColor))
        			.addGap(18)
        			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtInnerColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
        			.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        contentPanel.setLayout(gl_contentPanel);
    }
    
    //Get i set metode

    public JTextField getTxtX() {
        return txtUppLeftX;
    }

    public void setTxtX(JTextField txtX) {
        this.txtUppLeftX = txtX;
    }

    public JTextField getTxtY() {
        return txtUppLeftY;
    }

    public void setTxtY(JTextField txtY) {
        this.txtUppLeftY = txtY;
    }

    public JTextField getTxtHeight() {
        return txtHeight;
    }

    public void setTxtHeight(JTextField txtHeight) {
        this.txtHeight = txtHeight;
    }

    public JTextField getTxtWidth() {
        return txtWidth;
    }

    public void setTxtWidth(JTextField txtWidth) {
        this.txtWidth = txtWidth;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirm) {
        this.isConfirmed = confirm;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public JButton getBtnInnerColor() {
        return btnInnnerClr;
    }

    public void setBtnInnerColor(JButton btnInnerColor) {
        this.btnInnnerClr = btnInnerColor;
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
