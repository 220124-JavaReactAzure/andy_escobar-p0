package com.revature.bank_app.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.bank_app.menus.Menu;
import com.revature.bank_app.models.Bank;
import com.revature.bank_app.services.BankService;
import com.revature.bank_app.util.MenuRouter;

public class BankCreationMenu extends Menu {

	private final BankService bankService;
	
	public BankCreationMenu(BufferedReader consoleReader, MenuRouter router, BankService bankService) {
		super("BankCreation", "/create-bank", consoleReader, router);
		this.bankService = bankService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Create Bank Account\n" + "Fill out the Account Attributes Below");
		
		System.out.println("1 - Type: Credit or Debit");
		String bankType = consoleReader.readLine();
		System.out.println("2 - Starting Balance");
		String bankBalance = consoleReader.readLine();
		
		Double balance = Double.parseDouble(bankBalance);
		
		Bank newBank = new Bank(bankType, balance);
		
		bankService.createBank(newBank);

	}

}
