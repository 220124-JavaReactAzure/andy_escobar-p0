package com.revature.bank_app.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.bank_app.menus.Menu;
import com.revature.bank_app.util.MenuRouter;

public class ViewMyBank extends Menu {
	
	

	public ViewMyBank(BufferedReader consoleReader, MenuRouter router) {
		super("MyBank", "/mybank", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
//		User sessionUser = userService.getSessionUser();
//		
//		double balance = bankService.getBalance(sessionUser.getUsername());
//		
//		
//		System.out.println("Your balance is: " + balance);
		
		System.out.println("View My Bank Menu");
//		
		System.out.println("Would you like to return to the dashboard menu? Type y or yes");
		
		String selection = consoleReader.readLine();
		
		if(selection == "y" || selection == "yes") {
			router.transfer("/dashboard");
		}else {
			System.out.println("The command you type is not recognized");
		}
		
		
	}

}
