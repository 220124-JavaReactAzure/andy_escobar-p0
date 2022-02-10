package com.revature.bank_app.menus.startPages;

import java.io.BufferedReader;

import com.revature.bank_app.exceptions.AuthenticationException;
import com.revature.bank_app.menus.Menu;
import com.revature.bank_app.services.UserService;
import com.revature.bank_app.util.MenuRouter;

public class LoginMenu extends Menu {
	
	UserService userService;

	public LoginMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		// TODO Auto-generated constructor stub
		super("Login", "/login", consoleReader, router); //route login
		this.userService = userService; 
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome To Your Bank Login\n" +
				 		   "Please enter your credentials for you account.");
		
		//take in the user name
	     System.out.println("Username: ");
	     String username = consoleReader.readLine();
	     
	     //take in the password
	     System.out.print("Password: ");
	     String password = consoleReader.readLine();
	     
	     
	     //authentication
	     
	     try {
	    	 userService.authenticateUser(username, password);
	    	 router.transfer("/dashboard");//if password and username match then take them to dashboard
	     }catch(AuthenticationException e) {
	    	 System.out.println("Incorrect username or password");
	     }

	}

}
