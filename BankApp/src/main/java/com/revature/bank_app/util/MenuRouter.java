package com.revature.bank_app.util;

import com.revature.bank_app.menus.Menu;
import com.revature.bank_app.util.collections.LinkedList;

public class MenuRouter {
	
	//create linked list to store the menus
	private final LinkedList<Menu> menus;
	
	public MenuRouter() {
		menus = new LinkedList<>();
	}
	
	public void addMenu(Menu menu) {
		menus.add(menu);
	}
	//implement later 
	public void transfer(String route) throws Exception  {
		// TODO Auto-generated method stub
		//
		for(int i = 0; i < menus.size(); i++) {
			
			Menu currentMenu = menus.get(i);
			
			if(currentMenu.getRoute().equals(route)) {
				currentMenu.render();
			}
		}
	}

}
