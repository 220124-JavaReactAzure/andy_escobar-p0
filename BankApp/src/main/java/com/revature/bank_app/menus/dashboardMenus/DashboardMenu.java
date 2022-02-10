package com.revature.bank_app.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.bank_app.menus.Menu;
import com.revature.bank_app.util.MenuRouter;
import com.revature.bank_app.models.User;
import com.revature.bank_app.services.UserService;

public class DashboardMenu extends Menu{

	private final UserService userService;
	
	public DashboardMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("Dashboard", "/dashboard", consoleReader, router);
		this.userService = userService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
		User sessionUser = userService.getSessionUser();

		if (sessionUser == null) {
			System.out.println("You are not currently logged in! Rerouting to the login screen.....");
			router.transfer("/login");
			return;
		}
		
		
		while(userService.isSessionActive()) {
		System.out.println("Welcome " + sessionUser.getFirstName() + " To Dashboard Menu");
		
		
		String menu = "1) View my profile information\n" + 
					  "2) Create Account\n" +
				      "3) View my Account\n" + 
				      "4) Logout\n" + 
				 "> ";

		System.out.print(menu);

		String userSelection = consoleReader.readLine();

		switch (userSelection) {
		case "1":
			System.out.println("View profile selected");
			router.transfer("/viewprofile");
			break;
		case "2":
			System.out.println("Create Account Selected");
			router.transfer("/create-bank");
			break;
		case "3":
			System.out.println("View My Account:");
			router.transfer("/mybank");
			break;
		case "4":
			userService.logout();
			break;
		default:
			System.out.println("Your selection is invalid!!!");
		}
		
	}
	}

}
