package sort;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SortDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadius;
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	public boolean isConfirmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SortDialog dialog = new SortDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SortDialog() {
		setModal(true);
		setTitle("Milica Misan IT8/2022");
		setBounds(100, 100, 357, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(235, 231, 254));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		JLabel lblInfo = new JLabel("Create a circle");
		lblInfo.setBackground(new Color(0, 0, 0));
		lblInfo.setForeground(new Color(153, 102, 255));
		lblInfo.setFont(new Font("Segoe UI Black", Font.PLAIN, 26));
		JLabel lblRadius = new JLabel("Add radius");
		lblRadius.setForeground(new Color(153, 102, 255));
		lblRadius.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		JLabel lblXCoordinate = new JLabel("Add x coordinate");
		lblXCoordinate.setForeground(new Color(153, 102, 255));
		lblXCoordinate.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		JLabel lblYCoordinate = new JLabel("Add y coordinate");
		lblYCoordinate.setForeground(new Color(153, 102, 255));
		lblYCoordinate.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		
		txtRadius = new JTextField();
		txtRadius.setColumns(10);
		
		txtXCoordinate = new JTextField();
		txtXCoordinate.setColumns(10);
		
		txtYCoordinate = new JTextField();
		txtYCoordinate.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblYCoordinate, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblXCoordinate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(161, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblInfo)
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinate)
						.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinate)
						.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(235, 231, 254));
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
				okButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				okButton.setForeground(new Color(153, 102, 255));
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
				cancelButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				cancelButton.setForeground(new Color(153, 102, 255));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public final JTextField getTxtRadius() {
		return txtRadius;
	}

	public final void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public final JTextField getTxtXCoordinate() {
		return txtXCoordinate;
	}

	public final void setTxtXCoordinate(JTextField txtXCoordinate) {
		this.txtXCoordinate = txtXCoordinate;
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
