package net.dao;

import java.util.List;

import net.model.Customer;

public interface CustomerDao {
public void registerCustomer(Customer customer) throws Exception;
public boolean loginCustomer(String email, String password);
public List<Customer> listCustomer();
public List<Customer> customerDetail(String email);

}
