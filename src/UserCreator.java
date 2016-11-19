import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class UserCreator {
	
	private Scanner accountInfoScanner;
	private Scanner passwordScanner;
	private User newUser;
	private static ArrayList<User> userList = new ArrayList<User>();
	public UserCreator()
	{
		try {
			Scanner accountInfoScanner = new Scanner(new FileInputStream("AccountInformation.txt"));
			this.accountInfoScanner = accountInfoScanner;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Scanner passwordScanner = new Scanner(new FileInputStream("Password.txt"));
			this.passwordScanner = passwordScanner;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (passwordScanner.hasNextLine() && accountInfoScanner.hasNextLine())
		{
			String accountNumber = accountInfoScanner.nextLine();
			String lastName = accountInfoScanner.nextLine();
			String firstName = accountInfoScanner.nextLine();
			Money balanceAmount = new Money(accountInfoScanner.nextLine());
			String hasATMAccessString = accountInfoScanner.nextLine();
			boolean hasATMAccess;
			if (hasATMAccessString.equals("disabled"))
				hasATMAccess = false;
			else if (hasATMAccessString.equals("active"))
				hasATMAccess = true;
			else
				hasATMAccess = false;
			String password = passwordScanner.nextLine();
			setNewUser(new User(accountNumber, lastName, firstName, balanceAmount, hasATMAccess, password));
		}
	}
	public User getNewUser() {
		return newUser;
	}
	public void setNewUser(User newUser) {
		this.newUser = newUser;
		userList.add(newUser);
	}
	public static ArrayList<User> getUserList() {
		return userList;
	}
	public static void setUserList(ArrayList<User> userList) {
		UserCreator.userList = userList;
	}
}
