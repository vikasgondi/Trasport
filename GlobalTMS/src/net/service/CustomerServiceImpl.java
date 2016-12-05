package net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dao.CustomerDao;
import net.model.Customer;
@Service("customerService")
@Transactional
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	private CustomerDao customerdao;
	@Override
	
	public void signUp(Customer customer) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Service");
		 customerdao.registerCustomer(customer);
	}

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		
		return customerdao.loginCustomer(email, password);
	}

	@Override
	public List<Customer> listCustomers() {
		// TODO Auto-generated method stub
		return customerdao.listCustomer();
	}

	@Override
	public List<Customer> custDetail(String email) {
		// TODO Auto-generated method stub
		return customerdao.customerDetail(email);
	}
	

}
