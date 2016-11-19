import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField accountNumberField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private String password;
	private String accountNumber;
	private UserCreator userCreator;
	private JLabel invalidLoginLabel;

	public LoginView(final UserCreator userCreator) {
		this.userCreator = userCreator;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setBounds(80, 73, 116, 16);
		contentPane.add(lblAccountNumber);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(130, 101, 74, 16);
		contentPane.add(lblPassword);
		
		accountNumberField = new JTextField();
		accountNumberField.setBounds(210, 67, 134, 28);
		contentPane.add(accountNumberField);
		accountNumberField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 101, 134, 28);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputRead();
				for (User user : UserCreator.getUserList())
				{
					if (user.getAccountNumber().equals(accountNumber) && (user.getPassword().equals(password))) {
						LoggedInView loggedInView = new LoggedInView(user, userCreator);
						loggedInView.setVisible(true);
						dispose();
					}
					else {
						invalidLoginLabel.setVisible(true);
					}
							
				}
			}
		});
		loginButton.setBounds(210, 153, 117, 29);
		contentPane.add(loginButton);
		
		invalidLoginLabel = new JLabel("Invalid Account Number or Password");
		invalidLoginLabel.setVisible(false);
		invalidLoginLabel.setForeground(Color.RED);
		invalidLoginLabel.setBounds(101, 45, 243, 16);
		contentPane.add(invalidLoginLabel);
		
	}
	public void inputRead()
	{

		accountNumber = accountNumberField.getText();

		password = passwordField.getText();
		

	}
	
}
