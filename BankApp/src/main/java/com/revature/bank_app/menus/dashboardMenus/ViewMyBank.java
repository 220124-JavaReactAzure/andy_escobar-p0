package com.revature.bank_app.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.bank_app.menus.Menu;
import com.revature.bank_app.models.User;
import com.revature.bank_app.services.BankService;
import com.revature.bank_app.services.UserService;
import com.revature.bank_app.util.MenuRouter;

public class ViewMyBank extends Menu {
	
	private final BankService bankService;
	private final UserService userService;

	public ViewMyBank(BufferedReader consoleReader, MenuRouter router, BankService bankService, UserService userService) {
		super("MyBank", "/mybank", consoleReader, router);
		this.bankService = bankService;
		this.userService = userService;
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		User sessionUser = userService.getSessionUser();
		
		double balance = bankService.getBalance(sessionUser.getUserId());
		
		
		System.out.println(sessionUser.getUserId());
		
	
		System.out.println("\nYour " + "accountType" + " balance is: " + balance);
		
		System.out.println("Enter 1: Deposit\n" +
						   "Enter 2: Withdrawal\n" +
						   "Enter 3: Return to Dashboard");
		String userInput = consoleReader.readLine();
		
	
		switch(userInput) {
		case "1":
			System.out.println("How much would you like to deposit");
			double depositAmount = Double.parseDouble(consoleReader.readLine());
			
			bankService.deposit(sessionUser.getUserId(), balance, depositAmount);
			break;
		case "2":
			System.out.println("How much would you like to withdrawal");
			double withdrawAmount = Double.parseDouble(consoleReader.readLine());
			if(balance < withdrawAmount) {
				System.out.println("Insuficient Funds:");
			}else if(balance > withdrawAmount) {
				bankService.withdrawFromBank(sessionUser.getUserId(), balance, withdrawAmount);
			}
			break;
		case "3":
			router.transfer("/dashboard");
			break;
		}
		
		
	
		System.out.println("Would you like to return to the dashboard menu? Type y or yes");
		
		String selection = consoleReader.readLine();
		
		if(selection == "y" || selection == "yes") {
			router.transfer("/dashboard");
		}else {
			System.out.println("\nThe command you type is not recognized");
		}
		
		
	}

}
