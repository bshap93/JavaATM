import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class ChangePasswordView extends JFrame {

	private JPanel contentPane;
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private JLabel invalidOldPasswordLabel;
	private String newPassword;
	private String oldPassword;

	public ChangePasswordView(final User user, final UserCreator userCreator) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTypeYourOld = new JLabel("Type Your Old Password");
		lblTypeYourOld.setBounds(135, 66, 170, 16);
		contentPane.add(lblTypeYourOld);
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setBounds(145, 94, 134, 28);
		contentPane.add(oldPasswordField);
		oldPasswordField.setColumns(10);
		
		JLabel lblTypeYourNew = new JLabel("Type Your New Password");
		lblTypeYourNew.setBounds(135, 133, 170, 16);
		contentPane.add(lblTypeYourNew);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(145, 161, 134, 28);
		contentPane.add(newPasswordField);
		newPasswordField.setColumns(10);
	
		invalidOldPasswordLabel = new JLabel("Invalid old Password");
		invalidOldPasswordLabel.setVisible(false);
		invalidOldPasswordLabel.setForeground(Color.RED);
		invalidOldPasswordLabel.setBounds(145, 81, 134, 16);
		contentPane.add(invalidOldPasswordLabel);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputRead();
				if (user.getPassword().equals(oldPassword)) {
					user.setPassword(newPassword);
					LoggedInView loggedInView = new LoggedInView(user, userCreator);
					loggedInView.setVisible(true);
					dispose();
					
				}
				else {
					invalidOldPasswordLabel.setVisible(true);
				}
						
				}
		});
		submitButton.setBounds(162, 197, 117, 29);
		contentPane.add(submitButton);
		

	}
	
	public void inputRead()
	{

		oldPassword = oldPasswordField.getText();

		newPassword = newPasswordField.getText();
		

	}
}
