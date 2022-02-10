package com.revature.bank_app.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.revature.bank_app.util.loggin.Logger;

import com.revature.bank_app.daos.BankDAO;
import com.revature.bank_app.daos.UserDAO;
import com.revature.bank_app.menus.dashboardMenus.BankCreationMenu;
import com.revature.bank_app.menus.dashboardMenus.BankMenu;
import com.revature.bank_app.menus.dashboardMenus.DashboardMenu;
import com.revature.bank_app.menus.startPages.LoginMenu;
import com.revature.bank_app.menus.startPages.RegisterMenu;
import com.revature.bank_app.menus.startPages.WelcomeMenu;
import com.revature.bank_app.services.BankService;
import com.revature.bank_app.services.UserService;

public class AppState {
		
	private static boolean isRunning;//in order to use the boolean outside the class we must make static
	private final MenuRouter router; //creating an unmuttable variable of class Menurouter call router
	//set up application, user should have everything they need
	private final Logger logger;
	 
	
	public AppState() {
		
		//loggin activities
		logger = Logger.getLogger(true);
		logger.log("Bank Application is Starting");
		
		//start application
		isRunning = true; 
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	
		//routing application to welcome pages and menus
		
		//instantiating DAO 
		UserDAO userDAO = new UserDAO();
		BankDAO bankDAO = new BankDAO();
		//instantiating Services
		UserService userService = new UserService(userDAO);
		BankService bankService = new BankService(userService, bankDAO);
		
		//routing menus
		
			//main menu routes
			router.addMenu(new WelcomeMenu(consoleReader, router));
			router.addMenu(new RegisterMenu(consoleReader, router, userService));
			router.addMenu(new LoginMenu(consoleReader, router, userService));
			router.addMenu(new DashboardMenu(consoleReader, router, userService));
			
			//in bank menu
			router.addMenu(new BankMenu(consoleReader, router));
			router.addMenu(new BankCreationMenu(consoleReader, router, bankService));
			//router.addMenu(new Ban);
			
			logger.log("Application initiliazed!");
			
		
	}
	
	public void startup() {
		try {
			
			while(isRunning) {
				router.transfer("/welcome");
			}
		} catch (Exception e) {
			//implement how to deal exception
			e.printStackTrace();
		}
		
	}
	
	public void shutdown() {
		//set to false to terminate program
		isRunning = false;
	}
	
	
}
