package net.service;

import java.util.List;

import net.model.Customer;

public interface CustomerService {

	public void signUp(Customer customer) throws Exception;
	
	public boolean login(String email, String password);
	public List<Customer> listCustomers();
	public List<Customer> custDetail(String email);
}
