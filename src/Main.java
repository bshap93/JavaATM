import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserCreator userCreator = new UserCreator();
		LoginView firstLoginView = new LoginView(userCreator);
		firstLoginView.setVisible(true);
	}

}
