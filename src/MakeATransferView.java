import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class MakeATransferView extends JFrame {

	private JPanel contentPane;
	private JLabel passwordAgainLabel;
	private JPasswordField passwordAgainTextField;
	private String passwordAgain;
	private JLabel transferToAccountLabel;
	private JTextField transferToAccountTextField;
	private String transferToAccountString;
	private JTextField amountToTransferTextField;
	private JLabel amountToTransferLabel;
	private String amountToTransfer;
	private JButton transferMoneyButton;
	private User otherUser;
	private JLabel userDoesntExistLabel;
	private JLabel errorInvalidTransferLabel;
	private JLabel errorWrongPasswordLabel;
	private JLabel noATMAccessLabel;
	private JLabel insufficientLabel;
	private JButton backToMenuButton;

	public MakeATransferView(final User user, final UserCreator userCreator) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordAgainTextField = new JPasswordField();
		passwordAgainTextField.setBounds(122, 32, 167, 28);
		contentPane.add(passwordAgainTextField);
		passwordAgainTextField.setColumns(10);
		
		
		passwordAgainLabel = new JLabel("Enter Password Again");
		passwordAgainLabel.setBounds(132, 0, 167, 20);
		contentPane.add(passwordAgainLabel);
		
		transferToAccountLabel = new JLabel("Enter User's Account Number to Transfer To");
		transferToAccountLabel.setBounds(71, 72, 294, 16);
		contentPane.add(transferToAccountLabel);
		
		transferToAccountTextField = new JTextField();
		transferToAccountTextField.setBounds(122, 100, 167, 28);
		contentPane.add(transferToAccountTextField);
		transferToAccountTextField.setColumns(10);
		
		amountToTransferTextField = new JTextField();
		amountToTransferTextField.setBounds(122, 163, 167, 28);
		contentPane.add(amountToTransferTextField);
		amountToTransferTextField.setColumns(10);
		
		amountToTransferLabel = new JLabel("Enter Amount in Dollars to Transfer");
		amountToTransferLabel.setBounds(92, 135, 235, 16);
		contentPane.add(amountToTransferLabel);
		
		transferMoneyButton = new JButton("Transfer Money");
		transferMoneyButton.setBounds(122, 203, 167, 29);
		contentPane.add(transferMoneyButton);
		transferMoneyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (user.isHasATMAccess()) {
					try {
						inputRead();
						for (int i = 0; i < User.getUserList().size(); i++)
							if (User.getUserList().get(i).getAccountNumber().equals(transferToAccountString))
							{
								otherUser = User.getUserList().get(i);
								otherUser.deposit(amountToTransfer);
								user.withdraw(amountToTransfer);
							}
					} catch (Exception e2) {
						errorInvalidTransferLabel.setVisible(true);
					}
				}
				else {
					noATMAccessLabel.setVisible(true);
				}
			}
		});

		
		userDoesntExistLabel = new JLabel("User Doesn't Exist");
		userDoesntExistLabel.setVisible(false);
		userDoesntExistLabel.setForeground(Color.RED);
		userDoesntExistLabel.setBounds(142, 85, 147, 16);
		contentPane.add(userDoesntExistLabel);
		
		errorInvalidTransferLabel = new JLabel("Error: Invalid Withdraw");
		errorInvalidTransferLabel.setVisible(false);
		errorInvalidTransferLabel.setForeground(Color.RED);
		errorInvalidTransferLabel.setBounds(132, 150, 151, 16);
		contentPane.add(errorInvalidTransferLabel);
		
		errorWrongPasswordLabel = new JLabel("Error: Wrong Password");
		errorWrongPasswordLabel.setVisible(false);
		errorWrongPasswordLabel.setForeground(Color.RED);
		errorWrongPasswordLabel.setBounds(132, 20, 167, 16);
		contentPane.add(errorWrongPasswordLabel);
		
		noATMAccessLabel = new JLabel("No ATM Access");
		noATMAccessLabel.setVisible(false);
		noATMAccessLabel.setForeground(Color.RED);
		noATMAccessLabel.setBounds(138, 189, 151, 16);
		contentPane.add(noATMAccessLabel);
		
		insufficientLabel = new JLabel("Insufficient Funds");
		insufficientLabel.setVisible(false);
		insufficientLabel.setForeground(Color.RED);
		insufficientLabel.setBounds(132, 150, 167, 16);
		contentPane.add(insufficientLabel);
		
		
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
	}
	
	public void inputRead()
	{
		passwordAgain = passwordAgainTextField.getText();
		transferToAccountString = transferToAccountTextField.getText();
		amountToTransfer = amountToTransferTextField.getText();

	}

}
