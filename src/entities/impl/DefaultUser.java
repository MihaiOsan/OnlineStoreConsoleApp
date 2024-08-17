package entities.impl;
import entities.User;

public class DefaultUser implements User {


	private String firstName;
	private String lastName;
	private String password;
	private String email;
	
	public DefaultUser() {
	}
	
	public DefaultUser(String firstName, String lastName, String password, String email) {
		// <write your code here>
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}
	
	@Override
	public String getLastName() {
		return null;
	}

	@Override
	public String getPassword() {
		// <write your code here>
		return null;
	}

	@Override
	public String getEmail() {
		// <write your code here>
		return null;
	}
	
	@Override
	public String toString() {
		// <write your code here>
		return null;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	@Override
	public int getId() {
		return 0;
	}
	
	void clearState() {
		// <write your code here>
	}

}
