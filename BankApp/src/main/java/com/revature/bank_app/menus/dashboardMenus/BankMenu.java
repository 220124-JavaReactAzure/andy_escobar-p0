package com.revature.bank_app.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.bank_app.menus.Menu;
import com.revature.bank_app.util.MenuRouter;

public class BankMenu extends Menu {

	public BankMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Bank", "/bank", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to your Bank Account Menu");
		
		System.out.println("Press 1 if you would like to see your Account");
		String view_Bank = consoleReader.readLine();
		
		if(view_Bank == "1") {
			router.transfer("/mybank");
		}
		
		
		
		
		
	}



}
