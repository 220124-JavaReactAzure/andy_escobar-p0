package com.revature.bank_app.menus.startPages;

import java.io.BufferedReader;

import com.revature.bank_app.exceptions.InvalidRequestException;
import com.revature.bank_app.menus.Menu;
import com.revature.bank_app.models.User;
import com.revature.bank_app.services.UserService;
import com.revature.bank_app.util.MenuRouter;


public class RegisterMenu extends Menu {

	UserService userService;

	public RegisterMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		// TODO Auto-generated constructor stub
			super("Register" , "/register", consoleReader, router);	
			this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("You have selected to Register");

		// Things to obtain from user: first name, last name, email, username, password
		
	
		System.out.println("Please provided information");
		System.out.print("First Name: ");
		String firstName = consoleReader.readLine();

		System.out.print("Last Name: ");
		String lastName = consoleReader.readLine();

		System.out.print("Email: ");
		String email = consoleReader.readLine();
		
		
		//add social security and address

		System.out.print("Username: ");
		String username = consoleReader.readLine();

		System.out.print("Password: ");
		String password = consoleReader.readLine();
		
		

		User user = new User(firstName, lastName, email, username, password);

		
		
		try {
			userService.registerNewUser(user);
		System.out.println("Great Registration Successful");
		router.transfer("/login");
			
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); 
			System.out.println("\nYOU HAVE PROVIDED INVALID DATA PLEASE TRY AGAIN\n\n\n");

			router.transfer("/welcome");
		}
		
	}
	
	
	

}
