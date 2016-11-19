import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CheckBalanceView extends JFrame {

	private JPanel contentPane;
	private JTextField accountBalanceTextField;
	private JButton backButton;

	public CheckBalanceView(final User user, final UserCreator userCreator) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel checkBalanceLabel = new JLabel("Your Current Account Balance:");
		checkBalanceLabel.setBounds(113, 83, 212, 16);
		contentPane.add(checkBalanceLabel);
		
		accountBalanceTextField = new JTextField();
		accountBalanceTextField.setBounds(123, 111, 185, 28);
		contentPane.add(accountBalanceTextField);
		accountBalanceTextField.setColumns(10);
		accountBalanceTextField.setEditable(false);
		accountBalanceTextField.setText(user.getBalanceAmount().toString());
		
		backButton = new JButton("Back to Menu");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoggedInView loggedInView = new LoggedInView(user, userCreator);
				loggedInView.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(161, 151, 117, 29);
		contentPane.add(backButton);
	}
}
