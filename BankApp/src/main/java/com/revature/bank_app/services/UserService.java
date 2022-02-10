package com.revature.bank_app.services;

import com.revature.bank_app.daos.UserDAO;
import com.revature.bank_app.exceptions.AuthenticationException;
import com.revature.bank_app.exceptions.InvalidRequestException;
import com.revature.bank_app.exceptions.ResourcePersistenceException;
import com.revature.bank_app.models.User;


public class UserService {

	private final UserDAO userDAO;//instantiating a final version of DAO
	private User sessionUser;//creating a sessionUSER variable to hold who is logged in
	
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
		this.sessionUser = null; //
		// TODO Auto-generated constructor stub
	}
	
	public User getSessionUser() {
		return sessionUser;
	}

	public User registerNewUser(User newUser) {
		
		//determine if user is valid 
		if(!isUserValid(newUser)) {
			throw new InvalidRequestException("Invalid user");
		}
		
		boolean usernameAvailable = userDAO.findByUsername(newUser.getUsername()) == null;
		boolean emailAvailable = userDAO.findByEmail(newUser.getEmail()) == null;
		
		
		//determine if user credentials to register are available 
		if(!usernameAvailable || !emailAvailable) {
			if(!usernameAvailable && emailAvailable) {
				throw new ResourcePersistenceException("The provided username was already taken in the database");
			} else if(usernameAvailable) {
				throw new ResourcePersistenceException("The provided email was already taken in the database");
			} else {
				throw new ResourcePersistenceException("The provided username and email were already taken in the database");
			}
		}
		
		User persistedUser = userDAO.create(newUser);
		
		if(persistedUser == null) {
			throw new ResourcePersistenceException("The user could not be persisted");
		}

		return persistedUser;
	}

	public void authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		
		//
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
		}
		
		User authenticatedUser = userDAO.findByUsernameAndPassword(username, password);
		
		if(authenticatedUser == null) {
			throw new AuthenticationException("Unauthenticated user, information provided was not found in our database.");
		}
		sessionUser = authenticatedUser;
	}

	
	private boolean isUserValid(User newUser) {
		
		if(newUser == null)
			return false;
			
		if(newUser.getFirstName() == null || newUser.getFirstName().trim().equals(""))
			return false;
		
		if(newUser.getLastName() == null || newUser.getLastName().trim().equals("")) 
			return false;
		
		if(newUser.getEmail() == null || newUser.getEmail().trim().equals("")) 
			return false;
		
		if(newUser.getUsername() == null || newUser.getUsername().trim().equals("")) 
			return false;
		
		
		return newUser.getPassword() != null && !newUser.getPassword().trim().equals("");
		

	}


	public boolean isSessionActive() {
		// TODO Auto-generated method stub
		return sessionUser != null;
		
	}

	
	public void logout() {
		sessionUser = null;	
	}

	
	
}
