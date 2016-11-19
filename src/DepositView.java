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


public class DepositView extends JFrame {

	private JPanel contentPane;
	private JTextField depositAmountTextField;
	private Money depositAmount;
	private JPasswordField passwordAgainTextField;
	private JLabel passwordAgainLabel;
	private String passwordAgain;
	private JButton depositButton;
	private JButton backToMenuButton;
	private JLabel errorWrongPasswordLabel;
	private JLabel errorInvalidDepositLabel;
	private JLabel noATMAccessLabel;


	public DepositView(final User user, final UserCreator userCreator) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel depositAmountLabel = new JLabel("Enter an Amount to Deposit");
		depositAmountLabel.setBounds(122, 124, 197, 16);
		contentPane.add(depositAmountLabel);
		
		depositAmountTextField = new JTextField();
		depositAmountTextField.setBounds(122, 152, 167, 28);
		contentPane.add(depositAmountTextField);
		depositAmountTextField.setColumns(10);
		
		passwordAgainTextField = new JPasswordField();
		passwordAgainTextField.setBounds(122, 81, 167, 28);
		contentPane.add(passwordAgainTextField);
		passwordAgainTextField.setColumns(10);
		
		passwordAgainLabel = new JLabel("Enter Password Again");
		passwordAgainLabel.setBounds(131, 62, 142, 16);
		contentPane.add(passwordAgainLabel);
		
		depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.isHasATMAccess()) {
					try {
						inputRead();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						errorInvalidDepositLabel.setVisible(true);
					}
					if (user.getPassword().equals(passwordAgain)) {
						try {
							user.deposit(depositAmountTextField.getText());
							LoggedInView loggedInView = new LoggedInView(user, userCreator);
							loggedInView.setVisible(true);
							dispose();
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							errorInvalidDepositLabel.setVisible(true);
						}
					}
					else {
						errorWrongPasswordLabel.setVisible(true);
					}
				}
				else {
					noATMAccessLabel.setVisible(true);
				}
			}
			
		});
		depositButton.setBounds(145, 191, 117, 29);
		contentPane.add(depositButton);
		
		backToMenuButton = new JButton("Back to Menu");
		backToMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoggedInView loggedInView = new LoggedInView(user, userCreator);
				loggedInView.setVisible(true);
				dispose();
			}
		});
		backToMenuButton.setBounds(145, 232, 117, 29);
		contentPane.add(backToMenuButton);
		
		errorWrongPasswordLabel = new JLabel("Error: Wrong Password");
		errorWrongPasswordLabel.setVisible(false);
		errorWrongPasswordLabel.setForeground(Color.RED);
		errorWrongPasswordLabel.setBounds(122, 107, 167, 16);
		contentPane.add(errorWrongPasswordLabel);
		
		errorInvalidDepositLabel = new JLabel("Error: Invalid Deposit");
		errorInvalidDepositLabel.setVisible(false);
		errorInvalidDepositLabel.setForeground(Color.RED);
		errorInvalidDepositLabel.setBounds(122, 177, 151, 16);
		contentPane.add(errorInvalidDepositLabel);
		
		noATMAccessLabel = new JLabel("No ATM Access");
		noATMAccessLabel.setVisible(false);
		noATMAccessLabel.setForeground(Color.RED);
		noATMAccessLabel.setBounds(122, 177, 151, 16);
		contentPane.add(noATMAccessLabel);
	}
	
	public void inputRead()
	{
		passwordAgain = passwordAgainTextField.getText();
		depositAmount = new Money(depositAmountTextField.getText());

	}

}
