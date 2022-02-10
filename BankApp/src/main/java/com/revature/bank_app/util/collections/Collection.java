package com.revature.bank_app.util.collections;

public interface Collection<T> {
	//
	boolean add(T element);
	
	//Contains
	boolean contains(T element);
	
	boolean isEmpty();
	
	boolean remove(T elements);
	
	//capacity
	int size();
}
