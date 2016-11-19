import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.InsufficientResourcesException;
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


public class WithdrawView extends JFrame {

	private JPanel contentPane;
	private JTextField withdrawAmountTextField;
	private Money withdrawAmount;
	private JPasswordField passwordAgainTextField;
	private JLabel passwordAgainLabel;
	private String passwordAgain;
	private JButton withdrawButton;
	private JButton backToMenuButton;
	private JLabel errorWrongPasswordLabel;
	private JLabel errorInvalidWithdrawLabel;
	private JLabel noATMAccessLabel;
	private JLabel insufficientLabel;


	public WithdrawView(final User user, final UserCreator userCreator) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel withdrawAmountLabel = new JLabel("Enter an Amount to Withdraw");
		withdrawAmountLabel.setBounds(122, 124, 197, 16);
		contentPane.add(withdrawAmountLabel);
		
		withdrawAmountTextField = new JTextField();
		withdrawAmountTextField.setBounds(122, 152, 167, 28);
		contentPane.add(withdrawAmountTextField);
		withdrawAmountTextField.setColumns(10);
		
		passwordAgainTextField = new JPasswordField();
		passwordAgainTextField.setBounds(122, 81, 167, 28);
		contentPane.add(passwordAgainTextField);
		passwordAgainTextField.setColumns(10);
		
		passwordAgainLabel = new JLabel("Enter Password Again");
		passwordAgainLabel.setBounds(131, 62, 142, 16);
		contentPane.add(passwordAgainLabel);
		
		withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.isHasATMAccess()) {
					try {
						inputRead();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						errorInvalidWithdrawLabel.setVisible(true);
					}
					if (user.getPassword().equals(passwordAgain)) {
						try {
							if ((user.getBalanceAmount().toDouble() - Double.parseDouble(withdrawAmountTextField.getText())) > 0) {
								user.withdraw(withdrawAmountTextField.getText());
								LoggedInView loggedInView = new LoggedInView(user, userCreator);
								loggedInView.setVisible(true);
								dispose();
							}
							else {
								insufficientLabel.setVisible(true);
							}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							errorInvalidWithdrawLabel.setVisible(true);
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
		withdrawButton.setBounds(145, 191, 117, 29);
		contentPane.add(withdrawButton);
		
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
		
		errorInvalidWithdrawLabel = new JLabel("Error: Invalid Withdraw");
		errorInvalidWithdrawLabel.setVisible(false);
		errorInvalidWithdrawLabel.setForeground(Color.RED);
		errorInvalidWithdrawLabel.setBounds(122, 177, 151, 16);
		contentPane.add(errorInvalidWithdrawLabel);
		
		noATMAccessLabel = new JLabel("No ATM Access");
		noATMAccessLabel.setVisible(false);
		noATMAccessLabel.setForeground(Color.RED);
		noATMAccessLabel.setBounds(122, 177, 151, 16);
		contentPane.add(noATMAccessLabel);
		
		insufficientLabel = new JLabel("Insufficient Funds");
		insufficientLabel.setVisible(false);
		insufficientLabel.setForeground(Color.RED);
		insufficientLabel.setBounds(132, 177, 167, 16);
		contentPane.add(insufficientLabel);
	}
	
	public void inputRead()
	{
		passwordAgain = passwordAgainTextField.getText();
		withdrawAmount = new Money(withdrawAmountTextField.getText());

	}

}
