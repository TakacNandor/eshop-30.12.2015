package account;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import java.util.Scanner;



public class Account  {
	Scanner input = new Scanner(System.in);
	PrintWriter writer = null;
	
	List<Account> accList= new ArrayList<>();
	
	private String nickname;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private boolean admin;
	
	public Account(){
		
	}
	public Account(String firstName, String lastName, String address, String phoneNumber,String nickname, String password) {
		
		this.nickname=nickname;
		this.password=password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		
	}
	
	public void createAcc() throws IOException{
		writer = new PrintWriter(new FileWriter("src\\accounts.txt", true));
		
		System.out.println("Account name: ");
		setNickname(input.next());
		System.out.println("Password: ");
		setPassword(input.next());
		System.out.println("Firstname: ");
		setFirstName(input.next());
		System.out.println("Lastname: ");
		setLastName(input.next());
		System.out.println("Address: ");
		setAddress(input.next());
	
		System.out.println("Phone number: ");
		setPhoneNumber(input.next());
		
		writer.println("Nickname: "+  getNickname()+ "\n"+
						"Password: "+  getPassword()+ "\n"+
						"FirstName: "+getFirstName()+"\n"+
						"LastName: "+ getLastName()+ "\n"+
						"Address: "+  getAddress()+  "\n"+
						"Phone number: "+ getPhoneNumber()+ "\n");
		
		writer.flush();
		writer.close();
	}

	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	public List<Account> getAccList() {
		return accList;
	}

	public void setAccList(List<Account> accList) {
		this.accList = accList;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	

}
