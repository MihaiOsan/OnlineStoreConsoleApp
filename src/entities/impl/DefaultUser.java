package entities.impl;

import entities.User;

public class DefaultUser implements User {

	private static int userCount = 0;

	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;

	{
		id = userCount;
		userCount++;
	}

	public DefaultUser() {
	}

	public DefaultUser(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return "First name: " + this.firstName + ", Last name: " + this.lastName + ", Email: " + this.email;
	}

	@Override
	public void setPassword(String password) {
		if (password == null)
			return;
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		if (email == null)
			return; 
		this.email = newEmail;
	}

	@Override
	public int getId() {
		return this.id;
	}

	void clearState() {
		this.userCount = 0;
	}

}
