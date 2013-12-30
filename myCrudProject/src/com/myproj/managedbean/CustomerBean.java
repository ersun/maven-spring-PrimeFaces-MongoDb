package com.myproj.managedbean;

import java.io.Serializable;


import main.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.model.Customer;


@Component("empBean")
public class CustomerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Customer employee=new Customer();
	
	@Autowired(required=true)
	CustomerService empService;
	
	public Customer getEmployee() {
	employee= empService.findCustomerById(1L);
	return employee;
	}
	public void setEmployee(Customer employee) {
	this.employee = employee;
	}
	 
	
	
	
}
