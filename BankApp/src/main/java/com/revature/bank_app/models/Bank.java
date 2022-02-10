package com.revature.bank_app.models;

public class Bank {
	private String bankId;
	private double balance;
	private String userId;
	private String type; //between debit or credit account
	private User creator;
	
	public Bank() {
		super();
	}
	
	public Bank(String bankId, double balance, String type, String userId, User creator) {
		// TODO Auto-generated constructor stub
		super();
		this.bankId = bankId;
		this.balance = balance;
		this.type = type;
		this.userId = userId;
		this.creator = creator;
	}

	public Bank(String type, double balance) {
		super();
		this.type = type;
		this.balance = balance;
	}
	
	public Bank(String type, double balance, User creator) {
		super();
		this.balance = balance;
		this.type = type;
		this.creator = creator;
	}

	//public void setUserId(int userId) {
	//	this.userId = userId;
	//}
	public String getType() {
		return type;
	}
	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

		
}
