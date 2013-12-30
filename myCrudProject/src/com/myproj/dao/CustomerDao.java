package com.myproj.dao;

import com.myproj.model.Customer;

public interface CustomerDao {

	public boolean addEmployee(Customer emp);

	public Customer findCustomerById(long empId);
}
