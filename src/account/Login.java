package account;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Controller.CustomerController;
import data.Customer;
import starter.connect_DB;

public class Login extends connect_DB {
	Scanner input = new Scanner(System.in);

	public void userLogin() {

		try {
			Statement statement = getDBConnection().createStatement();
			System.out.println("Enter your name: ");
			String name = input.next();
			System.out.println("Enter your password: ");
			String password = input.next();
			ResultSet result = null;
			boolean a = false;

			result = statement.executeQuery("select * from user ;");
			// where username='" + name + "' and password='" + password + "'

			while (result.next()) {

				if (result.getString("username").equals(name) && result.getString("password").equals(password)) {
					// result=statement.executeQuery("select id_user from user
					// where username='"+name+"' and password='"+password+"'");
					// while(result.next()) {
					// System.out.println(result.getInt(1));

					statement.executeUpdate("INSERT INTO `loged_user` (`loged_user_id`, `user_id`) VALUES (NULL, '"
							+ result.getInt("id_user") + "');");
					a = true;
				}
			}
			if (!a) {
				System.out.println("Incorrect username or password!");
			}

			result.close();
		} catch (SQLException sx) {
			System.out.println("SQLException: " + sx.getMessage());
			System.out.println("SQLState: " + sx.getSQLState());
			System.out.println("VendorError: " + sx.getErrorCode());
		}
	}

	public void userLogout() {

		try {
			Statement statement = getDBConnection().createStatement();
			statement.executeUpdate("delete from loged_user");

		} catch (SQLException sx) {
			System.out.println("SQLException: " + sx.getMessage());
			System.out.println("SQLState: " + sx.getSQLState());
			System.out.println("VendorError: " + sx.getErrorCode());
		}
	}

}
