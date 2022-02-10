package com.revature.bank_app.services;

import com.revature.bank_app.daos.BankDAO;
import com.revature.bank_app.exceptions.InvalidRequestException;
import com.revature.bank_app.exceptions.ResourcePersistenceException;
import com.revature.bank_app.models.Bank;
import com.revature.bank_app.models.User;
import com.revature.bank_app.util.collections.List;

public class BankService {
	
	private final BankDAO bankDAO;
	
	private final UserService userService;
	
	private Bank sessionBank;

	public BankService(UserService userService, BankDAO bankDAO) {
	
		this.bankDAO = bankDAO;
		this.userService = userService;
		
		//create logg if time is available
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
			throw new ResourcePersistenceException("The Account could not be persisted");
		}
	}

	private boolean isBankValid(Bank newBank) {
		if(newBank == null)
			return false;
		return(newBank.getBalance()!= 0 && newBank.getBalance() > 0);	
	}
	

	public double getBalance(String bankId) {
		return bankDAO.getBalance(bankId);
	}

	public boolean withdrawFromBank(String userId, double balance, double withdrawAmount) {
		// TODO Auto-generated method stub
		withdrawAmount = balance - withdrawAmount;
		return bankDAO.update(withdrawAmount, userId);
		
	}
	
	public boolean deposit(String userId, double balance, double depositAmount) {
		
		depositAmount = balance + depositAmount;
		
		return bankDAO.update(depositAmount, userId);
		
	}
	
	public List<Bank> findMyBanks(){
		return null;
	}
	
	public List<Bank> findAllBanks(){
		return null;
	}

	public void updateBank(Bank newBank) {
		newBank.setCreator(userService.getSessionUser());
		
		boolean createdBank = bankDAO.update(newBank);

		if (!createdBank) {
			throw new ResourcePersistenceException("The Account could not be persisted");
		} else {
			setSessionBank(newBank);
		}		
		
	}

	private Bank setSessionBank(Bank newBank) {
		// TODO Auto-generated method stub
		return sessionBank;
	}
	



}
