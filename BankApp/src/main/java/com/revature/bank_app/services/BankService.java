package com.revature.bank_app.services;

import com.revature.bank_app.daos.BankDAO;
import com.revature.bank_app.exceptions.InvalidRequestException;
import com.revature.bank_app.exceptions.ResourcePersistenceException;
import com.revature.bank_app.models.Bank;

public class BankService {
	
	private final BankDAO bankDAO;
	
	private final UserService userService;

	public BankService(UserService userService, BankDAO bankDAO) {
	
		this.bankDAO = bankDAO;
		this.userService = userService;
		// TODO Auto-generated constructor stub
	}

	public void createBank(Bank newBank) {
		// TODO Auto-generated method stub
		if(!isBankValid(newBank)) {
			throw new InvalidRequestException("The Account is invalid information");
		}
		
		newBank.setCreator(userService.getSessionUser());
		Bank createdBank = bankDAO.create(newBank);
		
		if(createdBank == null) {
			throw new ResourcePersistenceException("The monster could not be persisted");
		}
	}

	private boolean isBankValid(Bank newBank) {
		if(newBank == null)
			return false;
		return(newBank.getBalance()!= 0 && newBank.getBalance() > 0);	
	}
	

	public double getBalance(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	



}
