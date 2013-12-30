package com.myproj.managedbean;

import javax.faces.bean.ManagedBean;

import com.myproj.model.Customer;


@ManagedBean(name="customerManagedBean")
public class CustomerManagedBean {
	
	private static final long serialVersionUID = 1L;
	private Customer customer=new Customer();
	public Customer getEmployee() {
		customer.setEmpId(1L);
	 
		customer.setFirstName("Ant");
		customer.setLastName("Team");
	return customer;
	}
	public void setEmployee(Customer customer) {
	this.customer = customer;
	}
	
	public String test(){
		return "heyyyhoooot";
	}

}
