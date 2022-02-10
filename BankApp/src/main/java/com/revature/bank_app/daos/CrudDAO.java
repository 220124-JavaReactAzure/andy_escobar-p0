package com.revature.bank_app.daos;

import com.revature.bank_app.util.collections.List;

public interface CrudDAO<T> {
		//create read update delete

	//create
	T create(T newObj);

	//read
	T findById(String id);

	List<T> findAll();

	
	//update
	boolean update(T updateObj);
	
	//delete
	boolean delete(String id);

	boolean update(Double updateBalance, String BankId);

	
	
}
