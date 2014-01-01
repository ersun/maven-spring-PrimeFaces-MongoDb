package main.services;

import java.util.List;

import com.myproj.model.Customer;

public interface CustomerService {

	public Customer findCustomerById(String id);
	
	public List<Customer> getCustomerList();
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(String id);
}
