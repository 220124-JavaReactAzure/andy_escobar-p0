package com.revature.bank_app.models;

public class Bank {
	private String bankId;
	private double balance;
	private String userId;
	private String type; //between debit or credit account
		
	public Bank() {
		super();
	}
	
	public Bank(String bankId, double balance, String type, String userId) {
		// TODO Auto-generated constructor stub
		super();
		this.bankId = bankId;
		this.balance = balance;
		this.type = type;
		this.userId = userId;
	}

	public Bank(String type, double balance) {
		super();
		this.type = type;
		this.balance = balance;
	}

	//auto generated getters and setters 
	
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

	//auto generated auto toString
	
	@Override
	public String toString() {
		return "Bank [id=" + bankId + ", balance=" + balance + ", userId=" + userId + ", type=" + type + "]";
	}


	public void getUserId(String userId) {
		// TODO Auto-generated method stub
		this.userId = userId;
	}

	public void setCreator(User sessionUser) {
		// TODO Auto-generated method stub
		
	}
		
}
