package account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

	Scanner sc;

	public void openFile() {
		try {
			sc = new Scanner(new File("accounts.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

	public boolean passChecker(String nick, String pass) throws FileNotFoundException {

		if (sc.hasNextLine()) {
			if (sc.nextLine().matches("Nickname: " + nick)) {
				if (sc.nextLine().contains(pass)) {
					return true;
				}
				System.out.println("Wrong password!");
			}
		}
		return false;
	}

}
