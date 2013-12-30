package main.services;

import com.myproj.model.Customer;

public interface CustomerService {

	public Customer findCustomerById(Long id);
}
