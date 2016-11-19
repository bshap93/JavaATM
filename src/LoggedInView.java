import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;


public class LoggedInView extends JFrame {

	private JPanel contentPane;
	private UserCreator userCreator;
	private JLabel greetingLabel;

	// these finals may cause problems
	public LoggedInView(final User user, final UserCreator userCreator) {
		this.userCreator = userCreator;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView anotherLoginView = new LoginView(userCreator);
				anotherLoginView.setVisible(true);
				dispose();
			}
		});
		logoutButton.setBounds(274, 201, 131, 40);
		contentPane.add(logoutButton);
		
		JButton changePasswordButton = new JButton("Change Password");
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePasswordView changePasswordView = new ChangePasswordView(user, userCreator);
				changePasswordView.setVisible(true);
				dispose();
			}
		});
		changePasswordButton.setBounds(63, 201, 131, 40);
		contentPane.add(changePasswordButton);
		
		JButton checkBalanceButton = new JButton("Check Balance");
		checkBalanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckBalanceView checkBalanceView = new CheckBalanceView(user, userCreator);
				checkBalanceView.setVisible(true);
				dispose();
			}
		});
		checkBalanceButton.setBounds(63, 120, 124, 40);
		contentPane.add(checkBalanceButton);
		
		JButton depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositView depositView = new DepositView(user,userCreator);
				depositView.setVisible(true);
				dispose();
			}
		});
		depositButton.setBounds(63, 49, 131, 40);
		contentPane.add(depositButton);
		
		greetingLabel = new JLabel("Hello, " + user.getFirstName() + " " + user.getLastName());
		greetingLabel.setFont(new Font("Arial", Font.BOLD, 15));
		greetingLabel.setBounds(68, 21, 265, 16);
		contentPane.add(greetingLabel);
		
		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(274, 49, 124, 40);
		contentPane.add(withdrawButton);
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WithdrawView withdrawView = new WithdrawView(user,userCreator);
				withdrawView.setVisible(true);
				dispose();
			}
		});
		
		
		JButton makeATransferButton = new JButton("Make a Transfer");
		makeATransferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MakeATransferView makeATransferView = new MakeATransferView(user,userCreator);
				makeATransferView.setVisible(true);
				dispose();
			}
		});
		makeATransferButton.setBounds(274, 120, 131, 40);
		contentPane.add(makeATransferButton);
		
		

	}
}
