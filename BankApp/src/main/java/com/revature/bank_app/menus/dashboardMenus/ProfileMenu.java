package com.revature.bank_app.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.bank_app.menus.Menu;
import com.revature.bank_app.models.User;
import com.revature.bank_app.services.UserService;
import com.revature.bank_app.util.MenuRouter;

public class ProfileMenu extends Menu {

	private final UserService userService;
	
	public ProfileMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("Bank", "/viewprofile", consoleReader, router);
		this.userService = userService;
				;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
		User sessionUser = userService.getSessionUser();
		
		System.out.println("Welcome to your Bank Account Menu");

		if (sessionUser == null) {
			System.out.println("You are not currently logged in! Rerouting to the login screen.....");
			router.transfer("/login");
			return;
		}
		
		//display user Profile Information
		System.out.println("First Name: " + sessionUser.getFirstName());
		System.out.println("Last Name: " + sessionUser.getLastName());
		System.out.println("Email: " + sessionUser.getEmail());
		System.out.println("Username: " + sessionUser.getUsername());
	
		System.out.println("\n\nPress 1 if you would like to return to your account Dashboard Menu");
		String view_Bank = consoleReader.readLine();
		
		if(view_Bank == "1") {
			router.transfer("/dashboard");
		}
		
		
		
		
		
	}



}
