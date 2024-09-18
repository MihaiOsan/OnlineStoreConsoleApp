package main;
import menu.Menu;

import entities.User;
import entities.impl.DefaultUser;
import menu.impl.MainMenu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

public class Main {

	public static final String EXIT_COMMAND = "exit";

	public static void main(String[] args) {
		
		
		UserManagementService testInstance;
		testInstance = DefaultUserManagementService.getInstance();
		
		User user = new DefaultUser();
		user.setEmail("t");
		
		testInstance.registerUser(user);
		
		System.out.print(user);
		
		
		
		Menu mainMenu = new MainMenu();
		mainMenu.start();
	}

}
