package com.revature.bank_app.menus;

import java.io.BufferedReader;

import com.revature.bank_app.util.MenuRouter;

public abstract class Menu {
	
	protected String name;
	protected String route;
	protected BufferedReader consoleReader;
	protected MenuRouter router;
	
	
	//constructor
	public Menu(String name, String route, BufferedReader consoleReader, MenuRouter router) {
		super();
		this.name = name;
		this.route = route;
		this.consoleReader = consoleReader;
		this.router = router;
	}

	//getters and setters

	public String getName() {
		return name;
	}


	public String getRoute() {
		return route;
	}

	//render method to be implemented by other menus
	
	public abstract void render() throws Exception;
	
	
	
}
