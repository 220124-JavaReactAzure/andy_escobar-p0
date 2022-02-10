package com.revature.bank_app.menus.startPages;

import java.io.BufferedReader;

import com.revature.bank_app.menus.Menu;
import com.revature.bank_app.util.MenuRouter;
//import static com.revature.bank_app.util.AppState.shutdown;

public class WelcomeMenu extends Menu {

	public WelcomeMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Welcome", "/welcome", consoleReader, router);
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Escobar Bank"); // Welcome Message
		//ask for menu to route user
		System.out.println("Enter 1) Login Into Your Bank Account" +
						   "	  2) Register For A new Account" +
						   "      3) Exits\n");
		
		
		String userSelection = consoleReader.readLine();//store user input

		switch (userSelection) {
		case "1":
			router.transfer("/login");
			break;
		case "2":
			router.transfer("/register");
			break;
		case "3":
			//shutdown();
			break;
		default:
			System.out.println("Input Is Invalid");
			break;
		}
		
	}

	

}
