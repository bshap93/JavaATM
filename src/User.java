import java.util.ArrayList;


public class User {
	private String accountNumber;
	private String lastName;
	private String firstName;
	private Money balanceAmount;
	private boolean hasATMAccess;
	private String password;
	private static ArrayList<User> userList = new ArrayList<User>();
	
	public User(String accountNumber, String lastName, String firstName, Money balanceAmount, boolean hasATMAccess, String password)
	{
		this.setAccountNumber(accountNumber);
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setBalanceAmount(balanceAmount);
		this.setHasATMAccess(hasATMAccess);
		this.setPassword(password);
		userList.add(this);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Money getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Money balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public boolean isHasATMAccess() {
		return hasATMAccess;
	}

	public void setHasATMAccess(boolean hasATMAccess) {
		this.hasATMAccess = hasATMAccess;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void deposit(String amount)
	{
		balanceAmount.addIn(new Money(amount));
	}
	
	public void withdraw(String amount)
	{
		String amountWithdwawnString = ("-" + amount);
		balanceAmount.addIn(new Money(amountWithdwawnString));
	}
	
	public String toString()
	{
		return (firstName + " " + lastName + ": \nAccount#: " + accountNumber + "\nBalance: " + balanceAmount); 
	}

	public static ArrayList<User> getUserList() {
		return userList;
	}


	public static void setUserList(ArrayList<User> userList) {
		User.userList = userList;
	}
}
