package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXCoordinate;
	private JTextField txtRadius;
	private JTextField txtYCoordinate;
	public boolean isConfirmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StackDialog dialog = new StackDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StackDialog() {
		setModal(true);
		setTitle("Milica Misan IT8/2022");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 240, 245));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblInfo = new JLabel("Information about circle");
		lblInfo.setForeground(new Color(219, 112, 147));
		lblInfo.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		JLabel lblRadius = new JLabel("Add radius");
		lblRadius.setForeground(new Color(219, 112, 147));
		lblRadius.setHorizontalAlignment(SwingConstants.CENTER);
		lblRadius.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		JLabel lblXCoordinate = new JLabel("Add x coordinate ");
		lblXCoordinate.setForeground(new Color(219, 112, 147));
		lblXCoordinate.setHorizontalAlignment(SwingConstants.CENTER);
		lblXCoordinate.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		JLabel lblYCoordinate = new JLabel("Add y coordinate ");
		lblYCoordinate.setForeground(new Color(219, 112, 147));
		lblYCoordinate.setHorizontalAlignment(SwingConstants.CENTER);
		lblYCoordinate.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		
		txtXCoordinate = new JTextField();
		txtXCoordinate.setColumns(10);
		
		txtRadius = new JTextField();
		txtRadius.setColumns(10);
		
		txtYCoordinate = new JTextField();
		txtYCoordinate.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(54)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblYCoordinate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblXCoordinate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(46)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(26)
							.addComponent(lblInfo)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblInfo)
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRadius))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinate)
						.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinate)
						.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 240, 245));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 if(getTxtXCoordinate().getText().isEmpty()){
	                            JOptionPane.showMessageDialog(null, "Please, enter a value for circle.", "Message", JOptionPane.ERROR_MESSAGE);
	                        } else if(getTxtYCoordinate().getText().isEmpty()){
	                            JOptionPane.showMessageDialog(null, "Please, enter a value for circle.", "Message", JOptionPane.ERROR_MESSAGE);
	                        } else if(getTxtRadius().getText().isEmpty()) {
	                            JOptionPane.showMessageDialog(null, "Please, enter a value for cricle.", "Message", JOptionPane.ERROR_MESSAGE);
	                        }
	                    
	                    else {
	                        try {
	                            if(Integer.parseInt(getTxtRadius().getText()) > 0) {
	                               isConfirmed = true;
	                                setVisible(false);
	                            } else {
	                                JOptionPane.showMessageDialog(null, "Radius must be integer and greater than 0.", "Message", JOptionPane.ERROR_MESSAGE);
	                            }
	                        } catch (Exception NumberFormatException){
	                            JOptionPane.showMessageDialog(null, "Radius must be integer and greater than 0.", "Message", JOptionPane.ERROR_MESSAGE);
	                        }
	                    }
	                    }
					});
				okButton.setForeground(new Color(219, 112, 147));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
				}
				});
				cancelButton.setForeground(new Color(219, 112, 147));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public final JTextField getTxtXCoordinate() {
		return txtXCoordinate;
	}

	public final void setTxtXCoordinate(JTextField txtXCoordinate) {
		this.txtXCoordinate = txtXCoordinate;
	}

	public final JTextField getTxtRadius() {
		return txtRadius;
	}

	public final void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public final JTextField getTxtYCoordinate() {
		return txtYCoordinate;
	}

	public final void setTxtYCoordinate(JTextField txtYCoordinate) {
		this.txtYCoordinate = txtYCoordinate;
	}

	public final boolean isConfirmed() {
		return isConfirmed;
	}

	public final void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
}
